package com.example.dao.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.member.MemberMapper;
import com.example.vo.member.MemberVO;

import lombok.extern.java.Log;

@Repository("memberDao")
@Log
public class MemberDaoImpl implements MemberDao {
	@Autowired private SqlSession sqlSession;
	@Autowired
	private MemberMapper mapper;
	
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
	public void test() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLastDdate(int no) throws Exception {
		// TODO Auto-generated method stub
		mapper.updateLastDdate(no);
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

}
