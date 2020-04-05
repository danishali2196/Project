package com.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ats.command.ChangePasswordCommand;
import com.ats.command.LoginCmd;
import com.ats.command.UserDetails;
import com.ats.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;
	@Autowired
	private Environment env;
	
	@PostMapping(value="/home")
	public String getUserCredential(@ModelAttribute("user") LoginCmd login,RedirectAttributes ra) {
		String user = env.getProperty("adminLogin.superAdmin.username");
		String pwd = env.getProperty("adminLogin.superAdmin.password");
		
		if((login.getUname().equals(user)) && (login.getPwd().equals(pwd))) {
			System.out.println("LoginController");
			return "redirect:/admin";
		}
		
		else {
		String check = service.checkCredential(login);
		
		if("admin".equals(check)) {
			return "redirect:/admin";
		}
		else if("agency".equals(check)) {
			return "agency";
		}
		else if ("user".equals(check)) {
			return "redirect:/user";
		}
		else if ("lock".equals(check)) {
			return "lockMsg";
		}else if ("inactive".equals(check)) {
			return "inactivePage";
		}
		else if("invalid".equals(check)) {
			System.out.println("LoginController.getUserCredential()");
			String msg = "invalid Username and Password";
			ra.addFlashAttribute("msg1",msg);
			return "redirect:/home"; 
		}
		else {
			return null;
		}
		}
	}
}
