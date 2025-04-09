package com.ysh.boot004;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot004.member.Member;
import com.ysh.boot004.member.MemberRepository;

@SpringBootTest
class Boot004ApplicationTests {
	@Autowired MemberRepository memberRepository;
	
	@Disabled
	void insert() {
		Member member = new Member();
		member.setUsername("third");
		member.setPassword("3333");
		member.setEmail("sam@gmail.com");
		memberRepository.save(member);
	}
	
	@Test
	void findAll() {
		List<Member> list = memberRepository.findAll();
		System.out.println(list);
	}
	
	@Disabled
	void findId() {
		System.out.println(memberRepository.findById(1L).get());
	}
	
	@Disabled
	void findByUsername() {
		System.out.println(memberRepository.findByUsername("sen").get());
		
	}
	
	@Disabled
	void update() {
		Member member = memberRepository.findByUsername("first").get();
		member.setEmail("one@gmail.com");
		memberRepository.save(member);
		System.out.println(memberRepository.findByUsername("first").get());
	}
	
	@Disabled
	void updatePassword() {
		Member member = memberRepository.findByUsername("third").get();
		member.setPassword("1111");
		memberRepository.save(member);
		System.out.println(memberRepository.findByUsername("third").get());
		
		//memberRepository.updateByIdAndPassword("aaaa", "1111", 3L);
	}
	
	@Disabled
	void delete() {
		System.out.println(memberRepository.deleteByUsernameAndPassword("third", "1111"));
		
	}
}
