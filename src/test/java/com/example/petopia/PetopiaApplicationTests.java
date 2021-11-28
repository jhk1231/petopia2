package com.example.petopia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.board.ArticleMapper;
import com.example.mapper.board.FileMapper;
import com.example.service.board.ArticleService;
import com.example.util.FileManager;
import com.example.vo.board.SelectArticleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PetopiaApplicationTests {
	
	@Autowired private DataSource dataSource;
	@Autowired private ArticleMapper articleMapper;
	@Autowired private FileMapper fileMapper;
//	@Autowired private ReplyMapper replyMapper;
	@Autowired private ArticleService articleService;
	@Autowired private FileManager fileManager;
	
	@Test
	@DisplayName("Mapper 생성 test")
	void createTest() {
//		assertNotNull(this.dataSource);
		assertNotNull(this.articleMapper);
//		assertNotNull(this.fileMapper);
//		assertNotNull(this.replyMapper);
//		assertNotNull(this.articleService);
//		assertNotNull(this.fileManager);
	}
	
//	@Test
//	@DisplayName("insert Test")
//	void insertTest() {
//		ArticleVO aritce = new ArticleVO(1, 5, "일일일", "testtest", "testetst");
//		this.articleService.registerArticle(aritce);
//	}

//	@Test
//	void test2() { 
//		ArticleVO art = new ArticleVO(1,2,"ddd","삭제해", "내용");
//		this.articleMapper.insertArticle(art);
//		System.out.println("***no****:" + art.getNo());
//	}

	
	
//	@Test
//	@DisplayName("목록 조회 test")
//	void test3() {
//		List<ArticleVO> articles = this.articleService.retrieveBoard(5);
//		articles.forEach(article -> log.info(article.toString()));
//	}

//	@Test
//	@DisplayName("세부조회 Test ver.1")
//	void test4() {
//		ArticleVO article = this.articleMapper.selectArticle(10);
//		log.info(article.toString());
//	}
	
//	@Test
//	void insertFile() {
//		ArticleVO article = new ArticleVO(1, 2, "일일일", "파첨테테", "파첨테");
//		List<FileVO> fList = new ArrayList<FileVO>();
//		fList.add(new FileVO(1, "테스트입니다55", "test333", 1132335L));
//		fList.add(new FileVO(3, "테스트입니다5555", "test444", 135L));
//		article.setFileList(fList);
//		this.articleService.registerArticle(article);
//	}

//	@Test
//	void selectFile() {
//		FileVO fie = this.fileMapper.selectFile(2);
//		log.info("파일 찍기={}", fie.toString());
//	}
	
//	@Test
//	void select() {
//		List<SelectArticleVO> select = this.articleMapper.selectArticle(91);
//		for (SelectArticleVO selectArticleVO : select) {
//			log.info(selectArticleVO.getArticle().toString());
//		}
//		log.info("***************" + select.get(0).getArticle());
//	}
	
	
	
}
