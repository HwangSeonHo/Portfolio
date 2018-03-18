package fooddk.service.developer;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Developer;
import fooddk.domain.Faq;

public class DeveloperServiceImplTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		
		DeveloperService developerService = (DeveloperService) applicationContext.getBean("developerService");
		
		
		
		/*Faq select = faqService.selectFaq(1);
		System.out.println("한개"+select);
		
		Faq faq = new Faq(4,"servicemodify",1,"servicemodify",0);
		int modify = faqService.modifyFaq(faq);
		System.out.println("수정"+modify);*/
		
		List<Developer> all = developerService.All();
		System.out.println(all.toString());
		
		//faqService.removeFaq(4);
	}
}
