package com.example.dao.member;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.example.vo.member.MemberVO;

public interface MemberDao {
	public void test();

	public MemberVO selectMember(int no);

	public MemberVO selectMember(String email, String password) throws Exception;

	public void updateLastDdate(int no) throws Exception;

	// 검색에 해당된 회원 조회
	ArrayList<MemberVO> selectSearchMember(int startRow, int memberPerPage, String keyfield, String keyword);

	// 검색에 해당된 회원의 총 수
	int selectTotalSearchMember(String keyfield, String keyword);
}
