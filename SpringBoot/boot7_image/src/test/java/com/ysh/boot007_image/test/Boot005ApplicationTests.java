package com.ysh.boot007_image.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot7_image.member.Member;
import com.ysh.boot7_image.member.MemberRepository;


@SpringBootTest
class Boot005ApplicationTests {
	
	@Autowired MemberRepository memberRepository;
	
	@Disabled
	void contextLoads() {

	}

}
