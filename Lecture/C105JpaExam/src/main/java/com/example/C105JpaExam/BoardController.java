package com.example.C105JpaExam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService bs;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	
	@PostMapping("create")
	public String createData(@ModelAttribute Board board) {
		
		bs.serviceCreate(board);
		
		return "redirect:/";
	}
	
}