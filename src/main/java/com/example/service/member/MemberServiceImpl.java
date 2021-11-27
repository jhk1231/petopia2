package com.example.service.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.member.MemberDao;
import com.example.mapper.member.MemberMapper;
import com.example.vo.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDao memberDao;
	@Autowired private MemberMapper memberMapper;
	
	@Override
	public ArrayList<MemberVO> retrieveMemberList(int startRow, int memberPerPage) {
		return this.memberDao.selectMemberList(startRow, memberPerPage);
	}

	@Override
	public int retrieveTotalMember() {
		return this.memberDao.selectTotalMember();
	}

	@Override
	public MemberVO retrieveMemberByManager(int no) {
		return this.memberMapper.selectMemberByManager(no);
	}

	@Override
	public ArrayList<MemberVO> retrieveSearchMember(int startRow, int memberPerPage, String keyfield, String keyword) {
		return this.memberDao.selectSearchMember(startRow, memberPerPage, keyfield, keyword);
	}

	@Override
	public int retrieveTotalSearchMember(String keyfield, String keyword) {
		return this.memberDao.selectTotalSearchMember(keyfield, keyword);
	}

	@Override
	public void modifyBan(String banSelect, int no) {
		this.memberDao.updateBan(banSelect, no);
	}

	@Override
	public void modifyMemberByForce(int no) {
		this.memberDao.updateMemberByForce(no);
	}

	@Override
	public void upMemberDocs(int no) {
		this.memberDao.plusMemberDocs(no);
	}

	@Override
	public void downMemberDocs(int no) {
		this.memberDao.minusMemberDocs(no);
	}

	@Override
	public void upMemberComms(int no) {
		this.memberDao.plusMemberComms(no);
	}

	@Override
	public void downMemberComms(int no) {
		this.memberDao.minusMemberComms(no);
	}

}
