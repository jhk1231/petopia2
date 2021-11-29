package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.service.member.MemberService;
import com.example.vo.member.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberSerivice;
	
	@GetMapping("/members")
	public String callMemberList(Model model) {
		List<MemberVO> lst = this.memberSerivice.retrieveMemberList(0, 0);
		model.addAttribute(lst);
		return "memberList";
	}
	
	@GetMapping("/members/{no}")
	public String callMemberDetail(Model model, @PathVariable int no) {
		MemberVO member = this.memberSerivice.retrieveMemberByManager(no);
		model.addAttribute(member);
		model.addAttribute("managerContent","/fragments/view/ManagerContent");
		return "view/member/detailMemberByManager";
	}
	
	
}
