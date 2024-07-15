package com.example.C301MailExam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MailController {

	private final MailService mailService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	@PostMapping("/create")
	public String create(@RequestParam("title") String title
						,@RequestParam("content") String content
						,@RequestParam("addr") String addr
						) {
		mailService.create(title,content,addr);
		return "index";
	}
}
