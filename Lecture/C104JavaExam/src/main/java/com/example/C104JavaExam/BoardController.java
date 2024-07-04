package com.example.C104JavaExam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
//	
//	@PostMapping("/board")
//	public String boardData(@RequestParam ("title") String title,
//							@RequestParam ("content") String content
//							) {
//		
//		System.out.println(title);
//		System.out.println(content);
//		return "redirect:/";
//		
//	}
	
	//ModelAttribute어노테이션을 사용하여 객체 형식으로 주고받기
	//원래는 변수 하나하나를 리퀘스트 파람으로 전달받았음
	@PostMapping("/board")
	public String board(@ModelAttribute Board board) {
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		return "redirect:/boardlist";
	}
	
	@GetMapping("/boardlist")
	public String boardlist() {
		return "boardlist";
	}
	
	//보드 기능 업그레이드
	
	@GetMapping("/boarddetail/{no}")
	public String boarddetail(@PathVariable("no") String no) {
		
		System.out.println("넘어온 번호는 = "+no);
		return "redirect:/boardlist";
		
	}
}
