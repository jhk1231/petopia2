package com.example.petopia;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.member.MemberMapper;
import com.example.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class PetopiaApplicationTests {
	@Autowired
	private MemberMapper mapper;
	//private MemberDao dao;
	@Autowired private MemberService service;
	
	@Test
	void nulltest() {

		//assertNotNull(service);
	}
//	@Test
//	void contextLoads() {
//		//MemberVO member = new MemberVO(12, 1, "ty@gmail.com", "1111", "닉네임");
//		//mapper.insertMember(member);
//		//this.sqlSession.insert("Member.join", member);
//		
//		try {
//			//System.out.println(mapper.selectMember_byIDPwd("admin@naver.com, null", "1111").toString());
//			System.out.println(mapper.selectMember_byIDPwd("admin@naver.com", "1111"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail();
//		}
//	}
	
//	@Test
//	void uhh() {
//		MemberVO memberVo = new MemberVO("test2@naver.com", "1111", "테스트2");
		//MembertestVO memberVo = new MembertestVO(1);
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		this.mapper.insertMemberNo(map);
//		System.out.println(map.get("no"));
		//System.out.println(memberVo.toString());
		
		//this.service.registerMember(memberVo);
		//memberVo.setNo(12);
//		this.service.registerMember(memberVo);
//		
//	}
	@Test
	void sad() {
		String email = "admin@naver.com";
		boolean result = this.service.retrieveEmail(email);
//		if(result != null) {
//			return true;
//		} else {
//			return false;
//		}
		System.out.println(result);
	}

}
