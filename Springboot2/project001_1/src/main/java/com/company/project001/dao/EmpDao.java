package com.company.project001.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.company.project001.dto.EmpDto;

@Mapper
public interface EmpDao {
	public List<EmpDto> test1(Map<String, String> para); 
	public List<EmpDto> test2(EmpDto dto); 
	public List<EmpDto> test3(EmpDto dto); 
	public List<EmpDto> test4(EmpDto dto); 
	public List<EmpDto> test5(EmpDto dto); 
	public List<EmpDto> test6(List<Integer> list); 
}
