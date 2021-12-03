package com.example.mapper.member;

import java.util.HashMap;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import com.example.vo.paging.Criteria;

import com.example.vo.member.MemberVO;

@Repository("memberMapper")
@Mapper
public interface MemberMapper {
	public MemberVO selectMember_byIDPwd(String email, String password) throws Exception;

	public void updateLastDdate(int no) throws Exception;

	public MemberVO test();
	
	// 회원 목록 조회 
	ArrayList<MemberVO> selectMemberList(Criteria crt) throws Exception;
	
	// 회원의 총 수
	int selectTotalMember() throws Exception;

	// 해당 회원의 상세 조회
	MemberVO selectMemberByManager(int no);

	// 회원 가입
	void insertMember(MemberVO mVo);
	void insertMemberNo(HashMap<String, Object> mVo);
	
	// 회원가입 시 이메일 중복체크
	String selectEmail(String email);
	// 정지 기간 7일 업데이트
	void updateBan7days(int no);

	// 정지 기간 1일 업데이트
	void updateBan1day(int no);

	// 정지 기간 1분 업데이트
	void updateBan1minute(int no);

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
	
	public void updateTempPassword(MemberVO mVo);

}
