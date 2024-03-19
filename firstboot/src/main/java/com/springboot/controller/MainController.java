package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/index")
	public String home() {
		System.out.println("this is home page");
		return"home";
	}

		@GetMapping("/contact")
		public String contact() {
			System.out.println("this is contact page");
			return"contact";
		}

}
