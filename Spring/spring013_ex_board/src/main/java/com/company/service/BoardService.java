package com.company.service;

import java.util.List;

import com.company.dto.BoardDto;

public interface BoardService {
	
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public BoardDto detail(int bno); // 상세보기 (조회수 올리기+해당글번호 가져오기)
	public BoardDto updateForm(int bno);
//	public int updateHit(int bno);
	public int delete(BoardDto dto);
//	public BoardDto selectOne(int bno);
	public List<BoardDto> selectAll();
	
}
