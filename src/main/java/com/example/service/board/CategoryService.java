package com.example.service.board;

import java.util.ArrayList;

import com.example.vo.board.CategoryVO;

public interface CategoryService {
	
	public void registerCategory(String categoryName);
	
	public void modifyCategory(int categoryNo, String categoryName);

	public int retrieveConnectBoard(int categoryNo);
	
	public void removeCategory(int categoryNo);
	
	public CategoryVO retrieveOneCategory(int categoryNo);

	public int retrieveDuplicateCategory(String categoryName);
	
//	public ArrayList<CategoryVO> retrieveCategoryList();
	
	
}
