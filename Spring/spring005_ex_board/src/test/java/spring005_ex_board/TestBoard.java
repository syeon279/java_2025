package spring005_ex_board;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/root-context.xml")

public class TestBoard {
	@Autowired BoardDao dao;
	
	@Ignore
	public void selectAll() {
		System.out.println(dao.selectAll());
	}
	@Ignore
	public void selectOne() {
		System.out.println(dao.selectOne(2));
	}
	@Test
	public void insert() {
		BoardDto dto = new BoardDto();
		dto.setBtitle("hi3");
		dto.setBpass("33");
		dto.setBname("윤소현");
		dto.setBcontent("hello");
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println(dao.insert(dto));
	}
	@Ignore
	public void update() {
		BoardDto dto = new BoardDto();
		dto.setBtitle("수정된 타이틀");
		dto.setBcontent("수정된 내용");
		dto.setBpass("22");
		dto.setBno(3);
		System.out.println(dao.update(dto));
		System.out.println(dao.selectOne(3));
	}
	@Ignore
	public void updateHit() {
		System.out.println(dao.updateHit(3));
		System.out.println(dao.selectOne(3));
	}
	@Ignore
	public void delete() {
		BoardDto dto = new BoardDto();
		dto.setBpass("22");
		dto.setBno(3);
		System.out.println(dao.delete(dto));
		System.out.println(dao.selectAll());
	}
	@Test
	public void selectAll1() {
		System.out.println(dao.selectAll());
	}
}
