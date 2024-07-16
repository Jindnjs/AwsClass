package com.mysite.sbb.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminService {

	private final CateRepository cateRepository;
	
	public void cateCreate(Cate cate) {
		cateRepository.save(cate);
	}
	public List<Cate> getCate(){
		return cateRepository.findAll();
	}
}
