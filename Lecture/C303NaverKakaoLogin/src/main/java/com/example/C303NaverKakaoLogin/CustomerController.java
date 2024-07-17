package com.example.C303NaverKakaoLogin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class CustomerController {
	
		@Autowired
		private CustomerService customerService;
		
		@GetMapping("/admin")
		public String admin(Model model) {
			model.addAttribute("customers", customerService.readlist());
			return "main";
		}
		
		@GetMapping("/customer/detail/{cid}")
		public String detail(Model model,@PathVariable("cid") Integer cid) {
			
			model.addAttribute("customer", customerService.readdetail(cid));
			return "detail";
		}
		@PostMapping("/update")
		public String update(@ModelAttribute Customer customer) {
			
			customerService.update(customer);
			return "redirect:/admin";
		}
		
		
		@GetMapping("/")
		public String signup() {
			return "signup";
		}
		
		@PostMapping("/signup")
		public String signup(Customer customer) {
			
			customerService.create(customer);
			
			return "signup";
		}
		
		@GetMapping("/signin")
		public String signin() {
			return "signin";
		}
		
	}