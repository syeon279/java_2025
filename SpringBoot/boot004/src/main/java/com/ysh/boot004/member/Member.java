package com.ysh.boot004.member;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(unique = true)	//유일한 값 설정
	private String username;
	
	private String password;
	
	@Column(unique = true)	//유일한 값 설정
	private String email;
	
	@Column(updatable = false)
	private LocalDateTime udate = LocalDateTime.now();
	
}
