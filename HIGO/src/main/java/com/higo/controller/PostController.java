package com.higo.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.higo.c_ment.CommentService;
import com.higo.c_ment.CommentVO;
import com.higo.member.MemberService;
import com.higo.post.PostService;
import com.higo.post.PostVO;
import com.higo.postFile.PostFileVO;
import com.higo.postLike.PostLikeService;

import common.Paging;
import common.Setting;
import common.ViewPath;

@Configuration
@PropertySource("classpath:config/globals.properties")

@Controller
public class PostController {

	private PostService postService;

	private MemberService memberService;
	private PostLikeService postLikeService;
	private CommentService commentService;

	@Value("${globals.dir}")
	private String FILEPATH;

	@Autowired // 자동 주입
	private ServletContext application;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigPlaceon() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public PostController(PostService postService, MemberService memberService, CommentService commentService, PostLikeService postLikeService) {
		this.postService = postService;
		this.memberService = memberService;
		this.commentService = commentService;
		this.postLikeService = postLikeService;
	}

	@RequestMapping("/post/list")
	public String list(Model model, Integer page, String type, String word, HttpSession session) {

		// type이 빈 문자열이면 null값으로 바꿔치기 하자...
		// System.out.println(type);

		//검색 타입 비교하기
		type = "".equals(type) ? null : type;
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("type", type);
		map.put("word", word);

		// int post_seq = postService.

		if (page == null) {
			page = 1;
		}
	
		int postCount = postService.getTotal(map);

		Paging paging = new Paging(page, postCount);

		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());

		List<PostVO> list = postService.selectList(map);

		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

		return ViewPath.POST + "list.jsp";
	}

	@RequestMapping("/post/writeForm")
	public String writeForm() {
		return ViewPath.POST + "write.jsp";
	}

	@RequestMapping("/post/write")
	public String write(HttpServletRequest request, PostVO vo) {

		Integer member_seq = (Integer) request.getSession().getAttribute("mlogin");
		if(member_seq != null) {
			vo.setMember_seq(member_seq);
		}

		String title = vo.getPost_title();
		String content = vo.getPost_content();

		vo.setPost_content(content.replaceAll("\r\n", "<br>"));
		vo.setPost_title(title);

		// 파일을 저장할 경로....
		String savePath = FILEPATH + "upload\\";
//		String savePath = application.getRealPath("/resources/upload/");

		MultipartFile photo = vo.getPhoto();

		String fileName = null;

		if (!photo.isEmpty()) {

			// 업로드된 실제파일명
			fileName = photo.getOriginalFilename();

			// File 객체 생성
			File saveFile = new File(savePath, fileName);

			if (!saveFile.exists()) { // 경로에 파일이 없으면
				saveFile.mkdirs();
			} else { // 있으면
				long time = System.currentTimeMillis();

				fileName = String.format("%s%d%s", fileName.substring(0, fileName.lastIndexOf(".")), time,
						fileName.substring(fileName.lastIndexOf(".")));

				saveFile = new File(savePath, fileName);
			}

			// 업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시저장소에 저장되어 있다...
			// 파일이 일정시간이 지나면 사라지기때문에 내가 지정한 경로로 복사해준다...
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			vo.setFileName(fileName);
		}

		int seq = postService.getseq();
		content = content.replaceAll("getImg", "getImgLoad/" + seq);
		vo.setPost_content(content);
		vo.setPost_seq(seq);
		try {
			summerCopy(vo.getFileList(), seq); // 파일 위치 변경
		} catch (Exception e) {
			e.printStackTrace();
		}

		int check = postService.insert(vo);

		try {
			postService.fileInsert(seq, vo.getFileList());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		String url = null;
		if (check != 0) {
			msg = "글쓰기 성공!";
			url = "/higo/post/content/" + vo.getPost_seq();
		} else {
			msg = "글쓰기 실패!";
			url = "/higo/post/writeForm";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return ViewPath.POST + "result.jsp";
	}

	@RequestMapping("/post/updateForm")
	public String updateForm(Model model, HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));

		PostVO vo = postService.selectOne(seq);

		model.addAttribute("vo", vo);

		return ViewPath.POST + "update.jsp";
	}

	@RequestMapping("/post/update")
	public String update(HttpServletRequest request, PostVO vo) {

		Integer member_seq = (Integer) request.getSession().getAttribute("mlogin");

		vo.setMember_seq(member_seq);

		String title = vo.getPost_title();
		String content = vo.getPost_content();

		// 파일을 저장할 경로....
		String savePath = FILEPATH + "upload\\";
//				String savePath = application.getRealPath("/resources/upload/");

		MultipartFile photo = vo.getPhoto();

		String fileName = null;

		if (!photo.isEmpty()) {

			// 업로드된 실제파일명
			fileName = photo.getOriginalFilename();

			// File 객체 생성
			File saveFile = new File(savePath, fileName);

			if (!saveFile.exists()) { // 경로에 파일이 없으면
				saveFile.mkdirs();
			} else { // 있으면
				long time = System.currentTimeMillis();

				fileName = String.format("%s%d%s", fileName.substring(0, fileName.lastIndexOf(".")), time,
						fileName.substring(fileName.lastIndexOf(".")));

				saveFile = new File(savePath, fileName);
			}

			// 업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시저장소에 저장되어 있다...
			// 파일이 일정시간이 지나면 사라지기때문에 내가 지정한 경로로 복사해준다...
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			vo.setFileName(fileName);
		}

		int seq = postService.getseq();
		vo.setPost_content(content.replaceAll("getImg", "getImgLoad/" + seq));
		vo.setPost_title(title);

		try {
			summerCopy(vo.getFileList(), seq); // 파일 위치 변경
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			postService.fileInsert(seq, vo.getFileList());
		} catch (Exception e) {
			e.printStackTrace();
		}

		int check = postService.update(vo);

		try {
			postService.fileInsert(seq, vo.getFileList());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg = null;
		String url = null;

		if (check != 0) {
			msg = "업데이트 성공!";
			url = "/higo/post/content/" + vo.getPost_seq();

		} else {
			msg = "업데이트 실패!";
			url = "/higo/post/updateForm";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return ViewPath.POST + "result.jsp";
	}

	@RequestMapping("/post/delete")
	public String delete(HttpServletRequest request, PostVO vo) {

		int seq = Integer.parseInt(request.getParameter("seq"));

		int check = postService.delete(seq);

		String msg = null;
		String url = null;

		if (check != 0) {
			msg = "삭제 성공!";
			url = "/higo/post/list";

		} else {
			msg = "삭제 실패!";
			url = "/higo/post/delete";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return ViewPath.POST + "result.jsp";
	}

	@RequestMapping("/post/content/{post_seq}")
	public String content(CommentVO cvo, Model model, @PathVariable("post_seq") int post_seq,
			HttpServletRequest request, HttpServletResponse response) {
		Integer mlogin = (Integer)request.getSession().getAttribute("mlogin");
		if(mlogin ==null) {
			mlogin=0;
			Setting.alertAndGo(response, "로그인 후 이용부탁", "/higo/login/loginForm");
		}
		
		PostVO vo = postService.selectOne(post_seq);
		List<PostFileVO> list = postService.fileSelectList(post_seq);

		int hit_cnt = vo.getPost_hit();

		if (vo.getMember_seq() != mlogin) {
			hit_cnt += 1;
			vo.setPost_hit(hit_cnt);
			postService.hitCnt(vo);
		}

		List<CommentVO> commentlist = commentService.commentList(post_seq);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("post_seq", post_seq);
		map.put("member_seq", mlogin);
		
		int likeCheck = postLikeService.likeCheck(map);
		
		String like = "";
		
		if(likeCheck >= 1) {
			like = "you liked this";
		}else {
			like = "like";
		}
		
		model.addAttribute("list", commentlist);
		model.addAttribute("vo", vo);
		model.addAttribute("files", list);
		model.addAttribute("like", like);
		

		return ViewPath.POST + "content.jsp";
	}

	@RequestMapping("/post/download/{seq}")
	public void download(@PathVariable("seq") int seq, String fn, HttpServletResponse response) throws IOException {
		File f = new File(FILEPATH + "/upload/" + seq + "/", fn);
		// file 다운로드 설정
		response.setContentType("application/download");
		response.setContentLength((int) f.length());
		response.setHeader("Content-disposition", "attachment;filename=\"" + fn + "\"");
		// response 객체를 통해서 서버로부터 파일 다운로드
		OutputStream os = response.getOutputStream();
		// 파일 입력 객체 생성
		FileInputStream fis = new FileInputStream(f);
		FileCopyUtils.copy(fis, os);
		fis.close();
		os.close();

	}

	@RequestMapping("/comment/writeComment")
	public String writeComment(CommentVO cvo, HttpServletRequest request) {

		//System.out.println(cvo.getComm_seq());
		Integer member_seq = (Integer) request.getSession().getAttribute("mlogin");

		//int post_seq = Integer.parseInt(request.getParameter("post_seq"));
		cvo.setMember_seq(member_seq);
		// cvo.setComm_content(cvo.getComm_content());
		//cvo.setPost_seq(post_seq);
		//System.out.println(cvo.getPost_seq());
		
		int comm_seq = commentService.getSeq();
		
		// 답글인경우
		if (cvo.getComm_seq() != 0) {
			CommentVO ref = commentService.selectOne(cvo.getComm_seq());
			//System.out.println(ref.getComm_content());
			cvo.setComm_groupNum(ref.getComm_groupNum());
			cvo.setComm_step(ref.getComm_step() + 1);
			cvo.setComm_depth(ref.getComm_depth() + 1);
		} else {
			cvo.setComm_groupNum(comm_seq);
		}

		cvo.setComm_seq(comm_seq);
		System.out.println(cvo.getComm_content());

		commentService.insert(cvo);

		
		return "redirect:/post/content/" + cvo.getPost_seq();
	}

	@RequestMapping("/summer_image")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile,
			HttpServletRequest request) throws IOException {
		JsonObject json = new JsonObject();

		String fileRoot = FILEPATH + "/upload/copy/";
		String originalFileName = multipartFile.getOriginalFilename(); // 오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자

		String savedFileName = UUID.randomUUID() + extension; // 저장될 파일 명
		File targetFile = new File(fileRoot + savedFileName);
		System.out.println(targetFile);
		try {
			// 파일 저장
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);

			// 파일을 열기위하여 common/getImg 호출 / 파라미터로 savedFileName 보냄.
			json.addProperty("url", "/higo/common/getImg?savedFileName=" + savedFileName);
			json.addProperty("responseCode", "success");

		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);
			json.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String jsonvalue = json.toString();

		return jsonvalue;
	}

	@RequestMapping(value = "/common/getImg", method = RequestMethod.GET)
	public void getImg(@RequestParam(value = "savedFileName") String savedFileName, HttpServletResponse response)
			throws Exception {
		String filePath;
		String DIR = FILEPATH + "/upload/copy/";
		filePath = DIR + savedFileName;
		getImage(filePath, response);
	}

	@RequestMapping(value = "/common/getImgLoad/{seq}", method = RequestMethod.GET)
	public void getImgCopy(@RequestParam(value = "savedFileName") String savedFileName,
			@PathVariable("seq") int post_seq, HttpServletResponse response) throws Exception {
		String filePath;
		String DIR = FILEPATH + "/upload/" + post_seq + "/";
		filePath = DIR + savedFileName;
		getImage(filePath, response);
	}

	private void getImage(String filePath, HttpServletResponse response) throws IOException {
		File file = new File(filePath);
		if (!file.isFile()) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('조회된 정보가 없습니다.'); self.close();</script>");
			out.flush();
			return;
		}

		FileInputStream fis = null;

		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;
		try {
			fis = new FileInputStream(file);
			in = new BufferedInputStream(fis);
			bStream = new ByteArrayOutputStream();
			int imgByte;
			while ((imgByte = in.read()) != -1) {
				bStream.write(imgByte);
			}

			String type = "";
			String ext = FilenameUtils.getExtension(file.getName());
			if (ext != null && !"".equals(ext)) {
				if ("jpg".equals(ext.toLowerCase())) {
					type = "image/jpeg";
				} else {
					type = "image/" + ext.toLowerCase();
				}

			} else {
				System.err.println("Image fileType is null.");
			}

			response.setHeader("Content-Type", type);
			response.setContentLength(bStream.size());

			bStream.writeTo(response.getOutputStream());

			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bStream != null) {
				try {
					bStream.close();
				} catch (Exception est) {
					est.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception ei) {
					ei.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception efis) {
					efis.printStackTrace();
				}
			}
		}
	}

	public Map<String, Object> summerCopy(List<String> fileList, int seq) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		// 원본 파일경로
		for (int i = 0; i < fileList.size(); i++) {
			String oriFilePath = FILEPATH + "upload\\copy\\" + fileList.get(i);

			// 복사될 파일경로
			String copyFilePath = FILEPATH + "upload\\" + seq + "\\" + fileList.get(i);
			File copy = new File(FILEPATH + "upload\\" + seq + "\\");

			if (!copy.exists()) { // 경로에 파일이 없으면
				copy.mkdirs();
			}

			try {
				FileInputStream fis = new FileInputStream(oriFilePath); // 읽을파일
				FileOutputStream fos = new FileOutputStream(copyFilePath); // 복사할파일
				int data = 0;
				while ((data = fis.read()) != -1) {
					fos.write(data);
				}
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			File del = new File(oriFilePath);
			del.delete();
		}

		result.put("SUCCESS", true);
		return result;
	}
}
