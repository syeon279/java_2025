package com.company.service;

import java.util.List;
import com.company.dto.UserDto;

public interface UserService {
	
	public int insert(UserDto dto);
	public int update(UserDto dto);
	public int delete(int no);
	public UserDto selectOne(int no);
	public List<UserDto> selectAll();
	
}