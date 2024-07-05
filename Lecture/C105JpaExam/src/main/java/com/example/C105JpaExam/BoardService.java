package com.example.C105JpaExam;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	
	public void serviceCreate(String title, String bContent) {
		
		System.out.println("서비스로 넘어온 title = " + title);
		System.out.println("서비스로 넘어온 bContent = " + bContent);
		
		
	}
}
