package com.example.C104JavaExam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/") // = 서버 -> 클라이언트로 전달 / 주소창의 주소역할
	public String index() {
		return "index"; // index.html 호출, .html은 생략 
						// templates폴더의 html파일들의 이름을 반환하는것.
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	@GetMapping("/exam")
	public String exam() {
		return "exam";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/signup") //클라이언트 > 서버 전달
	public String signup(@RequestParam ("id") String id,
							 @RequestParam ("pass") String pass
			) {
		
		System.out.println(id);
		System.out.println(pass);
		return "index";
	}
	
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
		return "index";
		
	}
}
