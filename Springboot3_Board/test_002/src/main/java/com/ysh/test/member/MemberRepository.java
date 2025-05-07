package com.ysh.test.member;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	// C
	
	// R
	// 아이디로 유저 찾기
	@Query("select m from Member m where m.id = :id")
	Member findById(long id);
	
	// 이름으로 찾기
	@Query("select m from Member m where m.username = :username")
	Optional<Member> findByUsername(String username);
	
	// 중복 검사
	@Query("select count(*) from Member m where m.username = :username")
	int countByUsername(String username);
	
	// U
	// 이름 변경
	@Transactional
	@Modifying
	@Query("update Member m set m.username = :username where m.id = :id and m.password = :password ")
	int updateUsername(String username, long id, String password);
	
	// 패스워드 변경
	@Transactional
	@Modifying
	@Query("update Member m set m.password = :newPassword where m.id = :id and m.password = :oldpass")
	int updatePassword( @Param("newPassword") String newPassword, long id, @Param("oldpass") String password);
	
	// D
	// 유저 탈퇴
	@Transactional
	@Modifying
	@Query("delete from Member m where m.id = :id and m.password = :password")
	int deleteMember(long id, String password);
	
}
