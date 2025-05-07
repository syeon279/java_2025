package com.ysh.test.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	// C
	public Member insertMember(Member member) {
		return memberRepository.save(member);
	}
	
	// R
	public Member findById(long id) {
		return memberRepository.findById(id);
	}
	
	public Optional<Member> findByUsername(String username) {
		return memberRepository.findByUsername(username);
	}
	
	public int countByUsername(String username) {
		return memberRepository.countByUsername(username);
	}
	
	// U
	// 이름 변경
	public int updateUsername(String username, long id, String password) {
		return memberRepository.updateUsername(username, id, password);
	}
	
	// 패스워드 변경
	public int updatePassword(String newPassword, long id, String password) {
		return memberRepository.updatePassword(newPassword, id, password);
	}
	
	// D
	public int deleteUser(long id, String password) {
		return memberRepository.deleteMember(id, password);
	}
	
}
