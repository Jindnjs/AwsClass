package com.mysite.ProjSelPrac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/index")
	public String index1() {
		return "index";
	}
	@GetMapping("/index.html")
	public String index2() {
		return "index";
	}
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
}
