package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.member.MemberService;
import com.example.vo.member.MemberVO;

//여기부터가 기본 세팅
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
//기본 세팅 끝
	
	//회원가입
	@GetMapping("/join")  //회원가입 창이 나타나는 url 주소창
	public String joinMember(MemberVO mVo) { 
		this.memberService.registerMember(mVo);
		return "login"; //string으로 리턴되는건 html 파일로 넘어감! (회원가입 다음 로그인화면으로 넘어가고 싶다면 templates 안에 있는 로그인 html 파일명 쓰기)
	}
}
