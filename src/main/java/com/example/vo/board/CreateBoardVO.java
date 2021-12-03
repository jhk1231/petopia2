package com.example.vo.board;

import java.util.List;

import com.example.vo.member.GradeVO;

import lombok.Data;

@Data
public class CreateBoardVO {
	private List<CategoryVO> categoryList;
	private List<GradeVO> gradeList;
	

}
