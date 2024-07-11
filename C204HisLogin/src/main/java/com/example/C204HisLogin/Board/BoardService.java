package com.example.C204HisLogin.Board;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository br;
	
	public void create(Board board) {
		
		board.setDate(LocalDateTime.now());
		
		br.save(board);
	}
}
