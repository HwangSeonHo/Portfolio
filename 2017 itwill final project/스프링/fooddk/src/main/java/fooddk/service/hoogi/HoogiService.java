package fooddk.service.hoogi;

import java.util.List;

import fooddk.domain.Hoogi;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListResultBean_hoogi;
import fooddk.paging.ListResultBean_tasty;

public interface HoogiService {
	
	
	// 후기 글 올리기 @@
		int insertHoogi(Hoogi hoogi);

		// 후기글 삭제 @@
		int deleteByNo(int h_no);

		// 후기 글 업데이트 @@ 
		int updateByNo(Hoogi hoogi);

		// 후기글 전체 선택 @@
		List<Hoogi> selectAll();

		// 후기 글 하나 선택 @@
		Hoogi selectByNo(int h_no);

		// 후기 글 사진 @@ 
		Hoogi selectImgByNo(int h_no);

		// 후기 조회수로 리스트 뽑기 @@
		List<Hoogi> selectByCount();

		// 후기 날짜수로 리스트 뽑기  @@
		List<Hoogi> selectByDate();

		// 검색으로 제목뽑아오기 @@
		List<Hoogi> selectByTitle(String h_title);

		// 맛집태그 @@
		Hoogi selectTNo(int t_no);
		 
		//업데이트조회수 @@
		int updateByCountNo(int h_no);
		
		//총 개시물 개수 뽑아오기 @@
		int selectcount();
		//페이징 게시물 리스트 @@
		public ListResultBean_hoogi selectAllPaging(ListPageConfigBean pageConfig) throws Exception;
		
		ListResultBean_hoogi selectDate(ListPageConfigBean pageConfig) throws Exception;
		
		List<Hoogi> findHoogi(int start, int last);
		List<Hoogi> findHoogi1(int start, int last);
		
		Hoogi selectByt_no(int t_no);

	//후기 글 올리기 int insertHoogi(Hoogi hoogi);
	
	
	// 후기 글 삭제 int deleteByNo(int h_no);
	
	// 후기 글 업데이트 int updateByNo(Hoogi hoogi);
	 
	// 후기 글 전체선택 List<Hoogi> selectAll();
	
	// 후기 글 하나 선택 Hoogi selectByNo(int h_no);
	
	// 후기 글 사진으로 뽑아오기 Hoogi selectImgByNo(int h_no);
	
	// 후기 조회수로 리스트 뽑기 List<Hoogi> selectByCount();
	
	// 후기 날짜수로 리스트 뽑기 List<Hoogi> selectByDate(Hoogi hoogi);
	
	// 후기 검색으로 제목뽑아오기 List<Hoogi> selectByTitle(String h_title);
	 
	//맛집 태그 ( 제목 설정할 때) Hoogi selectTNo(int t_no);
	
	//업데이트 조회수 ( 클릭 시 업데이트 되어 조회수 올리기) int updateByCountNo(int h_no);
	
	
	
}
