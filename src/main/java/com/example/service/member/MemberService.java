package com.example.service.member;

import java.util.ArrayList;

import com.example.vo.member.MemberVO;
import com.example.vo.paging.Criteria;

public interface MemberService {
	public void test();

	public MemberVO login(String email, String password) throws Exception;

	// 회원의 리스트 조회
    ArrayList<MemberVO> retrieveMemberList(Criteria crt) throws Exception;
    // 회원 총 수
    int retrieveTotalMember() throws Exception;
    // 해당 회원의 상세 조회
    MemberVO retrieveMemberByManager(int no);
    // 검색에 해당된 회원 조회
    ArrayList<MemberVO> retrieveSearchMember(Criteria crt, String keyfield, String keyword);
    // 검색에 해당된 회원의 총 수
    int retrieveTotalSearchMember(String keyfield, String keyword);
    // 정지 기간 업데이트
    void modifyBan(String banSelect, int no);
    // 회원의 강제 탈퇴
    void modifyMemberByForce(int no);
    // 게시글 등록 시 회원의 게시글 수 변동
    void upMemberDocs(int no);
    // 게시글 삭제 시 회원의 게시글 수 변동
    void downMemberDocs(int no);
    // 댓글 등록 시 회원의 댓글 수 변동
    void upMemberComms(int no);
    // 댓글 삭제 시 회원의 댓글 수 변동
    void downMemberComms(int no);

	ArrayList<MemberVO> retrieveMemberList(int startRow, int memberPerPage);

	
	// 회원가입
	MemberVO retreiveMemberProfile(int member_no);

	// 회원가입 이메일 중복 확인
	boolean retrieveEmail(String email);
	
	//회원 자진 탈퇴
	void modifyMember(int memberNo, String password);
	
	//비밀번호 재설정
	void modifyPassword(int memNo, String newPassword);

	void registerMember(MemberVO mVo);

	boolean retrieveNickname(String nickname);
	boolean retrieveEmail(String email);

	int updateTempPassword(MemberVO mVo);
}
