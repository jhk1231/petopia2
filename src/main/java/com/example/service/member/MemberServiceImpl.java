package com.example.service.member;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.member.MemberDao;
import com.example.mapper.member.MemberMapper;
import com.example.vo.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDao memberdao;
	@Autowired private MemberMapper memberMapper;
	
	@Override
	public ArrayList<MemberVO> retrieveMemberList(int startRow, int memberPerPage) {
		return this.memberdao.selectMemberList(startRow, memberPerPage);
	}

	@Override
	public int retrieveTotalMember() {
		return this.memberdao.selectTotalMember();
	}

	@Override
	public MemberVO retrieveMemberByManager(int no) {
		return this.memberMapper.selectMemberByManager(no);
	}

	@Override
	public ArrayList<MemberVO> retrieveSearchMember(int startRow, int memberPerPage, String keyfield, String keyword) {
		return this.memberdao.selectSearchMember(startRow, memberPerPage, keyfield, keyword);
	}

	@Override
	public int retrieveTotalSearchMember(String keyfield, String keyword) {
		return this.memberdao.selectTotalSearchMember(keyfield, keyword);
	}

	@Override
	public void modifyBan(String banSelect, int no) {
		this.memberdao.updateBan(banSelect, no);
	}

	@Override
	public void modifyMemberByForce(int no) {
		this.memberdao.updateMemberByForce(no);
	}

	@Override
	public void upMemberDocs(int no) {
		this.memberdao.plusMemberDocs(no);
	}

	@Override
	public void downMemberDocs(int no) {
		this.memberdao.minusMemberDocs(no);
	}

	@Override
	public void upMemberComms(int no) {
		this.memberdao.plusMemberComms(no);
	}

	@Override
	public void downMemberComms(int no) {
		this.memberdao.minusMemberComms(no);
  }
	
	@Override
	public MemberVO login(String email, String password) throws Exception {
		MemberVO member = memberdao.selectMember(email, password);
		
		if(member != null)
			memberdao.updateLastDdate(member.getNo());
		
		return member;
	}

	@Override
	public void test() {
    
	}

}
