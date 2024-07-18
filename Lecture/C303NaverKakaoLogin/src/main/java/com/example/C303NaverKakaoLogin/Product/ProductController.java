package com.example.C303NaverKakaoLogin.Product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.C303NaverKakaoLogin.CustomerService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/product")
@RequiredArgsConstructor
@Controller
public class ProductController {
	
	private final ProductService productService;
	private final CustomerService customerService;
	@GetMapping("/create")
	public String create() {
		
		return "product/create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Product product) {
		
		productService.create(product);
		return "redirect:/product/readlist";
	}

	@GetMapping("/readlist")
	public String index(Model model) {
		model.addAttribute("products", productService.readList());
		return "product/readlist";
	}
	@GetMapping("/readdetail/{id}")
	public String index(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("product", productService.readdetail(id));
		model.addAttribute("customer", customerService.authen());
		return "product/readdetail";
	}
	@GetMapping("/result")
	public String result(@RequestParam("imp_uid") String uid) {
		System.out.println("카드사로부터 넘어온 결과값 imp_uid = "+uid);
		customerService.updaterole();
		return "redirect:/";
	}
}
