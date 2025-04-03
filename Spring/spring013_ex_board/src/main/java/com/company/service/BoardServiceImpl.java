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
	public List<BoardDto> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public int insert(BoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public BoardDto detail(int bno) {
		dao.updateHit(bno);
		return dao.selectOne(bno);
	}

	@Override
	public BoardDto updateForm(int bno) {
		return dao.selectOne(bno);
	}

	@Override
	public int delete(BoardDto dto) {
		return dao.delete(dto);
	}


	

}
