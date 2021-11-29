package com.example.vo.board;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("boardVO")
public class BoardVO {
	private int categoryNo;
	private int boardNo;
	private String boardName;
	private int boardkind; //게시판종류  / TINYINT / NotNull, default 0
	
	private int favoriateNo;
	private int no; //회원 넘버
	
	//private ArrayList<BoardGradeVO> boardGradeVo = new ArrayList<BoardGradeVO>();
	
//	public BoardVO(int categoryNo, String boardName, int boardkind) {
//		super();
//		this.categoryNo = categoryNo;
//		this.boardName = boardName;
//		this.boardkind = boardkind;
//	}
	
	
	
	
}
