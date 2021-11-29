package com.example.vo.board;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

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
@Alias("categoryVO")
@ToString
public class CategoryVO {
	private int categoryNo;
	private String categoryName;
	//private ArrayList<CategoryVO> categoryList = new ArrayList<>();
	//private ArrayList<BoardVO> boardList = new ArrayList<>();
	
	
	

	
}
