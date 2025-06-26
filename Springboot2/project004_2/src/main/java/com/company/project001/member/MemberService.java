package com.company.project001.member;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.project001.domain.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;
	
	public Member insert(Member member) {
		try {
			member.setUsername(member.getUsername());
			member.setImage("/images/thejoa.png");
			member.setRole(MemberRole.MEMBER);
			member.setPassword(passwordEncoder.encode(member.getPassword()));
			member.setEmail(member.getEmail());
			member.setNickname(member.getNickname());
			//member.setProvider("thejoa");  - 소셜로그인이 아니면 null
			memberMapper.insert(member);
		}catch(DataIntegrityViolationException e) {
			throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
		}
		return member;
	};
	
	public List<Member> findAll() {
		List<Member> memberList = memberMapper.findAll();
		return memberList;
	}
	public Member findByUsername(String username) {
		return memberMapper.findByUsername(username);
	};
	
	public Member findById(Long id) {
		return memberMapper.findById(id);
	};

	public int updateByIdAndPassword( Member member, String oldPassword) {
		Member find = memberMapper.findById(member.getId());
		if(find != null && passwordEncoder.matches(oldPassword, find.getPassword())) {
			String newPassword = passwordEncoder.encode(member.getPassword());
			return memberMapper.updateByIdAndPassword(find.getId(), find.getPassword(), newPassword);
		}
		return 0;
	};
	
	public int update(Member member) {
		return 0 ;
	};
	
	public boolean delete(Long id, String password ) {
		Member find = memberMapper.findById(id);
		if(find != null && passwordEncoder.matches(password, find.getPassword())) {
			return memberMapper.delete(id) > 0;
		}
		return false;
	};
	
	/*
	*/
	
	
	
}
