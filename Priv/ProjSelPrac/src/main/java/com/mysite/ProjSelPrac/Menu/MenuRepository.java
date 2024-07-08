package com.mysite.ProjSelPrac.Menu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	List<Menu> findAllByOrderByMenurateAscCaterateAsc();
	List<Menu> findByMenu(String menu);
	List<Menu> findByCategoty(String cate);
	List<Menu> findAllByOrderByMenurateDesc();
	List<Menu> findAllByMenuOrderByCaterateDesc(String menu);
	Menu findByMenuAndCategoty(String menu, String categoty);
}
