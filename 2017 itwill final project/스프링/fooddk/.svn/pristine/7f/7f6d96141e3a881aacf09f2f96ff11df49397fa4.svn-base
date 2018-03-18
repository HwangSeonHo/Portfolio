package fooddk.dao.datgle;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Datgle;

public class DatgleDaoTestMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");

		DatgleDao datgleDao = (DatgleDao)applicationContext.getBean("datgleDao");
		
		//selectList
		List<Datgle> list = datgleDao.selectList(1,10,"tasty",1);
		for (Datgle datgle : list)
			System.out.println(datgle.getD_content());
		
		/*//selectByFilterTitle
		List<Datgle> list = datgleDao.selectByFilterTitle(new Datgle("글","tasty"));
		for (Datgle datgle : list)
			System.out.println(datgle.getD_content());*/
		
		/*//selectByNo
		System.out.println(datgleDao.selectByNo(7).getD_content());*/
		
		/*//selectAllByFilter
		List<Datgle> list = datgleDao.selectAllByFilter("tasty");
		for (Datgle datgle : list)
			System.out.println(datgle.getD_content());*/
		
		/*//selectCountByFilter
		System.out.println(datgleDao.selectCountByFilter("tasty"));*/
		
		//selectCount
		System.out.println(datgleDao.selectCount(new Datgle("hoogi",40)));
		
		/*//insert
		System.out.println(datgleDao.insert
				(new Datgle(1, "main-제목", "main-내용", 1, 1, "hoogi")));*/
		
		/*//updateByNo 
		System.out.println(datgleDao.updateByNo
				(new Datgle(9, "main-수정제목","main-수정내용")));*/
		
		/*//deleteByNo 
		System.out.println(datgleDao.deleteByNo(1));*/
	}

}
