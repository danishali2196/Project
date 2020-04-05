package com.ats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ats.entity.UserDetailsEntity;
import com.ats.service.UserService;

@Controller
public class AdminShowRecordController {
	
	@Autowired
	UserService service;
	
	@GetMapping(value="/admin/records")
	public String getAllRecords(Model model) {
		List<UserDetailsEntity> allRecords = service.findAllRecords();
		model.addAttribute("record", allRecords);
		return "displayAllUsers";
	}

}
