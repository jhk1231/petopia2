package com.example.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.member.MemberDao;
import com.example.vo.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberdao;
	
	@Override
	public MemberVO login(String email, String password) throws Exception {
		return memberdao.selectMember(email, password);
	}

	@Override
	public void test() {
	}

}
