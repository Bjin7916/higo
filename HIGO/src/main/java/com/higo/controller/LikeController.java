package com.higo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.higo.c_ment.CommentService;
import com.higo.c_ment.CommentVO;
import com.higo.commentlike.CommentLikeService;
import com.higo.commentlike.CommentLikeVO;
import com.higo.post.PostService;
import com.higo.post.PostVO;
import com.higo.postLike.PostLikeService;
import com.higo.postLike.PostLikeVO;

import common.ViewPath;

@Controller
public class LikeController {
	
	private PostService postService;
	private CommentService commentService;
	private PostLikeService postLikeService;
	private CommentLikeService commentLikeService;
	
	public LikeController(PostService postService, CommentService commentService, PostLikeService postLikeService, CommentLikeService commentLikeService) {
		this.postService = postService;
		this.commentService = commentService;
		this.postLikeService = postLikeService;
		this.commentLikeService = commentLikeService;
	}
	
	@RequestMapping("/like/Postlike")
	public String Postlike(PostLikeVO plvo, PostVO vo, HttpServletRequest request) {
		
		Integer member_seq = (Integer)request.getSession().getAttribute("mlogin");
		int post_seq = Integer.parseInt(request.getParameter("seq"));
//		System.out.println(post_seq);
		plvo.setMember_seq(member_seq);
		plvo.setPost_seq(post_seq);
		
		int postLike_seq = 0;
		
		PostLikeVO check = postLikeService.selectOne(plvo);
		if(check != null) {
			postLikeService.delete(plvo);
		}else {
			postLikeService.insert(plvo);
			plvo.setPostLike_seq(postLike_seq);
		}
		
		
		
		return "redirect:/post/content/" + plvo.getPost_seq();
	}
	
	

}
