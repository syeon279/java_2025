package com.ysh.boot001;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot001.myjpa.Member;
import com.ysh.boot001.myjpa.MemberRepository;
import com.ysh.boot001.myjpa.Team;

@SpringBootTest
public class Test002 {
	@Autowired
	MemberRepository memberRepository;

	@Disabled
	public void insert() {
		Team team = new Team();
		team.setId(1L); // #1

		Member member = new Member();
		member.setName("frist");
		member.setAge(11);
		member.setTeam(team); // #2
		memberRepository.save(member); // ## insert, update - save
	}

	@Disabled
	public void insert2() {
		Team team = new Team();
		//team.setId(2L);
		team.setId(1L);

		Member member = new Member();
		member.setId(2L);
		member.setName("second");
		member.setAge(22);
		member.setTeam(team);
		memberRepository.save(member);
	}
	// could not execute statement; SQL [n/a]; constraint [null]; nested exception
	// is org.hibernate.exception.ConstraintViolationException: could not execute
	// statement
	// 팀의 id가 2L이 없어서 오류남.

	// insert into member (age, create_date, username, team_id) value(?,?,?,?)
	/*
	 * mysql> desc member;
	 * +-------------+--------------+------+-----+---------+----------------+ |
	 * Field | Type | Null | Key | Default | Extra |
	 * +-------------+--------------+------+-----+---------+----------------+ | id |
	 * bigint | NO | PRI | NULL | auto_increment | | age | int | YES | | NULL | | |
	 * create_date | datetime(6) | YES | | NULL | | | username | varchar(255) | NO |
	 * | NULL | | | team_id | bigint | YES | MUL | NULL | |
	 * +-------------+--------------+------+-----+---------+----------------+ 5 rows
	 * in set (0.00 sec)
	 */
	
	
	@Test
	public void selectAll() {
		List<Member> list = memberRepository.findAll();
		for(Member m: list ) {
			System.out.println(m);
		}
		System.out.println(list.get(0).getName() +"/"+ list.get(0).getAge());
	}
	
	@Disabled
	public void update() {
		Optional<Member> findMember = memberRepository.findById(1L);
		System.out.println(findMember.isPresent());
		
		Member member = findMember.get();
		member.setName("one");
		//member.setTeam(null); team값 설정 안하면 기존에 있었던 값
		memberRepository.save(member);
	}
	
	@Disabled
	public void delete() {
		Optional<Member> findMember = memberRepository.findById(4l);
		if(findMember.isPresent()) { // 유저가 있다면
			Member member = findMember.get(); //유저 꺼내오기
			memberRepository.delete(member); // 그리고 삭제
		}
		
	}
	
}
