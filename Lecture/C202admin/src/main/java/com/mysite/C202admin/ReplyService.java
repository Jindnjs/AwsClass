package com.mysite.C202admin;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyService {
	
	private final ReplyRepository rr;
	private final BoardService bs;
	
	public void addRepl(Reply r, Integer id) {
		
		r.setId(null);
		r.setDate(LocalDateTime.now());
		r.setBoard(bs.getBoardById(id));
		this.rr.save(r);
	}
	public void delete(Integer id) {
		rr.deleteById(id);
	}
}
