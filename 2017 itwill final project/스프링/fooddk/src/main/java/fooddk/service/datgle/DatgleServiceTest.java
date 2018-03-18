package fooddk.service.datgle;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Datgle;

public class DatgleServiceTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");

		DatgleService datgleService = (DatgleService)applicationContext.getBean("datgleService");
		
		List<Datgle> list = datgleService.selectAllByFilter("hoogi");
		for (Datgle datgle : list) {
			System.out.println(datgle.getD_content());
		}
	}

}
