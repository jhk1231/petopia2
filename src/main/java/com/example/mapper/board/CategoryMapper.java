package com.example.mapper.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.board.CategoryBoardVO;
import com.example.vo.board.CategoryVO;

@Mapper
public interface CategoryMapper {
	
	public void insertCategory(String categoryName);
	
	public void updateCategory(int categoryNo, String categoryName);
	
	public int selectConnectBoard(int categoryNo);
	
	public void deleteCategory(int categoryNo);
	
	public CategoryVO selectOneCategory(int categoryNo);
	
	public int selectDuplicateCategory(String categoryName);
	
	public ArrayList<CategoryVO> selectCategoryList();
	
	public ArrayList<CategoryBoardVO> selectCategoryBoardList();

	

	
}
