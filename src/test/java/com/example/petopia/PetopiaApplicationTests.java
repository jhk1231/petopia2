package com.example.petopia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.board.ArticleMapper;
import com.example.mapper.board.BoardMapper;
import com.example.mapper.board.FileMapper;
import com.example.mapper.board.ReplyMapper;
import com.example.service.board.ArticleService;
import com.example.service.board.BoardService;
import com.example.service.board.CategoryService;
import com.example.service.board.ReplyService;
import com.example.util.FileManager;
import com.example.vo.board.ArticleVO;
import com.example.vo.board.SelectArticleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PetopiaApplicationTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private FileMapper fileMapper;
	@Autowired
	private ReplyMapper replyMapper;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private BoardService boardService;
	@Autowired
	private CategoryService categoryService;
	
	@Test
	void tasdo() {
//		List<CategoryVO> categoryList = this.categoryService.retrieveCategoryBoardList();
//		categoryList.forEach(catte -> log.info("***: " + catte));
		
//		int articleNo = this.articleMapper.selectViewCount(14);
//		System.out.println("saddasddasad" + articleNo);
//		for (SelectArticleVO selectArticleVO : artVO) {
//			log.info(selectArticleVO.toString());
//		}
		
//		List<ArticleVO> artList = this.articleMapper.selectAllArticle();
//		for (ArticleVO articleVO : artList) {
//			log.info(articleVO.toString());
//		}
	}
	
	
//	@Test
//	void ttt() {
//		ArticleVO arit = new ArticleVO();
//		arit.setNo(10);
//		arit.setSubject("매퍼 테스트");
//		arit.setContent("음 테스트" );
//		this.articleMapper.updateArticle(arit);
//	}
	
//	@Test
//	void sadsaasd() {
//		List<BoardBoardGradeVO> bbL = this.boardMapper.selectAllBoard();
//		for (BoardBoardGradeVO boardBoardGradeVO : bbL) {
//			log.info( boardBoardGradeVO.toString());
//		}
//	}
//	@Test
//	void sadsda() {
//		log.info(this.boardService.retrieveOneBoard(0));
//	}
	
	
//
//	private MemberMapper mapper;
//	@Autowired
//	private GradeMapper gradeMapper;
//	
//
	@Test
	@DisplayName("Mapper 생성 test")
	void createTest() {
		assertNotNull(this.dataSource);
////		assertNotNull(this.articleMapper);
		assertNotNull(this.fileMapper);
		assertNotNull(this.replyMapper);
////		assertNotNull(this.articleService);
////		assertNotNull(this.fileManager);
	}
}
