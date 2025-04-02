package spring009_ex_board;

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
	
	@Test
	public void selectAll() {
		System.out.println(dao.selectAll());
	}
	@Ignore
	public void selectOne() {
		System.out.println(dao.selectOne(2));
	}
	@Ignore
	public void insert() {
		BoardDto dto = new BoardDto();
		dto.setBtitle("hi4");
		dto.setBpass("44");
		dto.setBname("윤소현");
		dto.setBcontent("hello4");
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
		dto.setBpass("44");
		dto.setBno(5);
		System.out.println(dao.update(dto));
		System.out.println(dao.selectOne(5));
	}
	@Test
	public void updateHit() {
		System.out.println(dao.updateHit(1));
		System.out.println(dao.selectOne(1));
	}
	@Ignore
	public void delete() {
		BoardDto dto = new BoardDto();
		dto.setBpass("22");
		dto.setBno(3);
		System.out.println(dao.delete(dto));
		System.out.println(dao.selectAll());
	}

}
