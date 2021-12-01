package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.etc.DailyStatisticsServiceImpl;
import com.example.service.etc.TotalStatisticsServiceImpl;
import com.example.vo.etc.DailyStatisticsVO;
import com.example.vo.etc.TotalStatisticsVO;

@Controller
public class ManagerController {

//	user security 기본 id : user / password : 콘솔 Using generated security password: ex)75f93c5c-c13c-4bcf-aa11-b9c47b0f899a

	@Autowired
	DailyStatisticsServiceImpl dailyServiceImpl;

	@Autowired
	TotalStatisticsServiceImpl totalServiceImpl;

	@GetMapping("/manager")
	public String manager(Model model) {
		model.addAttribute("memberContent", "fragments/MemberContent");
		return "view/home/viewManagerTemplate";
	}

	@GetMapping("/manager/daily")
	public String managerDaily(Model model) {

		DailyStatisticsVO dailyVo = dailyServiceImpl.retrieve();
		ArrayList<DailyStatisticsVO> dailyList = dailyServiceImpl.retrieveList();
		
		dailyServiceImpl.registerAndmodifyDaily();
		
		model.addAttribute("memberContent", "fragments/StatisticsDailyContent");

		model.addAttribute("dailyOne", dailyVo);
		model.addAttribute("dailyList", dailyList);

		return "view/home/viewManagerTemplate";
	}

	@GetMapping("/manager/total")
	public String managerTotal(Model model) {

		totalServiceImpl.registerAndmodifyTotal();
		
		TotalStatisticsVO totalVo = totalServiceImpl.retrieve();
		
		

		model.addAttribute("memberContent", "fragments/StatisticsTotalContent");

		model.addAttribute("totalOne", totalVo);

		return "view/home/viewManagerTemplate";
	}

}
