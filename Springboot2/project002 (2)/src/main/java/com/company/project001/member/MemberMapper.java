package com.company.project001.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.company.project001.domain.Member;

@Mapper
public interface MemberMapper {
	public Member findByUsername(String username);
	public Member findById(Long id);
	public List<Member> findAll();
	public int insert(Member member);
	public int update(Member member);
	public int updateByIdAndPassword(
			@Param("id") Long id, 
			@Param("newPassword") String newPassword, 
			@Param("oldPassword")String oldPassword);
	public int delete(Long id);
	
}
