package com.company.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;

@Service // component-scan
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao; // ctrl + shift + o

	@Override
	public int insert(BoardDto dto) {
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public BoardDto updateForm(int bno) {
		return dao.select(bno);
	}

	@Override
	public int delete(BoardDto dto) {
		return dao.delete(dto);
	}

	@Transactional
	@Override
	public BoardDto detail(int bno) {
		BoardDto dto = new BoardDto();
		try {
			dao.updateHit(bno);
			dto = dao.select(bno);
		} catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
		return dto;
	}

	@Override
	public List<BoardDto> selectAll() {
		return dao.selectAll();
	}
}
