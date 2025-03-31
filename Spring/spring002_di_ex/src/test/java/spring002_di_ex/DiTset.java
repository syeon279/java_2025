package spring002_di_ex;

import java.applet.AppletContext;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.ioctest.Animal;
import com.company.ioctest.AnimalFarm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/test1.xml")
//@ContextConfiguration(locations = "classpath:config/test2.xml")

public class DiTset {
	
	@Autowired ApplicationContext context;
	
	@Test
	//@Ignore
	public void test1() {
		AnimalFarm farm = context.getBean("animalFarm", AnimalFarm.class );
		farm.print();
	}
}
