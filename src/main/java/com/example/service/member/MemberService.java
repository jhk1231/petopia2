package com.example.service.member;

import com.example.vo.member.MemberVO;

public interface MemberService {
	//로그인
	MemberVO login(String email, String password);
	//회원가입
	MemberVO retreiveMemberProfile(int member_no);
	//회원가입 이메일 중복 확인
	boolean retrieveEmail(String email);
	
	void registerMember(MemberVO mVo);
	void modifyPassword(int memNo, String newPassword);
	
	void modifyMember(int memberNo, String password);
	boolean retrieveNickname(String nickname);
	
}
