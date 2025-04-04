package mytld.mycompany.myapp;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test1_now {
	@Autowired ApplicationContext  context;
	@Autowired DataSource dataSource;
	
	@Test public void test1() {  System.out.println(context);}
	@Test public void test2() {  System.out.println(dataSource);} 
}

//   src/main/webapp/WEB-INF/spring/root-context.xml