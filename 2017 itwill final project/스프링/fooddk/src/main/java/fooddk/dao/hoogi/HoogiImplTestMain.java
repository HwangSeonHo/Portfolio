package fooddk.dao.hoogi;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.core.net.SyslogOutputStream;
import fooddk.domain.Hoogi;

public class HoogiImplTestMain {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		// HoogiDaoImpl Himpl=new HoogiDaoImpl();
		System.out.println("1");
		Hoogi hoogi = new Hoogi();
		HoogiDao hoogiDao = (HoogiDao) applicationContext.getBean("hoogiDao");
		System.out.println(hoogiDao.selectByt_no(1));

		/*// selct 만 리절트 타입
		// 나머지는 파라미터타입
		Hoogi insertHoogi = new Hoogi("현재7시34분", "content", new Date(), "img", 1234);
		int no = hoogiDao.insertHoogi(insertHoogi);
		System.out.println(no);

		// 학원가서 테스트하기
		// 후기글삭제하기

		int deleteByno = hoogiDao.deleteByNo(25);
		System.out.println("deleteByno@@@@@ " + deleteByno);

		// 후기글 업데이트
		Hoogi updateHoogi = new Hoogi("현재7시", "1", "50번이미지", 9999, 50);
		int updateno = hoogiDao.updateByNo(updateHoogi);
		System.out.println(updateno);*/

		// 전체 리스트 뽑기
/*
		List<Hoogi> HoogiList = hoogiDao.selectAll();
		System.out.println("size =" + HoogiList.size());
		for (Hoogi hoogilist : HoogiList) {
			System.out.println(hoogilist.toString());
		}*/
		/*System.out.println("-------번호하나뽑기---------");
		Hoogi selectByNo = hoogiDao.selectByNo(50);
		System.out.println(selectByNo);
		// System.out.println(hoogi.toString());

		System.out.println("---이미지로 뽑기----");
		Hoogi selectImgByNo = hoogiDao.selectImgByNo(50);
		System.out.println(selectImgByNo);

		// 전체 조회수로 뽑기
		List<Hoogi> HoogiListCount = hoogiDao.selectByCount();
		for (Hoogi HoogiListCount1 : HoogiListCount) {
			System.out.println(HoogiListCount1.toString());
		}

		System.out.println("success");

		System.out.println("success");

		System.out.println("제목으로 찾기");
		List<Hoogi> HoogiListTitle = hoogiDao.selectByTitle("1");
		for (Hoogi HoogiListTitle1 : HoogiListTitle) {
			System.out.println(HoogiListTitle1);
		}
		System.out.println("success");

		System.out.println("맛집이름으로 List 가져오기 아직 NULL");
		Hoogi selectTNo = hoogiDao.selectTNo(30);
		System.out.println(selectTNo);
		System.out.println("success");

		System.out.println("카운트 수 올리기");
		int updateByCountNo = hoogiDao.updateByCountNo(51);
		System.out.println(updateByCountNo);

		System.out.println("전체 날짜리스트로 뽑기");
		List<Hoogi> HoogiListDate = hoogiDao.selectByDate();
		for (Hoogi HoogiListDate1 : HoogiListDate) {
			System.out.println(HoogiListDate1.toString());
		}*/

		System.out.println("원하는 개수만큼 뽑아오기");
		List<Hoogi> hoogiListPage = hoogiDao.findHoogi1(1, 6);
		for (Hoogi hoogiList1 : hoogiListPage) {
			System.out.println("띵"+hoogiList1);
		}
		
		/*System.out.println("select 총 개수 뽑기");
		int selectcount = hoogiDao.selectcount();
		System.out.println(selectcount);*/

	}

}
