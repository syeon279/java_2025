package com.thejoa.boot008.util7_iddouble;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
	
	Optional<MyUser> findByUsername(String username);
	Optional<MyUser> findByEmail(String email);
	
}
