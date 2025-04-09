package com.ysh.boot003.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ysh.boot003.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @ToString( exclude = "member")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200)
	private String btitle;
	
	@Column(columnDefinition = "text")
	private String bcontent;
	
	@Column(nullable = true)
	private String bfile;
	
	private long bhit =0L;
	
	private String bname;
	
	private String bpass;
	
	private String bip;
	
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	@ManyToOne	@JoinColumn(name="MEMBER_ID") //@Column(nullable = false)
	private Member member;
	
}
