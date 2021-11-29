package com.example.petopia;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.mapper.board.CategoryMapper;
import com.example.vo.board.BoardBoardGradeVO;
import com.example.vo.board.BoardGradeVO;
import com.example.vo.board.BoardVO;

import lombok.extern.java.Log;

@Log
@SpringBootTest
class PetopiaApplicationTests {

	BoardVO boardVo = new BoardVO();
	BoardGradeVO boardGradeVo = new BoardGradeVO();
	BoardBoardGradeVO boardBoardGradeVO = new BoardBoardGradeVO();
	
	@Autowired
	//private BoardMapper mapper;
	//private BoardService boardService;
	
	private CategoryMapper mapper;
	//private CategoryDao categoryDao;
	//private CategoryService categoryService;
	
//	@Test
//	void test() {		
//		assertNotNull(this.mapper);
//	}


	@Test
	void test1() {
		//문제야문제~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``
		//리스트 조회
		//System.out.println(this.mapper.selectCategoryList());
	
		//System.out.println(this.mapper.selectCategoryBoardList().toString());
		
		//카테고리 + 게시판 목록 조회
		System.out.println(this.mapper.selectCategoryBoardList());
		
		
		
		
		
		
		//즐겨찾기 게시판 조회		
//		boardVo.setNo(5);
//		for(int i = 0; i < this.boardService.retrieveFavoriteBoardList(boardVo.getNo()).size(); i++) {
//			System.out.println("boardName--------------------------------------------------------------------------------"
//					+ this.boardService.retrieveFavoriteBoardList(boardVo.getNo()).get(i).getBoardName());
//		}
		
		//즐겨찾기 게시판 삭제		
//		boardVo.setNo(5);
//		boardVo.setBoardNo(5);
//		this.boardService.removeFavoriteBoard(boardVo);

		
		//즐겨찾기 게시판 추가
//		boardVo.setNo(5);
//		boardVo.setBoardNo(5);
//		this.boardService.registerFavoriteBoard(boardVo);
		
		
		//게시판 정보 조회 
//		boardVo.setBoardNo(8);
//		BoardBoardGradeVO bbg = this.boardService.retrieveOneBoard(boardVo.getBoardNo());
//		System.out.println(bbg.getBoardVo().getCategoryNo());
//		System.out.println(bbg.getBoardVo().getBoardNo());
//		System.out.println(bbg.getBoardVo().getBoardName().toString());
//		System.out.println(bbg.getBoardVo().getBoardkind());
//		System.out.println(bbg.getBoardGradeVo().getReadGrade());
//		System.out.println(bbg.getBoardGradeVo().getWriteGrade());
//		
		//게시판 정보 조회(전체)
//		System.out.println(this.boardService.retrieveAllBoard().toString());
//
//		int num = 2;
//		System.out.println("boardNo---" + this.boardService.retrieveAllBoard().get(num).getBoardVo().getBoardNo() 
//+ " boardName---" + this.boardService.retrieveAllBoard().get(num).getBoardVo().getBoardName()
//+ " boardkind---" + this.boardService.retrieveAllBoard().get(num).getBoardVo().getBoardkind()
//+ " readwrite---" + this.boardService.retrieveAllBoard().get(num).getBoardGradeVo().getReadwrite()
//+ " gradeNo---" + this.boardService.retrieveAllBoard().get(num).getBoardGradeVo().getGradeNo());
//		
		
		
//		//게시판 이름 중복 검사
//		boardVo.setBoardName("게시판이름중복검사");
//		boardVo.setCategoryNo(1);
//		boardVo.setBoardkind(1);
//		boardGradeVo.setReadGrade(3);		
//		boardGradeVo.setWriteGrade(1);		
//		
//		int count = this.boardService.retrieveDuplicateBoard(boardVo.getBoardName());
//		System.out.println(count);
//		if (count != 0) {
//			System.out.println("게시판 이름은 중복될 수 없습니다.");
//		} else {
//			this.boardService.registerBoard(boardVo, boardGradeVo);
//		}
		
		


		
//		//게시판 수정
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("boardVo", boardVo);
//		map.put("boardGradeVo", boardGradeVo);
//		
//		boardVo.setBoardNo(11);
//		boardVo.setCategoryNo(1);
//		boardVo.setBoardName("게시판수정테스트1");
//		boardVo.setBoardkind(1);
//		boardGradeVo.setReadGrade(3);
//		boardGradeVo.setWriteGrade(4);
//		System.out.println(boardVo.toString());
//		System.out.println(boardGradeVo.toString());
//		this.boardService.modifyBoard(boardVo, boardGradeVo);
//		//---------------------------------------------------
		
//		//게시판 삭제
//		boardVo.setBoardNo(21);
//		//연결된 게시글 조회
//		int count = this.boardService.retrieveConnectArticle(boardVo.getBoardNo());
//		System.out.println(count);
//		if (count != 0) {
//			System.out.println("삭제불가");
//		} else {
//			this.boardService.removeBoard(boardVo.getBoardNo());	
//		}
//		//-------------------------------------------------------
		
		//게시판추가 
//		BoardVO boardVo = new BoardVO();
//		boardVo.setCategoryNo(1);
//		boardVo.setBoardName("게시판및등급추가Service7");
//		boardVo.setBoardkind(1);
//		boardVo = new BoardVO(boardVo.getCategoryNo(), boardVo.getBoardName(), boardVo.getBoardkind());
//		BoardGradeVO boardGradeVo = new BoardGradeVO();
//		boardGradeVo.setReadGrade(3);		
//		boardGradeVo.setWriteGrade(1);		
//		boardGradeVo = new BoardGradeVO(boardGradeVo.getReadGrade(), boardGradeVo.getWriteGrade());
//
//		this.boardService.registerBoard(boardVo, boardGradeVo);
//      --------------------------------------------------------		
		
		
		//System.out.println(this.mapper.selectOneCategory(3).toString());
		//this.mapper.insertCategory("카테고리입력테스트Mapper2");
		//this.mapper.updateCategory(10, "카테고리수정테스트2");
		
		
		//this.categoryDao.insertCategory("카테고리입력테스트Dao1");
		//this.categoryDao.updateCategory(10, "카테고리수정테스트3");
		
		//this.categoryService.registerCategory("카테고리입력테스트Service4");
		//this.categoryService.modifyCategory(9, "카테고리수정테스트Service2");
		//this.categoryService.removeCategory(10);

//		System.out.println(this.categoryService.retrieveOneCategory(8).getCategoryName());
//		System.out.println(this.categoryService.retrieveOneCategory(8).getCategoryNo());
		
		//System.out.println(this.categoryService.retrieveDuplicateCategory("카테고리234"));
		//System.out.println(this.categoryService.retrieveConnectBoard(3));
		
		//System.out.println(this.categoryService.retrieveCategoryList().toString());
		//System.out.println(this.categoryService.retrieveCategoryList());

		//등급 추가 mapper
//		BoardGradeVO boardGradeVo = new BoardGradeVO();
//		boardGradeVo.setReadGrade(5);		
//		boardGradeVo.setWriteGrade(2);			
//		boardGradeVo = new BoardGradeVO(boardGradeVo.getReadGrade(), boardGradeVo.getWriteGrade());
//		this.mapper.insertBoardGrade(boardGradeVo);


		
		

// import com.example.dao.member.MemberDao;
// import com.example.mapper.member.MemberMapper;
// import com.example.service.member.MemberService;

// @SpringBootTest
// class PetopiaApplicationTests {

// //	@Autowired
// //	private MemberService service;
// 	@Autowired
// 	private MemberMapper mapper;
	
// 	@Test
// 	void mappertest() {
// 		//System.out.println(service.login("admin@naver.com", "1111"));
// 		try {
// 			System.out.println(mapper.selectMember_byIDPwd("123@naver.com", "1234"));
// 		} catch (Exception e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}

// 	}

// }
