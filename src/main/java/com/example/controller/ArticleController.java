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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.example.service.board.ArticleService;
import com.example.service.board.FileService;
import com.example.service.board.ReplyService;
import com.example.util.FileManager;
//import com.example.util.FileManager;
import com.example.vo.board.ArticleVO;
import com.example.vo.board.BoardVO;
import com.example.vo.board.FileFormVO;
import com.example.vo.board.FileVO;
import com.example.vo.board.ReplyVO;
import com.example.vo.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleController {

	private ArticleService articleService;
	private FileManager fileManager;
	private FileService fileService;
	private ReplyService replyService;

	@Autowired
	public ArticleController(ArticleService articleService, FileManager fileManager, FileService fileService,
			ReplyService replyService) {
		this.articleService = articleService;
		this.fileManager = fileManager;
		this.fileService = fileService;
		this.replyService = replyService;
	}

	@GetMapping("/detailArticle/{articleNo}")
	public String detailArticle(@PathVariable("articleNo") int articleNo, Model model) {
		// create
//		this.articleService.upViewcount(articleNo); // 조회수 증가
		ArticleVO article = this.articleService.retrieveArticle(articleNo);
		// bind
		article.setNo(articleNo);
		log.info("detail Art No" + article.getNo());
		List<ReplyVO> replys = this.replyService.retrieveAllReply(articleNo);
		article.setReplyList(replys);
		// view
		model.addAttribute("article", article);
		log.info("detail 넘기는 aritcle: {}", article.toString());
		model.addAttribute("HomeContent", "/view/board/detailArticle");

		return "view/home/viewHomeTemplate";
	}

	@GetMapping("/writeArticleForm")
	public String writeForm(HttpServletRequest req, Model model) {
		// create
		ArticleVO articleVO = new ArticleVO(); // WriteForm에서 값들을 담을 객체
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		// bind
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList.add(new BoardVO(1, "어류"));
		boardList.add(new BoardVO(2, "조류"));
		boardList.add(new BoardVO(3, "영장류"));
		boardList.add(new BoardVO(11, "썸네일"));
		// view
		model.addAttribute("boardList", boardList);
		model.addAttribute("articleVO", articleVO);
		model.addAttribute("gradeNo", member.getGrade()); // 나중에 seesion member에 접근해서 grade_no 받아올 것
		model.addAttribute("HomeContent", "/view/board/writeArticleForm");
		return "view/home/viewHomeTemplate";
	}

	@GetMapping("/updateArticleForm/{articleNo}")
	public String writeForm(@PathVariable int articleNo, HttpServletRequest req, Model model) {
		log.info("updateForm articleNo: " + articleNo);
		ArticleVO article = this.articleService.retrieveArticle(articleNo); // 게시글 정보 가져오기
		// create
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		// bind
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		boardList.add(new BoardVO(1, "어류"));
		boardList.add(new BoardVO(2, "조류"));
		boardList.add(new BoardVO(3, "영장류"));
		// view
		model.addAttribute("boardList", boardList);
		model.addAttribute("article", article);
		model.addAttribute("gradeNo", member.getGrade()); // 나중에 seesion member에 접근해서 grade_no 받아올 것
		model.addAttribute("HomeContent", "/view/board/updateArticleForm");
		return "view/home/viewHomeTemplate";
	}

// Create

	@PostMapping("/insertArticle")
	public RedirectView insertArticle(@ModelAttribute("articleVO") ArticleVO articleVO, @ModelAttribute FileFormVO form,
			HttpServletRequest req) throws IOException {
		log.info("insert접근");
		// create
		RedirectView redirectView = new RedirectView();
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		// 파일 첨부 지정 폴더에 Upload도 동시에 실행
		FileVO attacheFile = fileManager.uploadFile(form.getImportAttacheFile()); // 첨부 파일
		List<FileVO> imageFiles = fileManager.uploadFiles(form.getImageFiles()); // 이미지 파일
		if (imageFiles.size() > 0) {
			fileManager.createThumbnail(imageFiles.get(0).getSystemFileName()); // 썸네일 생성
		}
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
	@GetMapping("/nListArticle/{boardNo}")
	public String selectAllNomalArticle(@PathVariable("boardNo") int boardNo, Model model) {
		// create
		List<ArticleVO> articles = this.articleService.retrieveBoard(boardNo);
		// bind
		FileVO file = new FileVO();
		for (ArticleVO article : articles) {
			file.setArticleNo(article.getNo());
			file.setFileType(1);
			FileVO thumbFile = this.fileService.retrieveThumbFile(file);
			article.setThumbnail(thumbFile);
			log.info("$$$$$$$$$$$$$$" + article.toString());
		}

		model.addAttribute("boardName", boardNo); // 차후 이름으로 변경할것
		model.addAttribute("articles", articles); // 게시글 정보 전송
		// view
		int boardkind = 0; // 0 nomal, 1: thumbnail, 2: note
		model.addAttribute("boardkind", boardkind); // 게시글 유형
		return "/view/home/viewBoardTemplate";
	}
	
	
	
	@GetMapping("/removeArticle/{articleNo}/{boardNo}")
	public RedirectView removeArticle(@PathVariable("articleNo") int articleNo, @PathVariable("boardNo") int boardNo) {
		RedirectView redirectView = new RedirectView();
		this.articleService.removeArticle(articleNo);
		redirectView.setUrl("/nListArticle/" + boardNo);
		return redirectView;
	}

//	// 추천
//	@PostMapping("/RecUpdate")
//	@ResponseBody
//	public int recUpdate(@RequestParam("memberNo") int memberNo, 
//									@RequestParam("articleNo") int articleNo) {
//
//		this.articleService.recUpdate(memberNo, articleNo);
//
//		int totalCount = this.articleService.totalRecCount(articleNo);
//		return totalCount;
//	}
//
//	// 총 추천 수
//	@PostMapping("/RecUpdate")
//	@ResponseBody
//	public int recUpdate(@RequestParam("articleNo") int  articleNo) {
//
//		int totalCount = this.articleService.totalRecCount(articleNo);
//		return totalCount;
//	}

}
