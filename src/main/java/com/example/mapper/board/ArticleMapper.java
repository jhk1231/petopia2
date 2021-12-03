package com.example.mapper.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.board.ArticleVO;
import com.example.vo.board.LikeVO;
import com.example.vo.board.SelectArticleVO;

@Mapper
public interface ArticleMapper {
	
	
	List<SelectArticleVO> selectArticle(int articleNo); //세부 조회
	
	List<ArticleVO> selectBoard(int boardNo); // 게시판 목록 조회
	
	void insertArticle(ArticleVO article); // 추가
	
	void updateArticle(ArticleVO article); // 수정
	
	void deleteArticle(int articleNo); // 삭제
	
	void upViewcount(int aritlceNo); // 조회수 증가
	
	List<ArticleVO> selectAllArticle();
	
	int likeCheck(ArticleVO articleVO); // 추천 햿는지 체크

	void insertLike(ArticleVO articleVO);
//	
	void deleteLike(ArticleVO articleVO); // 추천 삭제 
//	
	int totalLikeCount(int articleNo);
	
	void upLikecount(int articleNo);
	
	void downLikecount(int articleNo);
}
