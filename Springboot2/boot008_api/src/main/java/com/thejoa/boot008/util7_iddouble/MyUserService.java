package com.thejoa.boot008.util7_iddouble;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@RequiredArgsConstructor
@ToString
public class MyUserService {
	
	private final MyUserRepository myUserRepository;
	
	
	public MyUser insertUser( MyUser myUser) {
		return myUserRepository.save(myUser);
	}
	
	public MyUser selectUsername(String username) {
		return myUserRepository.findByUsername(username).get();
	}
	
	public MyUser selectUseremail(String email) {
		return myUserRepository.findByEmail(email).get();
	}
}
