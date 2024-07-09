package com.mysite.C202admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/index.html")
	public String index1() {
		return "redirect:/";
	}
	@GetMapping("/index")
	public String index2() {
		return "redirect:/";
	}

	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "createBoard";
	}
}
