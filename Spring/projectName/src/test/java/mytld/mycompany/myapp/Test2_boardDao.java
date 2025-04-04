package mytld.mycompany.myapp;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.BoardDao;
import com.company.dto.BoardDto;
import com.company.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test2_boardDao {
	@Autowired ApplicationContext  context;
	@Autowired DataSource dataSource;
	@Autowired BoardDao dao;
	@Autowired BoardService service;
	
	@Test 
	public void test0() {
		
		System.out.println(service.detail(1));
	}
	
	@Test public void test() throws UnknownHostException {
//		//5. delete
//		BoardDto dto = new BoardDto(); 
//		dto.setBpass("1111");       dto.setBno(1); 
//		System.out.println(dao.delete(dto));
//		//4. update
////		BoardDto dto = new BoardDto();
//		dto.setBtitle("title-new"); dto.setBcontent("content-new");
//		dto.setBpass("1111");       dto.setBno(1); 
//		System.out.println(dao.update(dto));
//		//3. select
//		//System.out.println(dao.updateHit(1));
//		System.out.println(dao.select(1));
//		//2. insert
////		BoardDto dto = new BoardDto();
//		dto.setBname("first");   dto.setBtitle("title");  dto.setBpass("1111");
//		dto.setBcontent("content");  
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());  
//		System.out.println(dao.insert(dto));
		//1. selectAll
		System.out.println(dao.selectAll());
	}
}



