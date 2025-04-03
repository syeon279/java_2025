package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao dao;
	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int updateHit(int bno) {
		return dao.updateHit(bno);
	}

	@Override
	public int delete(BoardDto dto) {
		return dao.delete(dto);
	}

	@Override
	public BoardDto selectOne(int bno) {
		return dao.selectOne(bno);
	}

	@Override
	public List<BoardDto> selectAll() {
		return dao.selectAll();
	}

}
