package com.ciaancybertech.mini_linkedin_services.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/get")
	public String test() {
		return "Hello world";
	}

}
