package com.example.dao.member;

import com.example.vo.member.MemberVO;

public interface MemberDao {
	// 회원 가입
	void insertMember(MemberVO mVo);

	// 회원가입 시 이메일 중복확인
	boolean selectEmail(String email);

	MemberVO selectMember(String email, String password);

	MemberVO selectMember(String email);

	MemberVO selectMemberProfile(int member_no);

	void updateBan(String banSelect, int no);

	void updatePassword(int memNo, String newPassword);

	void updateMember(int memberNo, String password);

	boolean selectNickname(String nickname);
}
