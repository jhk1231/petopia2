package com.example.petopia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.member.MemberMapper;
import com.example.service.member.MemberService;

import com.example.mapper.board.ArticleMapper;
import com.example.mapper.board.BoardMapper;
import com.example.mapper.board.FileMapper;
import com.example.mapper.board.ReplyMapper;
import com.example.mapper.member.MemberMapper;
import com.example.service.board.ArticleService;
import com.example.service.board.BoardService;
import com.example.service.board.CategoryService;
import com.example.service.board.ReplyService;
import com.example.util.FileManager;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class PetopiaApplicationTests {
	@Autowired
	private MemberMapper mapper;
	//private MemberDao dao;
	@Autowired private MemberService service;
	
	@Test
	void nulltest() {

		//assertNotNull(service);
	}
//	@Test
//	void contextLoads() {
//		//MemberVO member = new MemberVO(12, 1, "ty@gmail.com", "1111", "닉네임");
//		//mapper.insertMember(member);
//		//this.sqlSession.insert("Member.join", member);
//		
//		try {
//			//System.out.println(mapper.selectMember_byIDPwd("admin@naver.com, null", "1111").toString());
//			System.out.println(mapper.selectMember_byIDPwd("admin@naver.com", "1111"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			fail();
//		}
//	}
	
//	@Test
//	void uhh() {
//		MemberVO memberVo = new MemberVO("test2@naver.com", "1111", "테스트2");
		//MembertestVO memberVo = new MembertestVO(1);
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		this.mapper.insertMemberNo(map);
//		System.out.println(map.get("no"));
		//System.out.println(memberVo.toString());
		
		//this.service.registerMember(memberVo);
		//memberVo.setNo(12);
//		this.service.registerMember(memberVo);
//		
//	}
	@Test
	void sad() {
		String email = "admin@naver.com";
		boolean result = this.service.retrieveEmail(email);
//		if(result != null) {
//			return true;
//		} else {
//			return false;
//		}
		System.out.println(result);
	}

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
	
	@Autowired
	private MemberMapper memberMapper;
	@Disabled @Test
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
//	void tesss() {
//		//MemberVO vo = new MemberVO();
//		vo.setEmail("yn_du@naver.com");
//		vo.setPassword("1234");
//		this.memberMapper.updateTempPassword(vo);
//	}
	
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
	@Disabled @Test
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
