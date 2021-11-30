package com.example.petopia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.member.MemberMapper;
import com.example.vo.member.MemberVO;

@SpringBootTest
class PetopiaApplicationTests {
@Autowired
private MemberMapper mapper;

	@Test
	void nulltest() {

		assertNotNull(mapper);
	}
	@Test
	void contextLoads() {
		MemberVO member = new MemberVO(12. 1, "ty@gmail.com", "1111", "닉네임");
		mapper.insertMember(member);
		//this.sqlSession.insert("Member.join", member);
	}

}
