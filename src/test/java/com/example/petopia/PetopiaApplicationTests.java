package com.example.petopia;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.member.MemberDao;
import com.example.mapper.member.MemberMapper;
import com.example.service.member.MemberService;

@SpringBootTest
class PetopiaApplicationTests {

//	@Autowired
//	private MemberService service;
	@Autowired
	private MemberMapper mapper;
	
	@Test
	void mappertest() {
		//System.out.println(service.login("admin@naver.com", "1111"));
		try {
			System.out.println(mapper.selectMember_byIDPwd("123@naver.com", "1234"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
