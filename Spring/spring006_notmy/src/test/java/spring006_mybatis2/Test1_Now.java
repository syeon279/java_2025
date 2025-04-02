package spring006_mybatis2;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dao.TestDao;

@RunWith(SpringJUnit4ClassRunner.class)  //1. spring �����׽�Ʈ
@ContextConfiguration(locations = "classpath:config/root-context.xml") //2. ����
public class Test1_Now {
	
	@Autowired ApplicationContext  context;  //3. Bean(�������� �����ϴ°�ü) ����~�Ҹ����
	@Autowired DataSource dataSource;
	@Autowired TestDao dao;
	
	@Test public void test0() {  System.out.println(context);   }
	@Test public void test1() {  System.out.println(dataSource);   }
	@Test public void test2() {  System.out.println(dao.now());   }
	//NoSuchBeanDefinitionException: No qualifying bean   @Repository
}
