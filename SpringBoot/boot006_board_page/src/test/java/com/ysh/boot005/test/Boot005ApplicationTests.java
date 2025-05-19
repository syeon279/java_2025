package com.ysh.boot005.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot005.member.Member;
import com.ysh.boot005.member.MemberRepository;


@SpringBootTest
class Boot005ApplicationTests {
	
	@Autowired MemberRepository memberRepository;
	
	@Disabled
	void contextLoads() {

	}

}
