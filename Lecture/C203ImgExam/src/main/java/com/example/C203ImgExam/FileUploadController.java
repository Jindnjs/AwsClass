package com.example.C203ImgExam;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@Autowired
	S3Service s3service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		s3service.uploadFile(file);
		return "redirect:/";
	}
	
	@GetMapping("/download")
	public String download() {
		return "download";
	}
}
