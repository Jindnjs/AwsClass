package com.example.C304MultiBoard.Board;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

	private final BoardRepository boardRepository;
	
	public Integer create(Board board) {
		board.setDate(LocalDateTime.now());
		boardRepository.save(board);
		return board.getId();
	}
	
	public List<Board> readlist(){
		return boardRepository.findAll();
	}
	
	public Board readdetail(Integer id) {
		return boardRepository.findById(id).get();
	}
	
	public void update(Board board) {
		boardRepository.save(board);
	}
	public void delete(Integer id) {
		boardRepository.deleteById(id);
	}
}
