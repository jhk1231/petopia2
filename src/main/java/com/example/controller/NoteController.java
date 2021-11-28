package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.etc.NoteService;
import com.example.vo.etc.NoteVO;
import com.example.vo.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NoteController {
	@Autowired
	NoteService service;
	
	private static final int POST_PER_PAGE = 3;
	private static final int PAGE_BLOCK = 3;
	
//	map.put("/noteDetailBoard.do", "controller.NoteDetailFormCommand");
//	map.put("/writeNote.do", "controller.WriteNoteCommand");
//	map.put("/deleteNote.do", "controller.NoteDeleteCommand");
//	map.put("/sendMail.do", "controller.MailCommand");
	
	@GetMapping("/notedetail")
	public String noteDetail(@RequestParam int isRecieve, @RequestParam int noteContentNo, @RequestParam int noteNo, Model model, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("loginUser");
		
		NoteVO note = service.retriveNote(noteNo);
		
		// 받은 쪽지를 상세조회 할 경우
		if(isRecieve == 1 && note.isRead() == false)
			service.updateRead(noteContentNo, user.getNo());

		model.addAttribute("note", note);
		model.addAttribute("isRecieve", isRecieve);
		
		return "view/etc/notedetail";
	}
	
	@GetMapping("/notelist")
	public String noteList(@RequestParam(defaultValue="1") int isRecieve, @RequestParam(defaultValue="1") int currentPage, Model model, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		//log.info(user.toString());
		
		List<NoteVO> notelist = service.selectNoteList(user.getNo(), isRecieve, 10, (currentPage - 1) * POST_PER_PAGE);
		//notelist.forEach(m -> System.out.println(m.toString()));
		model.addAttribute("notelist", notelist);
		model.addAttribute("isRecieve", isRecieve);
	
		int currentBlock = currentPage % PAGE_BLOCK == 0 ? currentPage / PAGE_BLOCK : currentPage / PAGE_BLOCK + 1;

		int startPage = 1 + (currentBlock - 1) * PAGE_BLOCK;
		int endPage = startPage + (PAGE_BLOCK - 1);

		int totalPostCount = service.retriveTotalNoteCount(user.getNo(), isRecieve);

		int totalPage = totalPostCount % POST_PER_PAGE == 0 ? totalPostCount / POST_PER_PAGE : totalPostCount / POST_PER_PAGE + 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		model.addAttribute("pageBlock", PAGE_BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalPostCount", totalPostCount);
		model.addAttribute("postSize", POST_PER_PAGE);
		
		
		return "view/etc/note";
	}
	
	
}
