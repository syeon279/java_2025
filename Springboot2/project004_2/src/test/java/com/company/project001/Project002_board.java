package com.company.project001;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.project001.board.BoardMapper;
import com.company.project001.domain.Board;
import com.company.project001.domain.Member;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Project002_board {

	@Autowired BoardMapper boardMapper; 

	@Test
	public void test() {
		
		// 6. delete
		/*
		Member member = new Member();
		member.setId(81L); // 실제 존재하는 member ID로 설정
		Board board = new Board();
		board.setBpass("pass2");
		board.setId(10L);
		boardMapper.deleteByIdAndBpass(board);
		*/
		
		
		// 5. update
		/*
		Member member = new Member();
		member.setId(81L); // 실제 존재하는 member ID로 설정
		Board board = new Board();
		board.setBtitle("테스트 제목 -new  ");
		board.setBcontent("테스트 내용 -new  ");
		board.setBfile("file"+ ".jpg");
		board.setBip("127.0.0.1");
		board.setBpass("pass2");
		board.setId(10L);
		board.setBhit(0L);
		board.setMember(member);
		boardMapper.updateByIdAndBpass(board);
		
		*/
		
		
		
		// 4.  insert 
		/*
		        Member member = new Member();
		       member.setId(81L); // 실제 존재하는 member ID로 설정
		        
		        for (int i = 101; i <= 200; i++) {
		           Board board = new Board();
		            board.setBtitle("테스트 제목 " + i);
		            board.setBcontent("테스트 내용 " + i);
		            board.setBfile("file" + i + ".jpg");
		            board.setBip("127.0.0.1");
		            board.setBpass("pass" + i);
		            board.setBhit(0L);
		            board.setMember(member);
		            boardMapper.insert(board);
		        }
		 */
		// 3. findById 
		log.info("" + boardMapper.findById(10L));
		// 2. findAllPaged 
		//log.info("" + boardMapper.findAllByOrderedByDesc());
		// 1. findAllPaged 
		//log.info("" + boardMapper.findAllPaged(0, 10));
	}

}
