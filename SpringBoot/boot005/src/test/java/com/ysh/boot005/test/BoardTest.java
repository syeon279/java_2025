package com.ysh.boot005.test;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot005.board.Board;
import com.ysh.boot005.board.BoardRepository;
import com.ysh.boot005.member.Member;
import com.ysh.boot005.member.MemberRepository;

@SpringBootTest
public class BoardTest {
	
	@Autowired BoardRepository boardRepository;
	@Autowired MemberRepository memberRepository;
	
	@Disabled
	public void test() {
		Optional<Member> findmember = memberRepository.findById(2L);
		Member member = findmember.get();
		
		Board board = new Board();
		board.setBtitle("hello");
		board.setBcontent("hihi");
		try {
			board.setBip(Inet4Address.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		board.setBpass("22");
		
		board.setMember(member);
		boardRepository.save(board);
	}
	
	
	@Disabled
	public void update() {
		Optional<Member> findmember = memberRepository.findById(2L);
		Member member = findmember.get();
		
		Optional<Board> findboard = boardRepository.findById(3L);
		Board board = findboard.get();
		board.setBtitle("hello-new");
		board.setBcontent("수정한 게시물입니다.");
		
		board.setMember(member);
		boardRepository.save(board);
	}
	
	@Disabled
	public void delete() {
		/*
		 * Optional<Member> findMember = memberRepository.findById(2L); Member member =
		 * findMember.get();
		 */
		
		Optional<Board> findBoard = boardRepository.findById(4L);
		Board board = findBoard.get();
		
		boardRepository.delete(board);
	}
	
	@Test
	public void selectAll() {
		List<Board> findBoard = boardRepository.findAll();
		System.out.println(findBoard);
		
		List<Member> findMember = memberRepository.findAll();
		System.out.println(findMember);
	}
	
	@Disabled
	public void selectOne() {
		Optional<Member> findMember = memberRepository.findById(2L);
		Member member = findMember.get();
		System.out.println(member);
		
		List<Board> findBoard = boardRepository.findBy(null , null);
		System.out.println(findBoard);
		
	}
	
	@Test
	public void select() {
		Optional<Board> findBoard = boardRepository.findById(2L);
		
		if(findBoard.isPresent()) {
			Board board = findBoard.get();
			board.setBhit(board.getBhit()+1);
			System.out.println(board);
			boardRepository.save(board);
		}
	}
	
}
// find-select / save - update, insert / delete-delete
