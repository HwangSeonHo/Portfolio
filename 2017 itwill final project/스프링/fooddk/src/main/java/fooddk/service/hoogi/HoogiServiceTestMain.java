package fooddk.service.hoogi;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.core.net.SyslogOutputStream;
import fooddk.domain.Hoogi;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListResultBean_hoogi;

public class HoogiServiceTestMain {
	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/application-config.xml");
		// HoogiDaoImpl Himpl=new HoogiDaoImpl();
		System.out.println("1");
		Hoogi hoogi = new Hoogi();
		// HoogiDao hoogiDao=(HoogiDao)applicationContext.getBean("HoogiDao");
		HoogiService hoogiService = (HoogiService) applicationContext.getBean("hoogiService");

		// delete 타입
		System.out.println("삭제하기");
		int deleteno = hoogiService.deleteByNo(25);
		System.out.println("success"+deleteno); 
		/*// insert 타입

		Hoogi insertHoogi = new Hoogi("0808", "0808", new Date(), "0808", 1);
		int insertno = hoogiService.insertHoogi(insertHoogi);

		System.out.println(insertno);
		System.out.println("success");

	
		// update 하기
		System.out.println("수정하기");
		Hoogi updateHoogi = new Hoogi("수정", "수정", "수정", 666666, 50);
		int updateHoogiList = hoogiService.updateByNo(updateHoogi);
		System.out.println(updateHoogi);
		System.out.println("success");*/

		// 모든 리스트 뽑아오기
		/*System.out.println("모든 리스트 뽑아오기");
		List<Hoogi> hoogiList = hoogiService.selectAll();
		for (Hoogi hoogi1 : hoogiList) {
			System.out.println(hoogi1);
		}*/
		/*//리스트 하나 뽑아오기
		System.out.println("리스트 하나만 뽑아오기");
		Hoogi selectByNo = hoogiService.selectByNo(91);
		System.out.println(selectByNo);
		System.out.println("success");
		
		//후기 글 사진 하나 뽑아오기
		System.out.println("이미지 하나 뽑아서 디테일보기");
		Hoogi selectImgByNo = hoogiService.selectImgByNo(91);
		System.out.println(selectImgByNo);
		System.out.println("success");
		
		//후기 조회수로 리스트 뽑아오기
		System.out.println(" 조회수 리스트 뽑아오기");
		List<Hoogi> hoogiListCount = hoogiService.selectByCount();
		for(Hoogi hoogi2 : hoogiListCount){
			System.out.println(hoogi2);
		}
		//후기 날짜순으로 리스트 뽑아오기
		System.out.println(" 날짜순 리스트 뽑아오기");
		List<Hoogi> hoogiListDate = hoogiService.selectByDate();
		for(Hoogi hoogi3 : hoogiListDate){
			System.out.println(hoogi3);
		}
		
		//타이틀 받아오기
		System.out.println("검색해서 리스트 뽑아오기");
		List<Hoogi> hoogiListTitle = hoogiService.selectByTitle("0807");
		for(Hoogi hoogi4 : hoogiListTitle){
			System.out.println(hoogi4);
		}
		//맛집 태그?
		System.out.println("맛집태그?하기");
		Hoogi hoogiselectTNO = hoogiService.selectTNo(1);
		System.out.println(hoogiselectTNO);
		
		//업데이트 조회 올리기
		System.out.println("조회수 업데이트");
		int hoogiupdateByCountno = hoogiService.updateByCountNo(64);
		System.out.println(hoogiupdateByCountno);
		
		//총 개시글 수 
		System.out.println("총 게시글 뽑아오기");
		int selectcount = hoogiService.selectcount();
		System.out.println("총 게시글 수 " +selectcount);

		
		//테이블 당 출력행수 rowCountPerPage
		//한 페이지에 보여지는 페이지 수 pageCountPerPage
		//선택한 현재 페이지 번호 selectPage
		//사용자 선택 검색타입 searchType (필요X)
		//사용자 입력검색내용 searchContent (필요X)
		ListPageConfigBean listpageconfigbean = new ListPageConfigBean(10,1,"3","a","b");
		
		ListResultBean_hoogi listresultbean = hoogiService.selectAllPaging(listpageconfigbean);
		System.out.println("paging 뽑아오기");
		for(Hoogi hoogiListPaging : listresultbean.getList()){
			System.out.println(hoogiListPaging.getH_no());
			System.out.println(hoogiListPaging.getH_title());
			System.out.println(hoogiListPaging.getH_content());
			System.out.println(hoogiListPaging.getH_date());
			System.out.println(hoogiListPaging.getH_img());
			System.out.println(hoogiListPaging.getH_count());
		}*/
	}
}
