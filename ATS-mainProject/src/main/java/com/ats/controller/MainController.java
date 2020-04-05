package com.ats.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ats.command.LoginCmd;

  
@Controller
public class MainController {
	
	
	@GetMapping(value="/home")  
	public String showHome(Model model,HttpServletRequest req) {
		LoginCmd login = new LoginCmd();
		
		model.addAttribute("msg", null); 
		model.addAttribute("user", login);
		return "home"; 	 
	}
	
	
	
	
	
	

	
}
