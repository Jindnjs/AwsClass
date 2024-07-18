package com.example.C304MultiBoard.Board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/boardlist")
	public String read(Model model) {
		model.addAttribute("boards", boardService.readlist());
		return "boardlist";
	}
	
	@GetMapping("/board/detail/{id}")
	public String read(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("board", boardService.readdetail(id));
		return "boarddetail";
	}
	@GetMapping("/board/create")
	public String create() {
		return "boardcreate";
	}
	@PostMapping("/board/create")
	public String create(@ModelAttribute Board board) {
		Integer id = boardService.create(board);
		return "redirect:/board/detail/"+ id;
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		boardService.delete(id);
		return "redirect:/boardlist";
	}
	
	
}
