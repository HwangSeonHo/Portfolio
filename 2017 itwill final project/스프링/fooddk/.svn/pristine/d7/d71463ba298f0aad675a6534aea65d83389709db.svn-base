package fooddk;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SessionTest {

	public static void main(String[] args) {
	
		System.out.println("-------appication context[bean factory]초기화 전-------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml"); 
		System.out.println("-------appication context[bean factory]초기화 후-------");
		
		SqlSession session = (SqlSession)applicationContext.getBean("session");
		System.out.println(session);
	}

}
