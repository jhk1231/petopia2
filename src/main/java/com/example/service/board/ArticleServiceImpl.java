package com.example.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.board.ArticleDao;
import com.example.vo.board.ArticleVO;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	
	@Autowired
	public ArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	
	@Override
	public ArticleVO retrieveArticle(int articleNo) {
		return this.articleDao.selectArticle(articleNo);
	}

	@Override
	public List<ArticleVO> retrieveBoard(int boardNo) { // 게시판 목록 조회
		return this.articleDao.selectBoard(boardNo);
	}

	@Override
	public void registerArticle(ArticleVO article) {
		this.articleDao.insertArticle(article);

	}

	@Override
	public void modifyArticle(ArticleVO article) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeArticle(int articleNo) {
		this.articleDao.deleteArticle(articleNo);

	}

}
