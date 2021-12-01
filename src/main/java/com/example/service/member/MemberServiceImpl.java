package com.example.service.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.member.MemberDao;
import com.example.mapper.member.MemberMapper;
import com.example.vo.member.MemberVO;
import com.example.vo.paging.Criteria;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberdao;
	@Autowired private MemberMapper memberMapper;
	
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
	
	@Override // 회원 목록 조회
	public ArrayList<MemberVO> retrieveMemberList(Criteria crt) throws Exception{
		return this.memberMapper.selectMemberList(crt);
	}
	
	@Override
	public int retrieveTotalMember() throws Exception {
		return this.memberMapper.selectTotalMember();
	}

	@Override // 회원 상세 조회
	public MemberVO retrieveMemberByManager(int no) {
		return this.memberMapper.selectMemberByManager(no);
	}

	@Override // 회원 검색 조회
	public ArrayList<MemberVO> retrieveSearchMember(int startRow, int memberPerPage, String keyfield, String keyword) {
		return this.memberdao.selectSearchMember(startRow, memberPerPage, keyfield, keyword);
	}

	@Override // 회원 검색 총 수
	public int retrieveTotalSearchMember(String keyfield, String keyword) {
		return this.memberdao.selectTotalSearchMember(keyfield, keyword);
	}

	@Override // 회원의 정지기간 업데이트
	public void modifyBan(String banSelect, int no) {
		if (banSelect.equals("7d")) {
			this.memberMapper.updateBan7days(no);
		}
		else if (banSelect.equals("1d")) {
			this.memberMapper.updateBan1day(no);
		}
		else {
			this.memberMapper.updateBan1minute(no);
		}
	}

	@Override // 회원의 강제 탈퇴
	public void modifyMemberByForce(int no) {
		this.memberMapper.updateMemberByForce(no);
	}

	@Override // 회원의 게시글 +1
	public void upMemberDocs(int no) {
		this.memberMapper.plusMemberDocs(no);
	}

	@Override // 회원의 게시글 -1
	public void downMemberDocs(int no) {
		this.memberMapper.minusMemberDocs(no);
	}

	@Override // 회원의 댓글 +1
	public void upMemberComms(int no) {
		this.memberMapper.plusMemberComms(no);
	}

	@Override // 회원의 댓글 -1
	public void downMemberComms(int no) {
		this.memberMapper.minusMemberComms(no);
	}

}
