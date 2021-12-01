package com.example.service.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.board.ArticleDao;
import com.example.vo.board.ArticleVO;
import com.example.vo.board.FileVO;
import com.example.vo.board.SelectArticleVO;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private FileService fileService;


	@Override
	@Transactional
	public ArticleVO retrieveArticle(int articleNo) { // 세부 조회
		List<SelectArticleVO> results = this.articleDao.selectArticle(articleNo);
		ArticleVO article = results.get(0).getArticle(); // 게시글 정보 출력
		List<FileVO> fileList = new ArrayList<FileVO>();	
			if(results.get(0).getFile() != null) { // 파일이 있을 때
				for (SelectArticleVO result : results) {
					fileList.add(result.getFile());
				}
			} else { // 첨부된 파일이 없을 때
				fileList=null;
			}
		return this.fileService.fileList(article, fileList);
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
		this.fileService.uploadFile(article);
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

	@Override
	public void upViewcount(int articleNo) {
		this.articleDao.upViewcount(articleNo);
	}

}
