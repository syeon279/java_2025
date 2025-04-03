package com.company.service;

import java.util.List;

import com.company.dto.BoardDto;

public interface BoardService {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int updateHit(int bno);
	public int delete(BoardDto dto);
	public BoardDto selectOne(int bno);
	public List<BoardDto> selectAll();
	
}
