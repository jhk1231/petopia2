package com.example.vo.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	
	private int categoryNo; //카테고리번호
	private int boardNo; //게시판 번호
	private String boardName; //게시판 이름
	private int boardkind; //게시판종류
	
	// writeForm 게시판 목록 출력용
	public BoardVO(int boardNo, String boardName) {
		super();
		this.boardNo = boardNo;
		this.boardName = boardName;
	}
	
	
}
