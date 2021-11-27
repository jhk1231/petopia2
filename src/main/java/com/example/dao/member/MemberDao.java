package com.example.dao.member;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.vo.member.MemberVO;

public interface MemberDao {
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
}
