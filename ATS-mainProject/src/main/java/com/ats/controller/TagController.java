package com.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ats.command.TagDetailCommand;
import com.ats.service.TagService;

@Controller
public class TagController {
	@Autowired
	TagService service;

	@PostMapping(value="/tag/perchase")
	public String getVehicleInfo(@ModelAttribute("info")TagDetailCommand info) {
		String perchaseTag = service.perchaseTag(info);
		System.out.println(perchaseTag);
		
		return null;
	}
}
