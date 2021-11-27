package com.example.dao.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mapper.board.ArticleMapper;
import com.example.vo.board.ArticleVO;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {

	private ArticleMapper articleMapper;
	
	@Autowired
	public ArticleDaoImpl(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}
	
	
	@Override
	public ArticleVO selectArticle(int articleNo) {
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

}
