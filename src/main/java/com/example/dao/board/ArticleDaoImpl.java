package com.example.dao.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.board.ArticleMapper;
import com.example.vo.board.ArticleVO;
import com.example.vo.board.LikeVO;
import com.example.vo.board.SelectArticleVO;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {

	private ArticleMapper articleMapper;
	
	@Autowired
	public ArticleDaoImpl(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}
	
	
	@Override
	public List<SelectArticleVO> selectArticle(int articleNo) {
		return this.articleMapper.selectArticle(articleNo);
	}

	@Override
	public List<ArticleVO> selectBoard(int boardNo) {
		return this.articleMapper.selectBoard(boardNo);
	}

	@Override
	public void insertArticle(ArticleVO article) {
		this.articleMapper.insertArticle(article);
	}

	
	@Override
	public void updateArticle(ArticleVO article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int articleNo) {
		this.articleMapper.deleteArticle(articleNo);

	}
	
	@Override
	public void upViewcount(int articleNo) {
		this.articleMapper.upViewcount(articleNo);
	}

//	// 추천
//	@Override
//	public void insertLike(LikeVO likeVO) {
//		this.articleMapper.insertLike(likeVO);
//	}
//	
//	// 추천 취소
//	@Override
//	public void deleteLike(int likeNo) {
//		this.articleMapper.deleteLike(likeNo);
//	}
//	
//	
//	// pk값
//	@Override
//	public LikeVO selectLike(LikeVO likeVO) {
//		return this.articleMapper.selectLike(likeVO);
//	}
//	
//	@Override
//	public int totalRecCount(int articleNo) {
//		return this.articleMapper.totalLikeCount(articleNo);
//	}
	
	
	
}
