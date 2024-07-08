package com.mysite.ProjSelPrac.Board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final SinglePostTextRepository srepo;
	
	@GetMapping("/board1")
	public String board1(Model model) {
		List<SinglePostText> singleposttextList = this.srepo.findAllByOrderByCreateDateDesc();
        model.addAttribute("singleposttextList", singleposttextList);
        model.addAttribute("totalboards", singleposttextList.size());
		return "Board1";
	}
	@GetMapping("/board2")
	public String list(Model model) {
		List<SinglePostText> singleposttextList = this.srepo.findAll();
        model.addAttribute("singleposttextList", singleposttextList);
		return "board2";
	}
	
}
