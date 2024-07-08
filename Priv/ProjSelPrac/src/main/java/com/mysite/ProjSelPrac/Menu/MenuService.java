package com.mysite.ProjSelPrac.Menu;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuService {
	
	private final MenuRepository menurepo;

    public List<Menu> getAllMenuCategories() {
        return menurepo.findAllByOrderByMenurateAscCaterateAsc();
    }
    
    public int getMenuIdx(String menu) {
    	
    	List<Menu> all = menurepo.findByMenu(menu);
        if(all.isEmpty()) {
        	all = menurepo.findAllByOrderByMenurateDesc();
        	if(all.isEmpty()) {
        		return 1;
        	}
        	return all.get(0).getMenurate()+1;
        }
    	
        Menu m = all.get(0);
    	return m.getMenurate();
    }
    public int getCateIdx(String cate,String menu) {
    	
    	List<Menu> all = menurepo.findByMenu(menu);
        if(all.isEmpty()) {
        	return 1;
        }
        all = menurepo.findAllByMenuOrderByCaterateDesc(menu);
        Menu m = all.get(0);
    	return m.getCaterate()+1;
    }
    public void addMenu(String menu,String cate) {
    	Menu m = new Menu();
    	m.setMenu(menu);
    	m.setCategoty(cate);
    	m.setMenurate(this.getMenuIdx(menu));
    	m.setCaterate(this.getCateIdx(cate,menu));
    	menurepo.save(m);
    	
    }
    public void delMenu(String menu,String cate) {
    	Menu m = this.menurepo.findByMenuAndCategoty(menu, cate);
    	this.menurepo.delete(m);
    }
}
