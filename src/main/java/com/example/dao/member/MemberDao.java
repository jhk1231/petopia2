package com.example.dao.member;

import com.example.vo.member.MemberVO;

public interface MemberDao {
	public void test();
	public MemberVO selectMember(int no);	
	public MemberVO selectMember(String email, String password) throws Exception;
}
