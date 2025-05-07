package com.ysh.test.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ysh.test.member.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String btitle;
	
	@Column(columnDefinition = "text")
	private String bcontent;
	
	private String bpass;
	
	private Long bhit=0l;
	
	private LocalDateTime createDate = LocalDateTime.now() ;
	
	private String bip;
	
	@ManyToOne()
	@JoinColumn(name="member_id")
	private Member member;
	
}
