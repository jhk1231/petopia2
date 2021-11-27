package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.example.vo.board.ArticleVO;
import com.example.vo.board.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {

	private ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("/detailArticle/{articleNo}")
	public String detailArticle(@PathVariable("articleNo") int articleNo, Model model) {
		ArticleVO article = this.articleService.retrieveArticle(articleNo);
		model.addAttribute("article", article);
		return "/view/board/detailArticleTemplate";
	}

	@GetMapping("/writeArticleForm")
	public String writeForm(Model model) {
		ArticleVO articleVO = new ArticleVO();
		// 임시 값들
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList.add(new BoardVO(1, "어류"));
		boardList.add(new BoardVO(2, "조류"));
		boardList.add(new BoardVO(3, "영장류"));
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("articleVO", articleVO);
		model.addAttribute("gradeNo", 1);  // 나중에 seesion member에 접근해서 grade_no 받아올 것
		return "/view/board/wrtieArticleFormTemplate";
	}

// Create

	@PostMapping("/insertArticle")
//	public void insertArticle(HttpSession session,// @SessionAttribute("loginUser") MemberVO member
	public RedirectView insertArticle(@ModelAttribute("articleVO") ArticleVO articleVO) {
		RedirectView redirectView = new RedirectView();
//		MemberVO member = (MemberVO) session.getAttribute("loginUser");
//		article.setMemberNo(member.getNo());
//		article.setNickname(member.getNickname());
		
		articleVO.setMemberNo(1);
		articleVO.setNickname("임시입력");
		log.info(articleVO.toString());
		this.articleService.registerArticle(articleVO);
		int artNo = articleVO.getNo();
		
		redirectView.setUrl("/detailArticle/" + artNo);
		return redirectView;
	}

// Select

	// 노말 tpye board
	@GetMapping("/nListArticle")
	public ModelAndView selectAllNomalArticle(@RequestParam int boardNo) {
		ModelAndView mav = new ModelAndView();
		List<ArticleVO> articles = this.articleService.retrieveBoard(boardNo);
		mav.addObject("boardName", boardNo); // 차후 이름으로 변경할것
		mav.addObject("articles", articles); // 게시글 정보 전송
		mav.setViewName("/view/board/listArticleNomal");
		return mav;
	}

}
