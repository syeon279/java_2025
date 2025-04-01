package com.company.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.company.dto.UserDto;

@Repository  //1. 
public class UserDaoImpl implements UserDao {

	@Autowired SqlSession sqlSession; // 2. sql ½ÇÇà 
	private static final String namespace = "com.company.dao.UserDao";
	
	
	@Override
	public int insert(UserDto dto) {
		return sqlSession.insert(namespace+".insert", dto);
	}

	@Override
	public int update(UserDto dto) {
		return sqlSession.update(namespace+".update", dto);
	}

	@Override
	public int delete(int no) {
		return sqlSession.delete(namespace+".delete", no);
	}

	@Override
	public UserDto selectOne(int no) {
		return sqlSession.selectOne(namespace+".selectOne", no);
	}

	@Override
	public List<UserDto> selectAll() {
		return sqlSession.selectList(namespace+".selectAll");
	}

}
