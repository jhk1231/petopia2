package com.example.vo.board;

import java.util.ArrayList;
import java.util.List;

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
//@RequiredArgsConstructor
@Alias("categoryVO")
@ToString
public class CategoryVO {
	private int categoryNo;
	private String categoryName;
	
	private List<CategoryVO> categoryList = new ArrayList<>();
	private List<BoardVO> boardList = new ArrayList<>();
	
	public void addBoardList(BoardVO board) {
		this.boardList.add(board);
	}
	
	public void addCategoryList(CategoryVO categoryVo) {
		this.categoryList.add(categoryVo);
	}
}
