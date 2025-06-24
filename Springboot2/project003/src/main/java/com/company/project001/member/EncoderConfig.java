package com.company.project001.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncoderConfig {
	// 3. PasswordEncoder
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}

// 순환 참조 발생 문제를 예방하기 위해서