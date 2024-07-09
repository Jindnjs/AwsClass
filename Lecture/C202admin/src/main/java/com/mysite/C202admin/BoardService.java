package com.mysite.C202admin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
	public Board getBoardById(Integer id) {
		Optional<Board> ob = br.findById(id);

		Board b = ob.get();

		return b;
		
	}
	public void update(Board b) {
		br.save(b);
	}
}
