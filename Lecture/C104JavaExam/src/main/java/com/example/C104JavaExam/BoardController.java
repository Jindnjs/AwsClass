package com.example.C104JavaExam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	@PostMapping("/board")
	public String boardData(@RequestParam ("title") String title,
							@RequestParam ("content") String content
							) {
		
		System.out.println(title);
		System.out.println(content);
		return "redirect:/";
		
	}
	
	@GetMapping("/bbd")
	public String bbd() {
		return "bbd";
	}
}
