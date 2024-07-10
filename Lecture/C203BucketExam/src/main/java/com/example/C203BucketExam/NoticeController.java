package com.example.C203BucketExam;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

	private final NoticeService ns;
	
	@Value("${cloud.aws.s3.endpoint}")
	private String downPath;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/create")
	public String create() {
		return "create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Notice notice,
						  @RequestParam("file") MultipartFile file1
						  ) throws IOException {
		ns.create(notice, file1);
		return "redirect:/";
	}
	
	@GetMapping("/readlist")
	public String readlist(Model model) {
		
		model.addAttribute("noticeList",ns.readlist());
		model.addAttribute("downPath", "https://"+downPath);
		return "readlist";
	}
}
