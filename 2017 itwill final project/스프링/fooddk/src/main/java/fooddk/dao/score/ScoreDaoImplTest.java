package fooddk.dao.score;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Score;

public class ScoreDaoImplTest {
	public static void main(String[] args) {
		System.out.println("-------appication context[bean factory]초기화 전-------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml"); 
		System.out.println("-------appication context[bean factory]초기화 후-------");
		
		ScoreDaoImpl sdi = (ScoreDaoImpl) applicationContext.getBean("ScoreDao");
		System.out.println(sdi);
		
		/*Score in = new Score(1, 1, 3);
		int d = sdi.insertScore(in);
		System.out.println(in);
		System.out.println(d);*/
		
		Score up = new Score(3, 1, 1, 5);
		int dd = sdi.updateScore(up);
		System.out.println(up);
		System.out.println(dd);
		
		Score se = sdi.selectOneScore(1);
		System.out.println(se);
		
		sdi.deleteScore(3);
		
		List<Score> list = sdi.selectAll();
		System.out.println(list);
	}
}
