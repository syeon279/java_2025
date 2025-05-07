package com.ysh.board.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	// C
	public Member insertMember(Member member) {
		return memberRepository.save(member);
	}
	
	// R
	public Member findById(long id) {
		return memberRepository.findById(id);
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
