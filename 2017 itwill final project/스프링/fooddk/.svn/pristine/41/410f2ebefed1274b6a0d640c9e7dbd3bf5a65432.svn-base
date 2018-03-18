package fooddk.service.faq;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import fooddk.domain.Faq;

public class faqservicetest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		
		FaqService faqService = (FaqService) applicationContext.getBean("faqService");
		
		Faq faq = new Faq(1,"service111", 1, "service111");
		int write = faqService.writeFaq(faq);
		System.out.println("성공? "+write);
		
		/*Faq select = faqService.selectFaq(1);
		System.out.println("한개"+select);
		
		Faq faq = new Faq(4,"servicemodify",1,"servicemodify",0);
		int modify = faqService.modifyFaq(faq);
		System.out.println("수정"+modify);*/
		
		List<Faq> all = faqService.selectAllFaq();
		System.out.println(all);
		
		//faqService.removeFaq(4);
	}
}
