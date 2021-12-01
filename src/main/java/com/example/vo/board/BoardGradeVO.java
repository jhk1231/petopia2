package com.example.vo.board;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@ToString
@Repository("boardGradeVO")
public class BoardGradeVO {
	
	private int boardNo;
	private int readGrade;
	private int writeGrade;
	private int readwrite;
	private int gradeNo;
	//ArrayList<BoardGradeVO> baordGradeList = new ArrayList<>();
	
//	public BoardGradeVO(int readGrade, int writeGrade) {
//		this.readGrade = readGrade;
//		this.writeGrade = writeGrade;
//	}
//	
	
	
	
}
