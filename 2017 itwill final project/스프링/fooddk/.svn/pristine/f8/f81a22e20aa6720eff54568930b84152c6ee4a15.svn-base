package fooddk.service.tasty;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Tasty;

public class TastyServiceImplTest {

	public static void main(String[] args) throws Exception {
		System.out.println("-------application context[bean factory]초기화전------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		System.out.println("-------application context[bean factory]초기화후------");
		
		TastyServiceImpl tastyServiceImpl = (TastyServiceImpl)applicationContext.getBean("tastyService");
		List<Tasty> list = tastyServiceImpl.selectAll();
		System.out.println(list.get(0).getT_title());

	}

}
