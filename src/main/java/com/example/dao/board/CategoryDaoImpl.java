package com.example.dao.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.board.CategoryMapper;
import com.example.vo.board.CategoryBoardVO;
import com.example.vo.board.CategoryVO;



@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public void insertCategory(String categoryName) {
		this.categoryMapper.insertCategory(categoryName);
	}

	@Override
	public void updateCategory(int categoryNo, String categoryName) {
		this.categoryMapper.updateCategory(categoryNo, categoryName);	
	}
	
	@Override
	public int selectConnectBoard(int categoryNo) {
		int checkConnectBoard = this.categoryMapper.selectConnectBoard(categoryNo);
		return checkConnectBoard;
	}

	@Override
	public void deleteCategory(int categoryNo) {
		this.categoryMapper.deleteCategory(categoryNo);
	}

	@Override
	public CategoryVO selectOneCategory(int categoryNo) {
		CategoryVO categoryVo = this.categoryMapper.selectOneCategory(categoryNo);
		System.out.println(categoryVo.toString() + "--------------------------------------Dao");
		return categoryVo; //categoryList[], boardList[]까지 불러옴.. 아니 NonNull 줬잖아 
	}

	@Override
	public int selectDuplicateCategory(String categoryName) {
		int checkDuplicateCategory = this.categoryMapper.selectDuplicateCategory(categoryName);
		return checkDuplicateCategory;
	}

//	@Override
//	public ArrayList<CategoryVO> selectCategoryList() {
//		ArrayList<CategoryVO> categoryList = this.categoryMapper.selectCategoryList();
//		return categoryList;
//	}

//	@Override
//	public void selectCategoryList(Map map) {
//		List<CategoryBoardVO> list = this.categoryMapper.selectCategoryBoardList();
//		
//	}


}
