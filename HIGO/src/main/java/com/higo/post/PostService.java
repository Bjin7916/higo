package com.higo.post;

import java.util.List;
import java.util.Map;

import com.higo.c_ment.CommentDAO;
import com.higo.member.MemberDAO;
import com.higo.postFile.PostFileDAO;
import com.higo.postFile.PostFileVO;

public class PostService {
	
	public PostDAO postDao;
	public MemberDAO memberDao;
	public PostFileDAO postFileDao;
	public CommentDAO commentDao;
	
	public CommentDAO getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDAO commentDao) {
		this.commentDao = commentDao;
	}

	public MemberDAO getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public PostFileDAO getPostFileDao() {
		return postFileDao;
	}

	public void setPostFileDao(PostFileDAO postFileDao) {
		this.postFileDao = postFileDao;
	}

	public PostDAO getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDAO postDao) {
		this.postDao = postDao;
	}

	public void setBoardDao(PostDAO boardDao) {
		this.postDao = boardDao;
	}
	
	public List<PostVO> selectList(Map<String, Object> map){
		List<PostVO> list = postDao.selectList(map);
		
		if(list.isEmpty()) {
			System.out.println(list);
			list = null;
		}
		
		return list;
	}
	
	public PostVO selectOne(int post_seq) {
		return postDao.selectOne(post_seq);
	}
	
	public int getTotal(Map<String, Object> map) {
		return postDao.getTotal(map);
	}
	
	public int getSeq() {
		return postDao.getSeq();
	}
	
	public int update(PostVO vo) {
		return postDao.update(vo);
	}
	
	public int delete(int seq) {
		return postDao.delete(seq);
	}

	public int insert(PostVO vo) {
		return postDao.insert(vo);
	}
	
	public void fileInsert(int post_seq, List<String> fileList) {
		for(String fileName : fileList) {
			System.out.println(postFileDao.insert(new PostFileVO(post_seq,fileName)));
		}
	}
	
	public List<PostFileVO> fileSelectList(int post_seq){
		return postFileDao.selectList(post_seq);
	}
	
	public int getseq() {
		return postDao.getSeq();
	}
	
	//마이페이지에서 내가 작성한 글 띄우기
	public List<PostVO> mPList(int member_seq){
		List<PostVO> list = postDao.mPList(member_seq);
				
				if(list.isEmpty()) {
					System.out.println(list);
					list = null;
				}
				
				return list;
		}
	//조회수
	public int hitCnt(PostVO vo) {
		return postDao.hitCnt(vo);
	}
	//게시판 전체 post_seq 가져오기
//	public int allPost() {
//		return postDao.allPost();
//	}
}
