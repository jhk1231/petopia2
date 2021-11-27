package com.example.mapper.member;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.member.MemberVO;

@Mapper
public interface MemberMapper {
	public MemberVO selectMember_byIDPwd(String email, String password) throws Exception;
	public void updateLastDdate(int no) throws Exception;
	public MemberVO test();
}
