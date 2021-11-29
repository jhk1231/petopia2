package com.example.dao.board;

import java.util.ArrayList;

import com.example.vo.board.CategoryVO;

public interface CategoryDao {

	public void insertCategory(String categoryName);
	
	public void updateCategory(int categoryNo, String categoryName);
	
	public int selectConnectBoard(int categoryNo);
	
	public void deleteCategory(int categoryNo);
	
	public CategoryVO selectOneCategory(int categoryNo);
	
	public int selectDuplicateCategory(String categoryName);
	
//	public ArrayList<CategoryVO> selectCategoryList();

//	public CategoryBoardVO 
}
