package com.thejoa.boot008;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa.boot008.util7_iddouble.MyUser;
import com.thejoa.boot008.util7_iddouble.MyUserService;

@SpringBootTest
class Boot004Security1ApplicationTests {
	
	@Autowired
	MyUserService myUserService;
	
	@Disabled
	void contextLoads() {
		/*
		MyUser user = new MyUser();
		user.setUsername("first");
		user.setEmail("first@gmail.com");
		System.out.println(myUserService.insertUser(user));
		*/
		MyUser user = new MyUser();
		user.setUsername("sen");
		user.setEmail("sen@gmail.com");
		System.out.println(myUserService.insertUser(user));
	}
	
	@Test
	void select () {
		
		String user = myUserService.selectUsername("first").getEmail();
		System.out.println(user);
		
		String username = myUserService.selectUseremail("sen@gmail.com").getUsername();
		System.out.println(username);
		
		System.out.println(myUserService.selectUsername("sen"));
		
	}
	

}
