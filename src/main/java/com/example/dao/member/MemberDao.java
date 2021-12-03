package com.example.dao.member;

import org.springframework.stereotype.Repository;
import com.example.vo.member.MemberVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberDao {
	public void test();

	public MemberVO selectMember(int no);

	public MemberVO selectMember(String email, String password) throws Exception;

	public void updateLastDdate(int no) throws Exception;

	// 회원 가입
	void insertMember(MemberVO mVo);
	void insertMemberNo(HashMap<String, Object> mVo);

	// 회원가입 시 이메일 중복확인
	String selectEmail(String email);
	
	//회원 자진 탈퇴
	void updateMember(int memberNo, String password);
	
	//비밀번호 재설정
	void updatePassword(int memNo, String newPassword);

	MemberVO selectMember(String email);

	MemberVO selectMemberProfile(int member_no);


	boolean selectNickname(String nickname);
	void updatePassword(MemberVO memberVo);
}
