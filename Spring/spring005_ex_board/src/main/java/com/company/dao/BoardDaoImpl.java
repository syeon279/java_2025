package com.company.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired SqlSession sqlSession;
	private static final String namespace = "com.company.dao.BoardDao";
	
	@Override
	public int insert(BoardDto dto) {
		return sqlSession.insert(namespace+".insert", dto);
	}

	@Override
	public int update(BoardDto dto) {
		return sqlSession.update(namespace+".update", dto);
	}
	@Override
	public int updateHit(int bno) {
		return sqlSession.update(namespace+".updateHit", bno);
	}

	@Override
	public int delete(BoardDto dto) {
		return sqlSession.delete(namespace+".delete", dto);
	}

	@Override
	public BoardDto selectOne(int bno) {
		return sqlSession.selectOne(namespace+".selectOne", bno);
	}

	@Override
	public List<BoardDto> selectAll() {
		return sqlSession.selectList(namespace+".selectAll");
	}

}
