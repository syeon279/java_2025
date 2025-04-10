package com.ysh.boot004;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot004.member.Member;
import com.ysh.boot004.member.MemberRepository;
import com.ysh.boot004.member.MemberService;

@SpringBootTest
class Boot004ApplicationTests {
	@Autowired MemberService memberService;
	
	@Disabled
	void insert() {
		Member member = new Member();
		member.setUsername("third");
		member.setPassword("3333");
		member.setEmail("sam@gmail.com");
		memberService.insertMember(member);
	}
	
	@Test
	void findAll() {
		List<Member> list = memberService.selectMemberAll();
		System.out.println(list);
	}
	
	@Disabled
	void findId() {
		System.out.println(memberService.selectMember(1L));
	}
	
	@Disabled
	void findByUsername() {
		
	}
	
	@Disabled
	void update() {
		Member member = memberService.selectMember(1L);
		member.setEmail("one@gmail.com");
		memberService.updateByEmail(member);
		System.out.println(memberService.selectMember(1L));
	}
	
	@Disabled
	void updatePassword() {
		Member member = memberService.selectMember(3L);
		member.setPassword("1111");
		memberService.updateByPass( member, "1234");
		System.out.println(memberService.selectMember(3L));
		
		//memberRepository.updateByIdAndPassword("aaaa", "1111", 3L);
	}
	
	@Disabled
	void delete() {
		memberService.deleteMember(3L);
		
	}
}
