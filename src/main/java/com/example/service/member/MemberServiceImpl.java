package com.example.service.member;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.member.MemberDao;
import com.example.mapper.member.MemberMapper;
import com.example.vo.member.MemberVO;


@Service("memberService") //얘는 서비스다
public class MemberServiceImpl implements MemberService {
	@Autowired private MemberDao memberdao;//memberDao랑 연결해주겠다
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

	@Override
	public MemberVO retreiveMemberProfile(int member_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override // 회원가입
	public void registerMember(MemberVO mVo) {
		this.memberDao.insertMember(mVo); //this를 적어주는 이유는 @Autowired 연결 선언해준 memberDao랑 같은 애라는걸 알려주려고 적는 거임 (얘가 얘다)
	}

	@Override
	public void modifyPassword(int memNo, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean retrieveEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyMember(int memberNo, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean retrieveNickname(String nickname) {
		// TODO Auto-generated method stub
		return false;
	}
}
