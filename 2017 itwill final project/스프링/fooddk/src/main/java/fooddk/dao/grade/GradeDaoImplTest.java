package fooddk.dao.grade;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Grade;

public class GradeDaoImplTest {
	public static void main(String[] args) {
		System.out.println("-------appication context[bean factory]초기화 전-------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml"); 
		System.out.println("-------appication context[bean factory]초기화 후-------");
		
		GradeDaoImpl gdi = (GradeDaoImpl) applicationContext.getBean("gradeDao");
		System.out.println(gdi);
		
		/*Grade in = new Grade("bronze");
		int df = gdi.insertGrade(in);*/
		
		/*Grade up = new Grade(1, "silver");
		int upd = gdi.updateGrade(up);
		System.out.println(upd);
		
		int dd = gdi.deleteGrade(1);
		System.out.println(dd);
		*/
		
		Grade one = gdi.selectGradeOne(2);
		System.out.println(one);
		
		List<Grade> all = gdi.selectGradeAll();
		System.out.println(all);
		
	}
}
