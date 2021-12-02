package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.board.BoardService;
import com.example.service.board.CategoryService;
import com.example.service.member.GradeService;
import com.example.vo.board.BoardBoardGradeVO;
import com.example.vo.board.BoardVO;

import org.springframework.web.servlet.view.RedirectView;

import com.example.vo.board.CategoryVO;
import com.example.vo.member.GradeVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private GradeService gradeService;

//	@GetMapping("/main")
//	public String petopiaMain(Model model) {
//		model.addAttribute("HomeContent","fragments/categoryBoardListContent");
//		return "view/home/viewHomeTemplate";
//	}

	// 게시판
	@GetMapping("/board")
	public String petopiaMain(Model model) {
		model.addAttribute("HomeContent", "fragments/categoryBoardListContent");
		return "view/home/viewHomeTemplate";
	}

	//카테고리 + 게시판 목록 조회 ( 관리자 )
	@GetMapping("/boardManager")
	public String boardManager(Model model) {
		List<CategoryVO> categoryList = this.categoryService.retrieveCategoryBoardList();
		model.addAttribute("categoryBoardList", categoryList);
		model.addAttribute("managerContent", "/view/board/boardManager");

		//카테고리 추가
		CategoryVO categoryVo = new CategoryVO();
		model.addAttribute("categoryVo", categoryVo);
		return "view/home/viewManagerTemplate";
	}
	
	
	//카테고리 추가
	@PostMapping("/writeCategory")
	public String writeCategory(@ModelAttribute("categoryVo") CategoryVO categoryVo) {
		this.categoryService.registerCategory(categoryVo.getCategoryName());
		return "redirect:boardManager"; //이  페이지 안에서만 움직일 거기 때문에 리턴 페이지 변경 안 해도 된다고
	}
	

	//카테고리 수정
	@PostMapping("/modifyCategory")
	public String modifyCategory(@ModelAttribute("categoryVo") CategoryVO categoryVo) {
		log.info("-----------------------------------------------" + categoryVo.toString());
		int categoryNo = categoryVo.getCategoryNo();
		String categoryName = categoryVo.getCategoryName();
		System.out.println(categoryNo + " " + categoryName);
		this.categoryService.modifyCategory(categoryNo, categoryName);
		return "redirect:boardManager";
	}
	
	//카테고리 삭제
	@PostMapping("/deleteCategory")
	public String deleteCategory(@ModelAttribute("categoryVo") CategoryVO categoryVo) {
		log.info("----------------------------------" + categoryVo.getCategoryNo());
		this.categoryService.removeCategory(categoryVo.getCategoryNo());
		return "redirect:board";
	}
	
	
	
// 	//게시판 추가 - 카테고리, 등급, 게시판 종류 목록 조회
// 	@PostMapping("/selectList")
// 	public String writeBoardForm(Model model) throws Exception  {
		

		
// 		ArrayList<CategoryVO> categoryList = this.categoryService.retrieveCategoryList();
// 		ArrayList<BoardBoardGradeVO> boardList = this.boardService.retrieveAllBoard();
// 		model.addAttribute("categoryList", categoryList);
// 		model.addAttribute("boardList", boardList);
		
// 		log.info("-------------------------------------------------categoryList" + categoryList.toString());
// 		log.info("-------------------------------------------------boardList" + boardList.toString());
// 		return "redirect:boardManager";
// 	}

	
	//게시판 추가 - 저장
//	@PostMapping("/writeBoard")
////	public String writeBoard(@ModelAttribute("boardBoardGradeVo") BoardBoardGradeVO boardBoardGradeVo) {
//	
//			@RequestParam("categoryNo") int categoryNo,
//			@RequestParam("boardName") String boardName,
//			@RequestParam("boardkind") int boardkind,
//			@RequestParam("readGrade") int readGrade,
//			@RequestParam("writeGrade") int writeGrade) {
//		
//		BoardBoardGradeVO boardBoardGradeVo = new BoardBoardGradeVO();
//		//게시판 저장 목록
//		categoryNo = boardBoardGradeVo.getBoardVo().getCategoryNo();
//		boardName = boardBoardGradeVo.getBoardVo().getBoardName();
//		boardkind = boardBoardGradeVo.getBoardVo().getBoardkind();
//		readGrade = boardBoardGradeVo.getBoardGradeVo().getReadGrade();
//		writeGrade = boardBoardGradeVo.getBoardGradeVo().getWriteGrade();
//		
//		log.info("BoardController CategoryNo----------------------- " + boardBoardGradeVo.getBoardVo().getCategoryNo());
//		log.info("BoardController ReadGrade ----------------------- " + boardBoardGradeVo.getBoardGradeVo().getReadGrade());
//		
//		this.boardService.registerBoard(boardBoardGradeVo.getBoardVo(), boardBoardGradeVo.getBoardGradeVo());
//		return "redirect:boardManager";
//	}

	@GetMapping("/nListArticlereq/{boardNo}/{boardkind}")
	public RedirectView amuguna(@PathVariable("boardNo") int boardNo, @PathVariable("boardkind") int boardkind, HttpServletRequest request) {
		RedirectView rv = new RedirectView();
		request.setAttribute("boardNo", boardNo);
		rv.addStaticAttribute("boardKind", boardkind);
		rv.setUrl("/nListArticle/" + boardNo);
		return rv;
	}
	
}
