package com.ysh.boot001.myjpa;

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

import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter @Setter
public class Team {
	@Id  //1. 기본키
	@GeneratedValue(strategy = GenerationType.IDENTITY)//2. 숫자자동증가
	private Long id;
	
	private String name;
	
	@Column( updatable = false )  // 수정못하게
	private LocalDateTime createDate = LocalDateTime.now();

	//@Transient  //3.컬럼인식못하게
	//private String email;
	
	
	// mappedBy  주인, 부모 ,  부모가 있으면 참조할수 있게... 자식
	@OneToMany(mappedBy = "team"  ,  cascade = CascadeType.REMOVE  ) 
	List<Member> member=new ArrayList<>();
}

/*
관계1
 팀(avengers)은 많은 멤버(iron, hulk,thor,,,,,)를 가진다.  
 멤버는 하나의 팀을 가진다.
 
 team -|---------∈ member
mysql> desc team;
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| id          | bigint       | NO   | PRI | NULL    | auto_increment |
| create_date | datetime(6)  | YES  |     | NULL    |                |
| name        | varchar(255) | YES  |     | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)
mysql>
*/
