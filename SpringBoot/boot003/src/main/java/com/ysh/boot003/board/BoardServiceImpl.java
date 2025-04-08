package com.ysh.boot003.board;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardRepository boardRepository;	
	
	@Override
	public List<Board> findAll() {
		List<Board> boardAll = boardRepository.findAll();
		return boardAll;
	}
	
	@Transactional // commit or rollback
	@Override
	public Board find(Long id) {
		Board board = boardRepository.findById(id).get();
		board.setBhit(board.getBhit()+1);
		boardRepository.save(board);
		/*
		 * Optional<Board> findBoard = boardRepository.findById(id); Board board =
		 * findBoard.get(); if(findBoard.isPresent()) {
		 * board.setBhit(board.getBhit()+1); boardRepository.save(board); }
		 */
		return board;
	}

	@Override
	public void insert(Board board, Long id) {
		try {
			board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		boardRepository.save(board);
	}

	@Override
	public Board update_view(Long id) {
		return boardRepository.findById(id).get() ;
	}

	@Override
	public void update(Board board) {
		boardRepository.save(board);
	}

	@Override
	public void delete(Board board) {
		boardRepository.delete(board);
	}

}
