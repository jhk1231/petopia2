package com.example.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.board.ArticleDao;
import com.example.dao.board.FileDao;
import com.example.vo.board.ArticleVO;
import com.example.vo.board.FileVO;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private FileDao fileDao;

	@Override
	@Transactional
	public ArticleVO retrieveArticle(int articleNo) { // 세부 조회
		return this.articleDao.selectArticle(articleNo);
	}

	@Override
	public List<ArticleVO> retrieveBoard(int boardNo) { // 게시판 목록 조회
		return this.articleDao.selectBoard(boardNo);
	}

	// 게시글 추가
	@Override
	@Transactional
	public void registerArticle(ArticleVO article) {
		this.articleDao.insertArticle(article); // 게시글 추가
		int articleNo = article.getNo();
		List<FileVO> fileList = article.getFileList();
		for (FileVO file : fileList) {
			file.setArticleNo(articleNo);
			this.fileDao.insertFile(file); // 첨부파일 추가
		}
	}

	@Override
	@Transactional
	public void modifyArticle(ArticleVO article) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void removeArticle(int articleNo) {
		this.articleDao.deleteArticle(articleNo);

	}

}
