package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

//	user security 기본 id : user / password : 콘솔 Using generated security password: ex)75f93c5c-c13c-4bcf-aa11-b9c47b0f899a
	
	@GetMapping("/manager")
	public String manager(Model model) {
		model.addAttribute("memberContent","/fragments/viewMainContent");
		return "view/home/viewManagerTemplate";
	}
	
}
