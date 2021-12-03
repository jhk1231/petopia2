package com.example.dao.member;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.member.MemberVO;

import com.example.mapper.member.MemberMapper;
import lombok.extern.java.Log;

//여기부터가 기본 세팅
@Repository("memberDao") // Dao라고 알려주는 거 이름은 괄호 안에 있는거
@Log

public class MemberDaoImpl implements MemberDao { // @Autowired가 속해 있는 클래스
	@Autowired // 밑에 선언한 애랑 얘가 속해있는 클래스랑 연결을 자동으로 해주는 거 (속해있는 클래스가 memberDao)
	private SqlSession sqlSession; // @Autowired 밑에 선언 된 mybatis //mybatis는 db 명령문을 자동으로 입력해주는 다른 사람이 만들어놓은
									// 프로그램?명령문? 이라고 보면 된다.

	@Autowired
	private MemberMapper mapper;
//기본 세팅 끝

	// 회원가입
	@Override
	public void insertMember(MemberVO mVo) { // 자바스크립트의 MemberDao에 있는거 리턴부터 변수명(파라미터값) 그대로 복붙
		//this.sqlSession.insert("Member.join", mVo); //(mapper.xml에 있는 매퍼명.해당 id, mVo는 변수명)
		this.mapper.insertMember(mVo);
	}

	// 회원가입 시 이메일 중복확인
	@Override
	public String selectEmail(String email) {
		// this.sqlSession.selectOne("Member.joinidcheck", email);
		return this.mapper.selectEmail(email);
	}

	// 회원 자진 탈퇴
	@Override
	public void updateMember(int memberNo, String password) {
		MemberVO memberVo = new MemberVO();
		memberVo.setNo(memberNo);
		memberVo.setPassword(password);
		this.mapper.updateMember(memberVo);
	}

	// 비밀번호 재설정
	@Override
	public void updatePassword(int memNo, String newPassword) {
		this.mapper.updatePassword(memNo, newPassword);
	}

	public void test() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateLastDdate(int no) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateLastDdate(no);
	}

	@Override
	public MemberVO selectMember(String email, String password) throws Exception {
		return mapper.selectMember_byIDPwd(email, password);
	}

	@Override
	public MemberVO selectMember(int no) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MemberVO selectMember(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMemberProfile(int member_no) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean selectNickname(String nickname) {
		// TODO Auto-generated method stub
		return false;
	}
		

	@Override
	public void insertMemberNo(HashMap<String, Object> mVo) {
		// TODO Auto-generated method stub
		this.mapper.insertMemberNo(mVo);
	}

	@Override
	public void updatePassword(MemberVO memberVo) {
		// TODO Auto-generated method stub
		this.mapper.updatePassword(memberVo);
	}

}
