package com.example.C105JpaExam;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class BoardService {
	
	private final BoardRepository br;
	public void serviceCreate(Board board) {
		
		System.out.println("서비스로 넘어온 title = " + board.getTitle());
		System.out.println("서비스로 넘어온 bContent = " + board.getBContent());
		
		br.save(board);
	}
}
