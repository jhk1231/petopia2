package com.example.dao.board;

import java.util.ArrayList;

import com.example.vo.board.CategoryBoardVO;
import com.example.vo.board.CategoryVO;

public interface CategoryDao {

	public void insertCategory(String categoryName);
	
	public void updateCategory(int categoryNo, String categoryName);
	
	public int selectConnectBoard(int categoryNo);
	
	public void deleteCategory(int categoryNo);
	
	public ArrayList<CategoryVO> selectCategoryList();
	
	public ArrayList<CategoryBoardVO> selectCategoryBoardList();
	
	public CategoryVO selectOneCategory(int categoryNo);
	
	public int selectDuplicateCategory(String categoryName);
	


}
