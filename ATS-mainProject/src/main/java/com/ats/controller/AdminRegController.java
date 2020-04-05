package com.ats.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ats.command.UserDetails;
import com.ats.entity.UserDetailsEntity;
import com.ats.service.UserService;

@Controller
public class AdminRegController {
	@Autowired
	UserService service;
	
	@GetMapping(value="/admin/reg")
	public String showRegistrationForm(Model model) {
		model.addAttribute("cmd", new UserDetails());
		return "adminAgencyRegPage";
	}
	
	@PostMapping(value="/admin/reg")
	public String getFormData(@ModelAttribute("cmd") UserDetails cmd) {
		cmd.setAccStatus("lock");
		cmd.setActiveSwitch("active");
		UserDetailsEntity userEntity = new UserDetailsEntity();
		BeanUtils.copyProperties(cmd, userEntity);
		
		String msg = service.insertAdminForm(userEntity);
		System.out.println();
		return "redirect:/admin";
	}
	

}
