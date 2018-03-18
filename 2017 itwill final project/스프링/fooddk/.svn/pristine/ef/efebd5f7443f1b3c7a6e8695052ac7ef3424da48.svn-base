package fooddk.dao.faq;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Faq;

public class faqdaotest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		FaqDao faqDao = (FaqDao) applicationContext.getBean("faqDao");
		
		
		/*
		 * write
		 */
		//Faq write = new Faq(1, "FAQBoard", 1, "FAQBoard", 0); 
		//int suc = faqDao.writeFaq(write);
		//System.out.println("성공하면1,아니면0= "+suc);
		
		/*
		 * select
		 */
		Faq select = faqDao.selectFaq(1);
		System.out.println(select);
		
		/*
		 * modify
		 */
		/*Faq faq = new Faq(1, "modifyFAQBoard", 1, "modifyFAQBoard", 0);
		int modify = faqDao.modifyFaq(faq);
		System.out.println("modify=  "+modify);*/
		
		/*
		 * remove
		 */
		/*int remove = faqDao.removeFaq(2);
		System.out.println("삭제됨?= "+remove);*/
		
		/*
		 * all출력
		 */
		List<Faq> all = faqDao.selectAllFaq();
		System.out.println(all);
		
		
		
	}
}
