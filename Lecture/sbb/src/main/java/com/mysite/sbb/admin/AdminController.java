package com.mysite.sbb.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {

	private final AdminService adminService;
	
	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}
	
	@GetMapping("/catecreate")
	public String catec() {
		return "admin/catecreate";
	}
	
	@PostMapping("/catecreate")
	public String catecreate(@ModelAttribute Cate cate) {
		adminService.cateCreate(cate);
		return "admin/main";
	}
}
