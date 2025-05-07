package com.ysh.test.board;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	
	// C
	public Board insertBoard(Board board) {
		return boardRepository.save(board);
	}
	
	// R
	public List<Board> findAllBoard() {
		return boardRepository.findAllBoard();
	}
	
	public Optional<Board> findById(Long id) {
		return boardRepository.findById(id);
	}
	
	// U 
	public int updateByIdAndPass(String btitle, String bcontent, Long id, String bpass) {
		return boardRepository.updateByIdAndPass(btitle, bcontent, id, bpass);
	}
	
	public int updateBhit(long id) {
		return boardRepository.updateBhit(id);
	}
	
	// D
	public int deleteByIdAndPass(long id, String bpass) {
		return boardRepository.deleteByIdAndPass(id, bpass);
	}
}
