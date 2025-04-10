package com.ysh.boot005.member;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepositroy;
	private final PasswordEncoder passwordEncoder;
	
	//insert
	public Member insertMember(Member member) {
		//		셋팅				암호화					비밀번호
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberRepositroy.save(member);
	}
	
	public List<Member> selectMemberAll(){
		return memberRepositroy.findAll();
	}
	
	public Member selectMember(Long id) {
		return memberRepositroy.findById(id).get();
	}
	
	public int updateByPass( Member member, String old) {
		return memberRepositroy.updateByIdAndPassword(member.getPassword(),old, member.getId());
	}
	
	public Member updateByEmail(Member member) {
		Member find = memberRepositroy.findById(member.getId()).get();
		find.setEmail(null);
		return memberRepositroy.save(find);
	}
	
	public void deleteMember (Long id) {
		Member find = memberRepositroy.findById(id).get();
		memberRepositroy.delete(find);;
	}
	
}
