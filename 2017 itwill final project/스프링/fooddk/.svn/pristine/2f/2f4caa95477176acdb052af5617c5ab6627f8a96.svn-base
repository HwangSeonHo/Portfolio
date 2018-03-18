package fooddk.dao.developer;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Developer;

public class DeveloperServiceImplTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		
		DeveloperDao developerService = (DeveloperDao) applicationContext.getBean("developerDao");
		
		
		
		/*Faq select = faqService.selectFaq(1);
		System.out.println("한개"+select);
		
		Faq faq = new Faq(4,"servicemodify",1,"servicemodify",0);
		int modify = faqService.modifyFaq(faq);
		System.out.println("수정"+modify);*/
		
		
		List<Developer> all = developerService.All();
		System.out.println(all);
		
		//faqService.removeFaq(4);
	}
}
