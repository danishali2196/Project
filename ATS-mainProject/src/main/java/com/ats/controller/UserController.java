package com.ats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping(value="/user")
	public String userHome() {
		return "userHome";
	}
	
	@GetMapping(value="/user/searchVhcl")
	public String searchVehicle() {
		return "vehicleSearchPage";
	}

}
