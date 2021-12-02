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

	MemberVO selectMember(String email);

	MemberVO selectMemberProfile(int member_no);

	void updatePassword(int memNo, String newPassword);

	void updateMember(int memberNo, String password);

	boolean selectNickname(String nickname);

}
