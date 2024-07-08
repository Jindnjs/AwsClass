package com.mysite.ProjSelPrac.Menu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MenuController {
	
	private final MenuService ms;
	
	@GetMapping("/menu")
	public String showMenu(Model model) {
        List<Menu> menuCategories = ms.getAllMenuCategories();

        // 메뉴 이름을 기준으로 그룹화하여 Map으로 변환
        Map<Integer, List<Menu>> groupedMenuCategories = menuCategories.stream()
                .collect(Collectors.groupingBy(Menu::getMenurate));

        model.addAttribute("groupedMenuCategories", groupedMenuCategories);

        return "menu";
    }
	
	@GetMapping("/menufix")
	public String menufix(Model model) {
        List<Menu> menuCategories = ms.getAllMenuCategories();

        // 메뉴 이름을 기준으로 그룹화하여 Map으로 변환
        Map<Integer, List<Menu>> groupedMenuCategories = menuCategories.stream()
                .collect(Collectors.groupingBy(Menu::getMenurate));

        model.addAttribute("groupedMenuCategories", groupedMenuCategories);
		return "menufix";
	}
	
	@PostMapping("/addMenu")
	public String addMenu(@RequestParam ("menu") String menu,
						  @RequestParam ("categoty") String category) {

		ms.addMenu(menu,category);
		
		
		return "redirect:/menufix";
	}
	@PostMapping("/delMenu")
	public String delMenu(@RequestParam ("menu") String menu,
						  @RequestParam ("categoty") String category) {

		ms.delMenu(menu,category);
		
		
		return "redirect:/menufix";
	}
}
