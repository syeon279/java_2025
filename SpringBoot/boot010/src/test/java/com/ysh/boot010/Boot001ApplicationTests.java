package com.ysh.boot010;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ysh.boot010.myjpa.MemberRepository;
import com.ysh.boot010.myjpa.Team;
import com.ysh.boot010.myjpa.TeamRepository;

@SpringBootTest
class Boot001ApplicationTests {
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	MemberRepository memberRepository;

	// teamRepository.save(insert, update) / teamRepository.delete-delete
	// teamRepository.findAll() select /teamRepository.findById select

	@Test
	void insert() { 
		Team team = new Team(); team.setName("avengers"); 
		teamRepository.save(team); 
	 }
	
	@Disabled
	void selectAll() {
		List<Team> list = teamRepository.findAll();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
	}
	
	@Disabled
	public void update() {
		// 1. 수정할 팀 찾기 Optional<Team> 있을수도.. 없을수도.. null 값 안전보장
		Optional<Team> findTeam = teamRepository.findById(1L);
		System.out.println(findTeam.isPresent()); // true
		
		// 2. 이름 변경해서 수정
		Team team = findTeam.get();
		team.setName("Avengers");
		teamRepository.save(team);	// save : insert, update
		
	}
	
	@Disabled
	public void delete() {
		Optional<Team> findTeam = teamRepository.findById(3L);
		System.out.println(findTeam.isPresent());
		
		Team team = findTeam.get();
		teamRepository.delete(team);
	}
	
	 
	
}
//crud1. insert into team (name) values (?)
//crud2. select * from team/ select * from where id=?
//crud3. update team set name=? where id=?
//crud4. delete from team where id=?