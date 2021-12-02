package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.member.GradeService;
import com.example.service.member.MemberService;
import com.example.vo.member.GradeVO;
import com.example.vo.member.MemberVO;
import com.example.vo.paging.Criteria;
import com.example.vo.paging.Paging;

import lombok.extern.slf4j.Slf4j;

//여기부터가 기본 세팅
@Slf4j
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private GradeService gradeService;

//	회원가입
	@PostMapping("/join") // 이걸 실행하는 값의 주소
	public String joinMember(MemberVO mVo) {
		this.memberService.registerMember(mVo);
		return "redirect:/"; // string으로 리턴되는건 html 파일로 넘어감! (회원가입 다음 로그인화면으로 넘어가고 싶다면 templates 안에 있는 로그인
								// html 파일명 쓰기)
	}

	@GetMapping("/members")
	public String viewMemberList(Model model, Criteria crt) {
		List<MemberVO> lst = null;
		Paging paging = new Paging();
		try {
			int total = this.memberService.retrieveTotalMember();
			paging.setCrt(crt);
			paging.setTotal(total);
			lst = this.memberService.retrieveMemberList(crt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("lst", lst);
		model.addAttribute("paging", paging);
		return "view/member/memberList";
	}

	@PostMapping("/members")
	@ResponseBody
	public Object viewSearchList(@RequestParam("keyword") String keyword, @RequestParam("keyfield") String keyfield,
			Model model, Criteria crt) {
		List<MemberVO> lst = null;
		Paging paging = new Paging();
		try {
			int total = this.memberService.retrieveTotalSearchMember(keyfield, keyword);
			paging.setCrt(crt);
			paging.setTotal(total);
			lst = this.memberService.retrieveSearchMember(crt, keyfield, keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("paging", paging);
		model.addAttribute("lst", lst);
		return model;
	}

	@GetMapping("/members/{no}")
	public String viewMemberDetail(Model model, @PathVariable int no) {
		MemberVO member = this.memberService.retrieveMemberByManager(no);
		log.info(member.toString());
		model.addAttribute("member", member);
		model.addAttribute("managerContent", "/fragments/view/ManagerContent");
		System.out.println(model);
		return "view/member/detailMemberByManager";
	}

	@PostMapping("/members/{no}")
	public String updateBanDate(@PathVariable int no, @RequestParam String banSelect) {
		this.memberService.modifyBan(banSelect, no);
		return "redirect:/members";
	}

	@PostMapping("/memberOut/{no}")
	public String updateOutByManager(@PathVariable int no) {
		this.memberService.modifyMemberByForce(no);
		return "redirect:/members";
	}

	@GetMapping("/grades")
	public String viewGradeList(Model model) {
		ArrayList<GradeVO> grades = null;
		try {
			grades = this.gradeService.retrieveGradeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("grades", grades);
		return "view/member/gradeList";
	}
	
//	회원 자진 탈퇴
	@GetMapping("/outForm")  //이걸 실행하는 값의 주소
	public String outMember(MemberVO mVo, HttpSession session) {
		log.info("" + session.getAttribute("loginUser"));
		//this.memberService.modifyMember(member.getNo(), password);
		return "view/member/out"; 
	}

	
	
//	@GetMapping("/members")
//	public String callMemberList(Model model) {
//		List<MemberVO> lst = this.memberService.retrieveMemberList(0, 0);
//		model.addAttribute(lst);
//		return "memberList";
//	}
//	
//	@GetMapping("/members/{no}")
//	public String callMemberDetail(Model model, @PathVariable int no) {
//		MemberVO member = this.memberService.retrieveMemberByManager(no);
//		model.addAttribute(member);
//		model.addAttribute("managerContent","/fragments/view/ManagerContent");
//		return "view/member/detailMemberByManager";
//	}
	
	@PostMapping("/grades")
	public String modifyGrade(Model model, HttpServletRequest req) {
		String[] stringNo = req.getParameterValues("gradeNo");
		String[] stringDocs = req.getParameterValues("docs");
		String[] stringComms = req.getParameterValues("comms");
		String[] names = req.getParameterValues("name");

		int[] docs = Arrays.stream(stringDocs).mapToInt(Integer::parseInt).toArray();
		int[] comms = Arrays.stream(stringComms).mapToInt(Integer::parseInt).toArray();
		int[] gradeNo = Arrays.stream(stringNo).mapToInt(Integer::parseInt).toArray();

		try {
			int oldGradeSize = this.gradeService.retrieveGradeList().size();
			int newGradeSize = gradeNo.length;
			for (int i = 0; i < newGradeSize; i++) {
				gradeNo[i] = i + 1;
				GradeVO grade = new GradeVO();
				grade.setGradeNo(gradeNo[i]);
				grade.setName(names[i]);
				grade.setDocs(docs[i]);
				grade.setComms(comms[i]);
				this.gradeService.modifyGrade(grade);
			}

			if (oldGradeSize > newGradeSize) {
				for (int i = newGradeSize; i < oldGradeSize; i++) {
					this.gradeService.removeGrade(i + 1);
				}
			}

			this.gradeService.sortGrade();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/grades";
	}

	@GetMapping("/grades/{gradeNo}")
	public void viewOpenBoardByGrade(Model model, @PathVariable int gradeNo) {
		Map<String, Object> map = null;
		try {
			map = this.gradeService.retrieveGradeBoardList(gradeNo);
			model.addAttribute(map);
			System.out.println(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
