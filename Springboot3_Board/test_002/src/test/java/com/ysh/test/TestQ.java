package com.ysh.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.test.board.BoardService;

@SpringBootTest
public class TestQ {
	
	@Autowired
	BoardService boardService;
	
	@Disabled
	public void q2_1() {
		System.out.println(boardService.findAllBoard());
	}
	
	@Disabled
	public void q2_2() {
		boardService.deleteByIdAndPass(4, "1234");
	}
	
	@Test
	public void q2_3() {
		boardService.updateByIdAndPass("안녕", "안녕하세요", 3l, "1234");
	}
	
}
