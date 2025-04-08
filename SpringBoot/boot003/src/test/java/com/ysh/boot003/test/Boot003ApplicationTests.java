package com.ysh.boot003.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot003.Member;
import com.ysh.boot003.MemberRepository;

@SpringBootTest
class Boot003ApplicationTests {
	
	@Autowired MemberRepository memberRepository;
	
	@Disabled
	void contextLoads() {
		Member member = new Member();
		member.setName("sen");
		member.setAge(22);
		memberRepository.save(member);
	}

}
