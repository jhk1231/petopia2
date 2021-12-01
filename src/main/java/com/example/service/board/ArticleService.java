package com.example.service.board;

import java.io.IOException;
import java.util.List;

import com.example.vo.board.ArticleVO;
import com.example.vo.board.FileVO;

public interface ArticleService {

	ArticleVO retrieveArticle(int articleNo); //세부 조회
	
	List<ArticleVO> retrieveBoard(int boardNo); // 목록 조회
	
	void registerArticle(ArticleVO article); // 추가
	
	void modifyArticle(ArticleVO article); // 수정
	
	void removeArticle(int articleNo); // 삭제
	
	
	
//	void upViewcount(int articleNo); // 조회수 up
//	
//	void recUpdate(int articleNo, int memberNo);
//	
//	int totalRecCount(int articleNo);
}
