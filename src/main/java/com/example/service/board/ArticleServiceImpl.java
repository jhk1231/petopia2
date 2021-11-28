package com.example.service.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.board.ArticleDao;
import com.example.dao.board.FileDao;
import com.example.vo.board.ArticleVO;
import com.example.vo.board.FileVO;
import com.example.vo.board.SelectArticleVO;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private FileDao fileDao;

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
		return fileList(article, fileList);
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
		if (article.getAttacheFile() != null) { // 첨부파일이 있다면
			FileVO attachFile = article.getAttacheFile();
			attachFile.setArticleNo(articleNo);
			attachFile.setFileType(0);
			this.fileDao.insertFile(attachFile); // 첨부파일은 맨 마지막으로 가게해서 저장
		}
		if (article.getFileList() != null) { // 이미지 첨부 파일이 있을 때
			List<FileVO> fileList = article.getFileList();
			for (FileVO file : fileList) {
				file.setArticleNo(articleNo);
				file.setFileType(1);
				this.fileDao.insertFile(file); // 이미지 파일들 저장
			}
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

	// file 꺼내서 추출, retirveArticle에서 사용됨
	private ArticleVO fileList(ArticleVO article, List<FileVO> files) {
		if (files == null) {
			return article;
		}
		List<FileVO> imageFiles = new ArrayList<FileVO>();
		for (FileVO file : files) {
			if (file.getFileType() == 0) {
				article.setAttacheFile(file);
			}
			imageFiles.add(file); // 이미지 파일은 fileType= 1
		}
		article.setFileList(imageFiles); // 결과 저장
		return article;
	}

}
