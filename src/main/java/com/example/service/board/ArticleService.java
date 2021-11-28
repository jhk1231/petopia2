package com.example.service.board;

import java.util.List;

import com.example.vo.board.ArticleVO;
import com.example.vo.board.FileVO;

public interface ArticleService {

	ArticleVO retrieveArticle(int articleNo); //세부 조회
	
	List<ArticleVO> retrieveBoard(int boardNo); // 목록 조회
	
	void registerArticle(ArticleVO article); // 추가
	
	void modifyArticle(ArticleVO article); // 수정
	
	void removeArticle(int articleNo); // 삭제
}
