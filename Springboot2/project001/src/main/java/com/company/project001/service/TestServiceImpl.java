package com.company.project001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project001.dao.TestDao;

@Service
public class TestServiceImpl implements TestService {
	@Autowired TestDao dao;
	@Override public String test() { return dao.readTime(); }
	
}
