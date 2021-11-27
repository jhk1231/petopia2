package com.example.dao.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.member.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<MemberVO> selectMemberList(int startRow, int memberPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTotalMember() {
		// TODO Auto-generated method stub
		return 0;
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
	public void updateBan(String banSelect, int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMemberByForce(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void plusMemberDocs(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void minusMemberDocs(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void plusMemberComms(int no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void minusMemberComms(int no) {
		// TODO Auto-generated method stub

	}

}
