package com.company.project001.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.project001.dto.UserDto;

@Mapper
public interface AuthDao {
	public List<UserDto> readAuth(UserDto dto);
}
