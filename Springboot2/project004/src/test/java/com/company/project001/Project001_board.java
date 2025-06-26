package com.company.project001;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.project001.board.BoardMapper;
import com.company.project001.domain.Board;
import com.company.project001.domain.Member;
import com.company.project001.member.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Project001_board {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	BoardMapper boardMapper;

	@Test
	public void test() {

		Board board = new Board();
		
		
		// 2. 
		log.info("" + boardMapper.findAllByOrderedByDesc());
		
		// 1. findAllPaged
		log.info("" + boardMapper.findAllPaged(10, 0));
		
	}

}
