package com.example.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.member.MemberDao;
import com.example.vo.member.MemberVO;

@Service("memberService") //얘는 서비스다
public class MemberServiceImpl implements MemberService {
	@Autowired //memberDao랑 연결해주겠다
	private MemberDao memberDao;
	
//mapper를 쓸 때
//	@Autowired
//	private MemberMapper mapper;

	@Override
	public MemberVO login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
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
