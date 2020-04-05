package com.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ats.command.ForgotPwdCommand;
import com.ats.service.UserService;

@Controller
public class ForgotPwdController {
	@Autowired
	UserService service;
	
	@GetMapping(value="/user/forgotPwd")
	public String showPage(Model model) {
		model.addAttribute("forgotPwdCmd", new ForgotPwdCommand());
		return "forgotPwdPage";
	}
	
	@PostMapping(value="/user/forgotPwd")
	public String formData(@ModelAttribute("forgotPwdCmd") ForgotPwdCommand cmd) {
		
		String msg = service.getEntityByEmail(cmd.getValidEmail());
		
		return "redirect:/home";
		
	}

}
