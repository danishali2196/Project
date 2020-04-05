package com.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ats.command.ChangePasswordCommand;
import com.ats.command.UserDetails;
import com.ats.service.UserService;

@Controller
public class UserSignUpController {
	@Autowired
	UserService service;
 
	@GetMapping(value="/user/signup")
	public String loadSignUp(Model model) {
		UserDetails user = new UserDetails();
		model.addAttribute("user", user);
		return "userSignUpPage";
		
	}
	
	@PostMapping(value="/user/signup")
	public String handleSubmitBtn(@ModelAttribute("user") UserDetails user){
		user.setAccStatus("lock");
		user.setRole("user");
		user.setActiveSwitch("active");
		String msg = service.saveUserRegDetails(user);
		System.out.println(msg);
		return "sendMailSuccessPage";
	} 
	
	@GetMapping(value="/user/changePwd")
	public String loadChangePasswordPage(Model model,@RequestParam("email") String email) {
		ChangePasswordCommand cmd = new ChangePasswordCommand();
		cmd.setTemail(email); 
		model.addAttribute("cmd", cmd); 
		return "newPasswordPage";
	}
	
	@PostMapping(value="/user/changePwd")
	public String saveNewPwd(@ModelAttribute("cmd") ChangePasswordCommand pwdCmd) {
		String msg = service.insertNewPwd(pwdCmd);
		System.out.println(msg);
		return "unlockAccSuccessPage";
	}
	 
	@PostMapping(value="/emailValidation")
	public @ResponseBody Integer checkEmailUnique(@ModelAttribute("email") String email) {
		System.out.println("UserSignUpController.checkEmailUnique()");
		String check = service.getEntityByEmail(email);
		Integer msg = 0;
		if (check != null) {
			msg =  1;
		}
		return msg;
	}
}
