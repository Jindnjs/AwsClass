package com.mysite.ProjSelPrac.Board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SinglePostTextRepository extends JpaRepository<SinglePostText, Integer> {
	
	List<SinglePostText> findAllByOrderByCreateDateDesc();
}
