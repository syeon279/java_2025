package com.ysh.boot001.myjpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity   @Getter  @Setter
public class ChatRoom {
	@Id// 기본값
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto_increment
	private Long id;
	
	private String chatRoomName;
	
	@ManyToMany
	@JoinTable( name="member_chat_room" ,
		joinColumns = @JoinColumn(name="chat_room_id") ,
		inverseJoinColumns = @JoinColumn(name="member_id")
	)
	private Set<Member>  members = new HashSet<>();
	
}

// 유저는 여러개의 채팅방을 가질 수 있다.
// 유저 ------∈  유저채팅  ∋------  채팅방



