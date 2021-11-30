package com.example.dao.member;

import com.example.vo.member.MemberVO;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.vo.member.MemberVO;

public interface MemberDao {
	public void test();
	public MemberVO selectMember(int no);	
	public MemberVO selectMember(String email, String password) throws Exception;
	public void updateLastDdate(int no) throws Exception;
  // 회원의 리스트 조회
	ArrayList<MemberVO> selectMemberList(int startRow, int memberPerPage);

	// 회원의 총 수
	int selectTotalMember();

	// 검색에 해당된 회원 조회
	ArrayList<MemberVO> selectSearchMember(int startRow, int memberPerPage, String keyfield, String keyword);

	// 검색에 해당된 회원의 총 수
	int selectTotalSearchMember(String keyfield, String keyword);

	// 정지 기간 업데이트
	void updateBan(String banSelect, int no);

	// 회원의 강제 탈퇴
	void updateMemberByForce(int no);

	// 게시글 등록 시 회원의 게시글 수 변동
	void plusMemberDocs(int no);

	// 게시글 삭제 시 회원의 게시글 수 변동
	void minusMemberDocs(int no);

	// 댓글 등록 시 회원의 댓글 수 변동
	void plusMemberComms(int no);

	// 댓글 삭제 시 회원의 댓글 수 변동
	void minusMemberComms(int no);

	// 회원 가입
	void insertMember(MemberVO mVo);

	// 회원가입 시 이메일 중복확인
	boolean selectEmail(String email);

	MemberVO selectMember(String email);

	MemberVO selectMemberProfile(int member_no);

	void updatePassword(int memNo, String newPassword);

	void updateMember(int memberNo, String password);

	boolean selectNickname(String nickname);
}
