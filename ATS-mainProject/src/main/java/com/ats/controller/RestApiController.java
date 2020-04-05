package com.ats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.command.TagDetailCommand;
import com.ats.domain.VehicleInfo;
import com.ats.restService.RtoRestService;
import com.ats.service.UserService;

@Controller
public class RestApiController {
	
	@Autowired
	RtoRestService service;
	
	@GetMapping(value="/rest")
	public String showForm() {
		return "vehicleSearchPage";
	}
	
	@GetMapping(value="/rest/info")
	public String getVhclInfo(Model model,@RequestParam("vhclRegNo") String vhclNo) {
		VehicleInfo vhclInfo = service.findVehicleUsingRest(vhclNo);
		TagDetailCommand info = new TagDetailCommand();
		model.addAttribute("info", info);
		model.addAttribute("vhclInfo", vhclInfo);
		return "vehicleSearchPage";
	}
	
	

}
