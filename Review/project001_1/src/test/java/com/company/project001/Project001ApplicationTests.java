package com.company.project001;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.project001.service.TestService;

@SpringBootTest
class Project001ApplicationTests {

	@Autowired TestService service;
	@Test void contextLoads() { System.out.println("....." + service.test()); }

}
