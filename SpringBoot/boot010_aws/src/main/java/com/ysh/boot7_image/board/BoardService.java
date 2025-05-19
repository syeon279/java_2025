package com.ysh.boot7_image.board;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ysh.boot7_image.member.MemberRepository;
import com.ysh.boot7_image.util.UtilUpload;


@Service
public class BoardService  {

	@Autowired BoardRepository boardRepository;	
	@Autowired MemberRepository memberRepository;	
	@Autowired UtilUpload upload;
	
	/* PAGING */
	/* PAGING */
	// 1: 최신글 10개 order by bno decs limit 0,10 -> 0번째 부터 10개
	// 2: 그다음 최신글 10개 order by bno decs limit 10, 10 -> 10번째부터 10개 
	public Page<Board> getPaging(int page){ // 어디서부터
		
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));   // 아이디를 기준으로 내림차순,
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return boardRepository.findAll(pageable);
	}
	
	/* BOARD */
	/* BOARD */
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
	/* File 추가기능 */
	/* File 추가기능 */
	public void insert( MultipartFile file ,Board board) {
		//file Upload
		try {
			board.setBfile(upload.fileUpload(file));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
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
	/* File 추가기능 */
	/* File 추가기능 */
	public int update( MultipartFile file, Board board) {
		//file upload
		String save = board.getBfile(); // 이전 파일 경로
		if( file.getOriginalFilename().length() != 0 ){ // 새로운 파일이 올라왔으면
			try {
				save = upload.fileUpload(file); // 업로드 
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		board.setBfile(save); // 파일 이름 저장
		
		return boardRepository.updateByIdAndBpass(board.getId(), 
				board.getBpass(), board.getBtitle(), board.getBcontent(), board.getBfile());
	}

	public int delete(Board board) {
		return boardRepository.deleteByIdAndBpass(board.getId(), board.getBpass());
	}

}
