package fooddk.dao.tasty;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Tasty;

public class TastyDaoImplTest {

	public static void main(String[] args) {
		System.out.println("-------application context[bean factory]초기화전------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		System.out.println("-------application context[bean factory]초기화후------");
		
		TastyDao tastyDaoImpl = (TastyDao)applicationContext.getBean("tastyDao");
		
		Tasty tasty = new Tasty("묭묭묭", "묭이가 추천하는 맛집1", "/픽처", "010-8451-5422","11-20","통영시",1);
		tastyDaoImpl.insert(tasty);
		
		System.out.println("-----------selectByNo-----------");
		//tasty = tastyDaoImpl.selectByNo(26);
		System.out.println(tasty);
		
		tasty.setT_title("묭의맛집 (수정)");
		//tastyDaoImpl.updateByNo(tasty);
		
		
		System.out.println("-----------updateCount-----------");
		//tastyDaoImpl.updateCount(27);
		
		System.out.println("-----------deleteByNo-----------");
		//tastyDaoImpl.deleteByNo(28);
		
		System.out.println("-----------deleteByNo-----------");
		List<Tasty> tastyList = tastyDaoImpl.selectList(1, 5);
		for(Tasty tasty1:tastyList){
			System.out.println(tasty1.toString());
		}
		
		System.out.println("-----------selectCount-----------");
		//tastyList = tastyDaoImpl.selectCount();
		for(Tasty tasty1:tastyList){
			System.out.println(tasty1.toString());
		}
		
		System.out.println("-----------selectDate-----------");
		// = tastyDaoImpl.selectDate();
		for(Tasty tasty1:tastyList){
			System.out.println(tasty1.toString());
		}
		
		System.out.println("-----------countAll-----------");
		System.out.println(tastyDaoImpl.countAll());
		
		System.out.println("-----------selectImgByNo-----------");
		System.out.println(tastyDaoImpl.selectAddressByNo(1));
		
		System.out.println("-----------selectByTitle-----------");
		tastyList =tastyDaoImpl.selectByTitle("묭");
		for(Tasty tasty1:tastyList){
			System.out.println(tasty1.toString());
		}
		
		System.out.println("1. ----------------selectAll");
		tastyList = tastyDaoImpl.selectAll();
		for(Tasty tasty1:tastyList){
			System.out.println(tasty1.toString());
		}
		
	}	

}
