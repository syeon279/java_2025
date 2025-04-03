package com.company.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.TestDao;
import com.company.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")

public class Test1_dataSource {
	@Autowired ApplicationContext context;
	@Autowired DataSource datasource;
	@Autowired TestDao dao;
	@Autowired UserDao udao;
	
	@Test
	public void test1() {
		System.out.println(context);
		System.out.println(datasource);
	}
	
	@Test
	public void test2() {
		System.out.println(dao.now());
	}
	
	@Test
	public void test3() {
		System.out.println(udao.selectAll());
	}
}
