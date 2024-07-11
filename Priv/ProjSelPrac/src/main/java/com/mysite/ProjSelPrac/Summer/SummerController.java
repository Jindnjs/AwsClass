package com.mysite.ProjSelPrac.Summer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SummerController {
	
	@GetMapping("/opensummer")
	public String summer() {
		return "summer";
	}
}
