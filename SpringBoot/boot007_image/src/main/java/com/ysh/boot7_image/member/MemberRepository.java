package com.ysh.boot7_image.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long> {

	// select: select * from member where username=? and password=?
	Optional<Member> findByUsername(String username);

	// insert: insert into member(username, password, email) value (?,?,?)
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query("insert into Member (username, password, email) value (:username, :password, :email)"
	 * ) int insertMember(@Param("username") String username, @Param("password")
	 * String password,
	 * 
	 * @Param("email") String email);
	 */

	// update: update member set username=?, password=?, email=? where username=?
	// and password=?
	@Modifying
	@Transactional
	@Query("update Member m set m.password= :password where m.id= :id and m.password= :oldpassword")
	int updateByIdAndPassword(String password, String oldpassword, Long id);

	// delete: delte from member where username=? and password=?
	@Modifying
	@Transactional
	@Query("delete from Member m where m.username= :username and m.password= :password")
	int deleteByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	@Modifying
	@Transactional
	@Query("delete from Member m where m.id= :id and m.password= :password")
	int deleteByIdAndPassword(Long id, String password);

}
/*
 * CRUD insert into member (username, password, email) values (?,?,?) select *
 * from member select * from member id=? update member set email=?, username=?,
 * password=? where id=? delete from member where id=?
 */
