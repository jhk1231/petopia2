package com.example.service.member;

import com.example.vo.member.MemberVO;

public interface MemberService {
	
	public void test();
	public MemberVO login(String email, String password) throws Exception;
}
