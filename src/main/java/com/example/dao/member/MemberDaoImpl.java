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
@Repository("memberDao") //Dao라고 알려주는 거 이름은 괄호 안에 있는거
@Log
public class MemberDaoImpl implements MemberDao {

	@Autowired private SqlSession sqlSession;

	@Autowired
	private MemberMapper mapper;
	
  
	public void test() {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateLastDdate(int no) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateLastDdate(no);
	}
  
	@Override
	public MemberVO selectMember(String email, String password) throws Exception{
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
	public void updatePassword(int memNo, String newPassword) {
	}

	@Override
	public void updateMember(int memberNo, String password) {

	}
	
	@Override
	public boolean selectNickname(String nickname) {
		// TODO Auto-generated method stub
		return false;
	}

	//회원가입
	@Override
	public 	void insertMember(MemberVO mVo) { //자바스크립트의 MemberDao에 있는거 리턴부터  변수명(파라미터값) 그대로 복붙
		//this.sqlSession.insert("Member.join", mVo); //(mapper.xml에 있는 매퍼명.해당 id, mVo는 변수명)
		this.mapper.insertMember(mVo);
	}
	
	//회원가입 시 이메일 중복확인
	@Override
	public String selectEmail(String email) { 
		//this.sqlSession.selectOne("Member.joinidcheck", email);
		return this.mapper.selectEmail(email);
	}

	@Override
	public void insertMemberNo(HashMap<String, Object> mVo) {
		// TODO Auto-generated method stub
		this.mapper.insertMemberNo(mVo);
	}
	
	@Override
	public ArrayList<MemberVO> selectSearchMember(int startRow, int memberPerPage, String keyfield, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTotalSearchMember(String keyfield, String keyword) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO selectMemberProfile(int member_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTempPassword(MemberVO mVo) throws Exception {
		// TODO Auto-generated method stub
		return this.mapper.updateTempPassword(mVo);
	}

}
