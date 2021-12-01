package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.member.MemberService;
import com.example.vo.member.MemberVO;

import lombok.extern.slf4j.Slf4j;


//여기부터가 기본 세팅
@Slf4j
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
//기본 세팅 끝
	
//	회원가입
	@PostMapping("/join")  //이걸 실행하는 값의 주소
	public String joinMember(MemberVO mVo) { 
		this.memberService.registerMember(mVo);
		return "redirect:/"; //string으로 리턴되는건 html 파일로 넘어감! (회원가입 다음 로그인화면으로 넘어가고 싶다면 templates 안에 있는 로그인 html 파일명 쓰기)
	}
//
//	@GetMapping("/members")
//	public String callMemberList(Model model) {
//		List<MemberVO> lst = this.memberService.retrieveMemberList(0, 0);
//		model.addAttribute(lst);
//		return "memberList";
//	}
//	
//	@GetMapping("/members/{no}")
//	public String callMemberDetail(Model model, @PathVariable int no) {
//		MemberVO member = this.memberService.retrieveMemberByManager(no);
//		model.addAttribute(member);
//		model.addAttribute("managerContent","/fragments/view/ManagerContent");
//		return "view/member/detailMemberByManager";
//	}
	
}
