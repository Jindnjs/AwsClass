package com.mysite.C202admin;


import java.util.List;

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
	
	private final BoardService bs;
	private final ReplyService rs;
	
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
	
	@GetMapping("/board/detail/{id}")
	public String readRepl(Model model, @PathVariable("id") Integer id) {
		Board b = this.bs.getBoardById(id);
		model.addAttribute("board",b);
		
		return "board_detail";
	}
	@PostMapping("/board/create/{id}")
	public String addRepl(@ModelAttribute Reply re,
			@PathVariable("id") Integer id) {
		rs.addRepl(re,id);
		
		return "redirect:/board/detail/"+id;
	}
	@GetMapping("/board/detail/del/{bid}/{rid}")
	public String delRepl(@PathVariable("rid") Integer rid,
			@PathVariable("bid") Integer bid) {
		rs.delete(rid);
		
		return "redirect:/board/detail/"+bid;
	}
	@GetMapping("/update/{id}")
	public String updateBoard(Model model, @PathVariable("id") Integer id) {
		
		Board b = bs.getBoardById(id);
		model.addAttribute("board",b);
		
		return "update";
	}
	
	@PostMapping("/board/update")
	public String update(@ModelAttribute Board bo) {
		bs.update(bo);
		return "redirect:/readlist";
	}
}
