package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.service.board.ArticleService;
import com.example.util.FileManager;
//import com.example.util.FileManager;
import com.example.vo.board.ArticleVO;
import com.example.vo.board.BoardVO;
import com.example.vo.board.FileFormVO;
import com.example.vo.board.FileVO;
import com.example.vo.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {

	private ArticleService articleService;
	private FileManager fileManager;
	
	@Autowired
	public ArticleController(ArticleService articleService, FileManager fileManager) {
		this.articleService = articleService;
		this.fileManager = fileManager;
	}

	@GetMapping("/detailArticle/{articleNo}")
	public String detailArticle(@PathVariable("articleNo") int articleNo, Model model) {
		// create
		ArticleVO article = this.articleService.retrieveArticle(articleNo);
		// bind
		model.addAttribute("article", article);
		// view
		return "/view/board/detailArticleTemplate";
	}

	@GetMapping("/writeArticleForm")
	public String writeForm(HttpServletRequest req, Model model) {
		// create
		ArticleVO articleVO = new ArticleVO(); // WriteForm에서 값들을 담을 객체
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		// bind
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList.add(new BoardVO(1, "어류"));boardList.add(new BoardVO(2, "조류"));	boardList.add(new BoardVO(3, "영장류"));
		// view
		model.addAttribute("boardList", boardList);
		model.addAttribute("articleVO", articleVO);
		model.addAttribute("gradeNo", member.getGrade());  // 나중에 seesion member에 접근해서 grade_no 받아올 것
		return "/view/board/wrtieArticleFormTemplate";
	}

// Create

	@PostMapping("/insertArticle")
	public RedirectView insertArticle(@ModelAttribute("articleVO") ArticleVO articleVO,
													@ModelAttribute FileFormVO form,    
													HttpServletRequest req) throws IOException {
		log.info("insert접근");
		// create
		RedirectView redirectView = new RedirectView();
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		// 파일 첨부 지정 폴더에 Upload도 동시에 실행
		FileVO attacheFile = fileManager.uploadFile(form.getImportAttacheFile()); //첨부 파일
		List<FileVO> imageFiles = fileManager.uploadFiles(form.getImageFiles()); // 이미지 파일
		
		// bind
		articleVO.setMemberNo(member.getNo());
		articleVO.setNickname(member.getNickname());
		articleVO.setAttacheFile(attacheFile);
		articleVO.setFileList(imageFiles);
		
		this.articleService.registerArticle(articleVO);
		int articleNo = articleVO.getNo(); // 작성 후 게시글 세부조회page로 넘어가기 때문에 게시글 번호를 넘겨준다.
		log.info("입력 게시글={}", articleVO.toString());
		// view
		redirectView.setUrl("/detailArticle/" + articleNo);
		return redirectView;
	}

// 게시판 목록 조회

	// 노말 tpye board
	@GetMapping("/nListArticle")
	public ModelAndView selectAllNomalArticle(@RequestParam int boardNo) {
		// create
		ModelAndView mav = new ModelAndView();
		List<ArticleVO> articles = this.articleService.retrieveBoard(boardNo);
		// bind
		mav.addObject("boardName", boardNo); // 차후 이름으로 변경할것
		mav.addObject("articles", articles); // 게시글 정보 전송
		// view
		mav.setViewName("/view/board/listArticleNomal");
		return mav;
	}

}
