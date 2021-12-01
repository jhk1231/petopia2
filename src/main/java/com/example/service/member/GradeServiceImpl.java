package com.example.service.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.member.GradeMapper;
import com.example.vo.member.GradeVO;

@Service("gradeService")
public class GradeServiceImpl implements GradeService{
	@Autowired private GradeMapper gradeMapper;
	
	@Override
	public ArrayList<GradeVO> retrieveGradeList() throws Exception {
		return this.gradeMapper.selectGradeList();
	}

	@Override
	public void modifyGrade(GradeVO grade) throws Exception {
		this.gradeMapper.updateGrade(grade);
		this.gradeMapper.rearrangeMemberGrade();
	}

	@Override
	public void removeGrade(int no) throws Exception {
		this.gradeMapper.rearrangeGrade(no);
		this.gradeMapper.deleteGrade(no);
		this.gradeMapper.rearrangeMemberGrade();
	}
	
	public void sortGrade() throws Exception {
		this.gradeMapper.standGrade();
		this.gradeMapper.rearrangeMemberGrade();
	}

	@Override
	public Map<String, Object> retrieveGradeBoardList(int gradeNo) throws Exception {
		List readList = this.gradeMapper.selectReadBoardByGrade(gradeNo);
		List writeList = this.gradeMapper.selectWriteBoardByGrade(gradeNo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("read", readList);
		map.put("write", writeList);
		return map;
	}

	
}
