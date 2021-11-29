package com.example.service.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.board.CategoryDao;
import com.example.vo.board.CategoryVO;

@Repository("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void registerCategory(String categoryName) {
		this.categoryDao.insertCategory(categoryName);
		
	}

	@Override
	public void modifyCategory(int categoryNo, String categoryName) {
		this.categoryDao.updateCategory(categoryNo, categoryName);
	}
	
	@Override
	public int retrieveConnectBoard(int categoryNo) {
		int checkConnectBoard = this.categoryDao.selectConnectBoard(categoryNo);
		return checkConnectBoard;
	}

	@Override
	public void removeCategory(int categoryNo) {
		this.categoryDao.deleteCategory(categoryNo);
		
	}

	@Override
	public CategoryVO retrieveOneCategory(int categoryNo) {
		CategoryVO categoryVo = this.categoryDao.selectOneCategory(categoryNo);
		return categoryVo;
	}

	@Override
	public int retrieveDuplicateCategory(String categoryName) {
		int checkDuplicateCategory = this.categoryDao.selectDuplicateCategory(categoryName);
		return checkDuplicateCategory;
	}
//
//	@Override
//	public ArrayList<CategoryVO> retrieveCategoryList() {
//		ArrayList<CategoryVO> categoryList = this.categoryDao.selectCategoryList();
//		return categoryList;
//	}



}
