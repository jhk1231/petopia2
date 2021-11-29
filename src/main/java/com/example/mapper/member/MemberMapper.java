package com.example.mapper.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.vo.member.MemberVO;

@Repository("memberMapper")
@Mapper
public interface MemberMapper {
	public MemberVO selectMember_byIDPwd(String email, String password) throws Exception;
	public void updateLastDdate(int no) throws Exception;
	public MemberVO test();
  // 해당 회원의 상세 조회
	MemberVO selectMemberByManager(int no);

}
	
