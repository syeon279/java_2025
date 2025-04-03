package com.company.dao;

import java.util.List;

import com.company.dto.BoardDto;

@MyDao
public interface BoardDao {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int updateHit(int bno);
	public int delete(BoardDto dto);
	public BoardDto selectOne(int bno);
	public List<BoardDto> selectAll();
	
}
