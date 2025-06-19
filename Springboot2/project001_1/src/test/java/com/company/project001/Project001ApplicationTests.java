package com.company.project001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.project001.dao.AuthDao;
import com.company.project001.dao.EmpDao;
import com.company.project001.dto.EmpDto;
import com.company.project001.dto.UserDto;
import com.company.project001.service.TestService;

@SpringBootTest
class Project001ApplicationTests {

	@Autowired TestService service;
	@Disabled @Test void contextLoads() { System.out.println("....." + service.test()); }

	
	
	///////////////
	@Autowired EmpDao dao;
	@Autowired AuthDao authDao;
	
	
	
	//////////
	@Test
	public void authTeset() {
		UserDto dto = new UserDto();
		dto.setUserid("first");
		System.out.println(authDao.readAuth(dto));
	}
	
	@Disabled @Test public void test1() {
		Map<String, String> para = new HashMap<>();
		para.put("searchType", "ename");
		para.put("keyword", "SMITH");
		para.put("searchType", "job");
		para.put("keyword", "clerk");
		System.out.println(dao.test1(para));
		
	}
	@Disabled @Test 
	public void test2() {
		EmpDto dto = new EmpDto();
		dto.setEname("SMITH");
		dto.setJob("clerk");
		System.out.println(dao.test2(dto));
		
	}
	
	@Disabled @Test
	public void test3() {
		EmpDto dto = new EmpDto();
		dto.setEmpno(7369);
		dto.setMgr(7902);
		//dto.setEname("SMITH");
		System.out.println(dao.test3(dto));
	}
	
	@Disabled @Test
	public void test4() {
		EmpDto dto = new EmpDto();
		//dto.setEmpno(7369);
		//dto.setMgr(7902);
		dto.setEname("SMITH");
		System.out.println(dao.test4(dto));
	}
	
	@Disabled @Test
	public void test5() {
		EmpDto dto = new EmpDto();
		dto.setEmpno(7369);
		//dto.setMgr(7902);
		dto.setEname("SMITH");
		dto.setJob("CLERK");
		System.out.println(dao.test5(dto));
		System.out.println(dao.test4(dto));
	}
	
	@Disabled @Test
	public void test6() {
		EmpDto dto = new EmpDto();
		List<Integer> list = new ArrayList<>();
		list.add(7369);
		list.add(7902);
		list.add(7566);
		list.add(7839);
		//dto.setMgr(7902);
		//dto.setEname("SMITH");
		//dto.setJob("CLERK");
		System.out.println(dao.test6(list));
		//System.out.println(dao.test4(dto));
	}
	

	
	
}
