package com.ysh.boot001.myjpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity @Data
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="USERNAME", nullable=false)	//@Transiend
	private String name;
	
	
	@Column(nullable=true)	//@Transiend
	private int age;
	
	private LocalDateTime createDate = LocalDateTime.now();
	
	@ManyToOne
	private Team team; 
	// 멤버(iron, hulk, captin, blackwidow, thor, spiderman )는 하나의 팀을 가진다. 
	//team_id 컬럼 자동으로 생김
}
/*
 * 관계 1
 * 팀(avengers)은 많은 멤버(iron, hulk, captin, blackwidow, thor, spiderman )를 가진다.
 * 멤버는 하나의 팀을 가진다. 
 * 
 * 
 * team-|--------∈ member
 * 
 * 
 * 
 */
