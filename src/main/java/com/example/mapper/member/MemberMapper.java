package com.example.mapper.member;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.member.MemberVO;

import org.springframework.stereotype.Repository;

@Repository("memberMapper")
@Mapper
public interface MemberMapper {
	public MemberVO selectMember_byIDPwd(String email, String password) throws Exception;
	public void updateLastDdate(int no) throws Exception;
	public MemberVO test();
  // 해당 회원의 상세 조회
	MemberVO selectMemberByManager(int no);

	// 회원 가입
	void insertMember(MemberVO mVo);

	// 회원가입 시 이메일 중복체크
	boolean selectEmail(String email);

	// MemberVO selectMember(String email, String password);
	// MemberVO selectMember(String email);
	// MemberVO selectMemberProfile(int member_no);
	// void updateBan(String banSelect, int no);
	// void updatePassword(int memNo, String newPassword);
	//	void updateMember(int memberNo, String password);
	//	boolean selectNickname(String nickname);
}
	
