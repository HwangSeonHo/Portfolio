package fooddk.service.hoogi;

import java.util.List;

import fooddk.dao.hoogi.HoogiDao;
import fooddk.domain.Hoogi;
import fooddk.domain.Tasty;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListResultBean_hoogi;
import fooddk.paging.PageCounter_hoogi;

public class HoogiServiceImpl implements HoogiService {

	HoogiDao hoogiDao;
	
	public void setHoogiDao(HoogiDao hoogiDao) {
		this.hoogiDao = hoogiDao;
	}
	

	//서비스 후기 글 작성 @
	@Override 
	public int insertHoogi(Hoogi hoogi) {
		return hoogiDao.insertHoogi(hoogi);
	}
	//서비스 글 삭제하기 @
	@Override
	public int deleteByNo(int h_no) {
		return hoogiDao.deleteByNo(h_no);
	}
	
	//서비스 글 업데이트 @
	@Override
	public int updateByNo(Hoogi hoogi) {
		
		return hoogiDao.updateByNo(hoogi);
	}
	
	//전체 글 리스트 받아오기 @
	@Override
	public List<Hoogi> selectAll() {
		
		return hoogiDao.selectAll();
	}

	//선택한 번호 받아오기 @
	@Override
	public Hoogi selectByNo(int h_no) {
		
		return hoogiDao.selectByNo(h_no);
	}
	
	//선택한 이미지 받아오기 @
	@Override
	public Hoogi selectImgByNo(int h_no) {
		
		return hoogiDao.selectImgByNo(h_no);
	}

	//조회수로 리스트 뽑기 @
	@Override 
	public List<Hoogi> selectByCount() {
		return hoogiDao.selectByCount();
	}

	//날짜수로 리스트 뽑기 @
	@Override
	public List<Hoogi> selectByDate() {
	
		return hoogiDao.selectByDate();
	}
	
	//제목검색 @
	@Override
	public List<Hoogi> selectByTitle(String h_title) {
		
		return hoogiDao.selectByTitle(h_title);
	}

	//맛집번호로 불러오기
	@Override
	public Hoogi selectTNo(int t_no) {
		
		return hoogiDao.selectTNo(t_no);
	}

	//클릭 시 업데이트
	@Override
	public int updateByCountNo(int h_no) {
	
		return hoogiDao.updateByCountNo(h_no);
	}
	//총 개수 뽑아오기
	@Override
	public int selectcount() {
		
		return hoogiDao.selectcount();
	}
	@Override
	public ListResultBean_hoogi selectAllPaging(ListPageConfigBean pageConfig) throws Exception {
		//전체 글 개수 반환하기
		int totalRecordCount = hoogiDao.selectcount();
		
		
		//게시판 밑에 페이지 번호 구하기 (페이지 카운터, 페이지 행, 페이지 수, 전체행수
		ListResultBean_hoogi resultBean = PageCounter_hoogi.getPagingInfo(Integer.parseInt(pageConfig.getSelectPage()),
				pageConfig.getRowCountPerPage(), 
				pageConfig.getPageCountPerPage(), totalRecordCount);
		
		//List<Hoogi> findHoogi(int start, int last); 받아오기 처음 시작하는 숫자, 마지막 숫자
		List<Hoogi> hoogiList = hoogiDao.findHoogi(resultBean.getStartRowNum(), resultBean.getEndRowNum());
		
		resultBean.setList(hoogiList);
		return resultBean;
	}
	
	@Override
	public ListResultBean_hoogi selectDate(ListPageConfigBean pageConfig) throws Exception{
		// 전체 글 개수 반환하기
				int totalRecordCount = hoogiDao.selectcount();

				// 게시판 밑에 페이지 번호 구하기 (페이지 카운터, 페이지 행, 페이지 수, 전체행수
				ListResultBean_hoogi resultBean = PageCounter_hoogi.getPagingInfo(Integer.parseInt(pageConfig.getSelectPage()),
						pageConfig.getRowCountPerPage(), pageConfig.getPageCountPerPage(), totalRecordCount);

				// List<Hoogi> findHoogi(int start, int last); 받아오기 처음 시작하는 숫자, 마지막 숫자
				List<Hoogi> hoogiList = hoogiDao.selectDate(resultBean.getStartRowNum(), resultBean.getEndRowNum());

				resultBean.setList(hoogiList);
				return resultBean;
	}

	@Override
	public List<Hoogi> findHoogi(int start, int last) {
		return hoogiDao.findHoogi(start, last);
	}


	@Override
	public Hoogi selectByt_no(int t_no) {
		return hoogiDao.selectByt_no(t_no);
	}


	@Override
	public List<Hoogi> findHoogi1(int start, int last) {
		return hoogiDao.findHoogi1(start, last);
	}

}
