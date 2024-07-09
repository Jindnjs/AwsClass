package com.mysite.C202admin;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService bs;
	
	@PostMapping("/board/create")
	public String create(@ModelAttribute Board board) {
		bs.create(board);
		
		return "redirect:/readlist";
	}
	@GetMapping("readlist")
	public String read(Model model) {
		List<Board> blist = this.bs.getAll();
		model.addAttribute("boardList",blist);
		return "readlist";
	}
}
