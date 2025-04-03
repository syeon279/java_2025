package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.UserDao;
import com.company.dto.UserDto;

@Service	// 비지니스 로직 - 처리하는 기능
public class UserServiceImpl implements UserService {
	
	@Autowired UserDao dao;

	@Override
	public int insert(UserDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(UserDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int no) {
		return dao.delete(no);
	}

	@Override
	public UserDto selectOne(int no) {
		return dao.selectOne(no);
	}

	@Override
	public List<UserDto> selectAll() {
		return dao.selectAll();
	}

}
