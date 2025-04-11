package com.ysh.boot005.board;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysh.boot005.member.Member;
import com.ysh.boot005.member.MemberRepository;


@Service
public class BoardService  {

	@Autowired BoardRepository boardRepository;	
	@Autowired MemberRepository memberRepository;	
	
	
	public List<Board> findAll() {
		//List<Board> boardAll = boardRepository.findAll();
		//return boardAll;
		return boardRepository.findAllByOrderByDesc();
	}
	
	@Transactional // commit or rollback
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

	public void insert(Board board) {
		board.setMember(memberRepository.findByUsername(board.getMember().getUsername()).get());
		try {
			board.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		boardRepository.save(board);
		
	}

	public Board update_view(Long id) {
		return boardRepository.findById(id).get() ;
	}

	public int update(Board board) {
		return boardRepository.updateByIdAndBpass(board.getId(), board.getBpass(), board.getBtitle(), board.getBcontent());
	}

	public int delete(Board board) {
		return boardRepository.deleteByIdAndBpass(board.getId(), board.getBpass());
	}

}
