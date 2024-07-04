package com.example.C104JavaExam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
	
	//어노테이션에서 선언
	@Autowired
	private MainRepository mr;
	
	public void serviceCreate(String id, String pass) {
		
		System.out.println("서비스로 넘어온 id = " + id);
		System.out.println("서비스로 넘어온 pw = " + pass);
		
		//MainRepository mr = new MainRepository();
		mr.repositoryCreate(id,pass);
	}
}
