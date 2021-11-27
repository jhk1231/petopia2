package com.example.petopia;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.board.ArticleMapper;
import com.example.service.board.ArticleService;
import com.example.vo.board.ArticleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PetopiaApplicationTests {

	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleService articleService;

//	@Test
//	@DisplayName("Mapper 생성 test")
//	void test() {
//		assertNotNull(this.articleService);
//	}
	
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
	
	
	
	
}
