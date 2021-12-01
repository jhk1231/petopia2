package com.example.dao.board;

import java.util.List;

import com.example.vo.board.ArticleVO;
import com.example.vo.board.SelectArticleVO;

public interface ArticleDao {

	List<SelectArticleVO> selectArticle(int articleNo); //세부 조회
	
	List<ArticleVO> selectBoard(int boardNo); // 목록 조회
	
	void insertArticle(ArticleVO article); // 추가
	
	void updateArticle(ArticleVO article); // 수정
	
	void deleteArticle(int articleNo); // 삭제
	
	void upViewcount(int articleNo); // 조회수 up
}
