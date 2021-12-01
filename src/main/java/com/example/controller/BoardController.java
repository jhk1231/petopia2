package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.board.BoardService;
import com.example.service.board.CategoryService;
import com.example.service.member.GradeService;
import com.example.vo.board.CategoryVO;

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
		System.out.println("-----------------------------------------------" + categoryVo.toString());
		int categoryNo = categoryVo.getCategoryNo();
		String categoryName = categoryVo.getCategoryName();
		System.out.println(categoryNo + " " + categoryName);
		this.categoryService.modifyCategory(categoryNo, categoryName);
		return "redirect:boardManager";
	}
	
//	
//	//게시판 추가 - 목록 조회
//	@PostMapping("/selectList")
//	public String writeBoardForm(Model model) throws Exception {
//		List<CategoryVO> categoryList = this.categoryService.retrieveCategoryBoardList();
//		ArrayList<GradeVO> gradeList = this.gradeService.retrieveGradeList();
//		List<BoardVO> boardkindList = this.boardService.retrieveBoardkind();
//
//		model.addAttribute("categoryList", categoryList);
//		model.addAttribute("gradeList", gradeList);
//		model.addAttribute("boardkindList", boardkindList);
//		return "/boardManager";
//	}
//
//	
//	//게시판 추가
//	@PostMapping("/writeBoard")
//	public String writeBoard(@ModelAttribute("boardBoardGradeVo") BoardBoardGradeVO boardBoardGradeVo) {
//	
//		//게시판 저장 목록
//		boardBoardGradeVo.getBoardVo().getCategoryNo();
//		boardBoardGradeVo.getBoardVo().getBoardName();
//		boardBoardGradeVo.getBoardVo().getBoardkind();
//		boardBoardGradeVo.getBoardGradeVo().getReadGrade();
//		boardBoardGradeVo.getBoardGradeVo().getWriteGrade();
//		this.boardService.registerBoard(boardBoardGradeVo.getBoardVo(), boardBoardGradeVo.getBoardGradeVo());
//		return "redirect:boardManager";
//	}
//	
	
	
	@GetMapping("/nListArticlereq/{boardNo}/{boardkind}")
	public String amuguna(@PathVariable("boardNo") int boardNo, @PathVariable("boardkind") int boardkind, HttpServletRequest request) {
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("boardkind", boardkind);
		return "forward:nListArticle";
	}
	
}
