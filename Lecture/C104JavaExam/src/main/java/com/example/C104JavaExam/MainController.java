package com.example.C104JavaExam;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/index")
	public String index2() {
		return "index";
	}
	@GetMapping("/index.html")
	public String index3() {
		return "index"; 
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
	
	@Autowired
	private MainService ms;
//	
	@PostMapping("/signup") //클라이언트 > 서버 전달
	public String signup(@RequestParam ("id") String id,
							 @RequestParam ("pass") String pass
			) {
		
		System.out.println("컨트롤러로 넘오온 id = "+id);
		System.out.println("컨트롤러로 넘어온 ps = "+pass);
		
		//서비스 객체 생성
		//Autowired 어노테이션 사용시 사용하지 않음(메소드 외부에서 선언)
		//MainService mainService = new MainService();
		
		//서비스의 메소드실행
		ms.serviceCreate(id,pass);
		
		return "redirect:/";
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
		return "redirect:/";
		
	}
	
	@GetMapping("/bbd")
	public String bbd() {
		return "bbd";
	}
}
