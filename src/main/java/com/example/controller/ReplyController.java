package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.board.ReplyService;
import com.example.vo.board.ReplyVO;
import com.example.vo.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;

	
	@ResponseBody
	@PostMapping("/insertReply")
	public List<ReplyVO> insertReply(@RequestParam("articleNo") int articleNo,
										@RequestParam("content") String content,
										HttpServletRequest req) {
		// create
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		int memberNo = member.getNo();
		String nickname = member.getNickname();
		ReplyVO reply = new ReplyVO(articleNo, memberNo, nickname, content);
		
		// bind
		this.replyService.registerReply(reply); // DB insert
		List<ReplyVO> replyList = this.replyService.retrieveAllReply(articleNo); // select Replys

		return replyList;
	}
	
	@ResponseBody
	@PostMapping("/modifyReply")
	public List<ReplyVO> updateReply(@RequestParam("no") int replyNo,
														@RequestParam("articleNo") int articleNo,
														@RequestParam("content") String content){
		ReplyVO reply = new ReplyVO(replyNo, content);
		log.info("modifyReplyVO = {}", reply.toString());
		// 댓글 수정
		this.replyService.modifyReply(reply);
		// 수정 완료된 댓글 List 받기
		List<ReplyVO> replyList =this.replyService.retrieveAllReply(articleNo);
		for (ReplyVO replyVO : replyList) {
			log.info("replyList = {}", replyVO);
		}
		return replyList;
	}
	
	@ResponseBody
	@GetMapping("/removeReply")
	public List<ReplyVO> deleteReply(@RequestParam("no") int replyNo,
														@RequestParam("articleNo") int articleNo){
		this.replyService.removeReply(replyNo); // 댓글 삭제
		List<ReplyVO> replyList = this.replyService.retrieveAllReply(articleNo); // 목록 출력
		
		return replyList;
	}

}
