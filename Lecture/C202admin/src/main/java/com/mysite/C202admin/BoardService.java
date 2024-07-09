package com.mysite.C202admin;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository br;
	
	public void create(Board b) {
		
		b.setCreateDate(LocalDateTime.now());
		br.save(b);
	}
	public List<Board> getAll() {
		return this.br.findAll();
	}
}
