package com.ysh.boot003;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ysh.boot003.board.Board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String name;
	
	private int age;
	
	@Column(updatable = false)
	private LocalDateTime createDate = LocalDateTime.now();
	
	// 유저(Member)는 많은 글(Board)을 쓸 수 있다.
	@OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
	List<Board> board = new ArrayList<>();
	
}
