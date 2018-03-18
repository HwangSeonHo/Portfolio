package fooddk.service.tasty;

import java.util.List;

import fooddk.dao.tasty.TastyDaoImpl;
import fooddk.domain.Tasty;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListResultBean_tasty;
import fooddk.paging.PageCounter_tasty;

public class TastyServiceImpl implements TastyService {
	
	private TastyDaoImpl tastyDao;
	
	public void setTastyDao(TastyDaoImpl tastyDao) {
		this.tastyDao = tastyDao;
	}
	

	@Override
	public ListResultBean_tasty selectList(ListPageConfigBean pageConfig) throws Exception {
		//전체 글 개수 반환하기
		int totalRecordCount = tastyDao.countAll();
				
				
		//게시판 밑에 페이지 번호 구하기 (페이지 카운터, 페이지 행, 페이지 수, 전체행수
		ListResultBean_tasty resultBean = PageCounter_tasty.getPagingInfo(
				Integer.parseInt(pageConfig.getSelectPage()),
				pageConfig.getRowCountPerPage(), 
				pageConfig.getPageCountPerPage(), totalRecordCount);
				
		//List<Hoogi> findHoogi(int start, int last); 받아오기 처음 시작하는 숫자, 마지막 숫자
		List<Tasty> tastyList = tastyDao.selectList(resultBean.getStartRowNum(), resultBean.getEndRowNum());
				
		resultBean.setList(tastyList);
		return resultBean;
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#insert(fooddk.domain.Tasty)
	 */
	@Override
	public int insert(Tasty tasty){
		return tastyDao.insert(tasty);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#updateByNo(fooddk.domain.Tasty)
	 */
	@Override
	public int updateByNo(Tasty tasty){
		tasty.setT_location(selectByNo(tasty.getT_no()).getT_location());
		return tastyDao.updateByNo(tasty);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#updateCount(int)
	 */
	@Override
	public int updateCount(int t_no){
		return tastyDao.updateCount(t_no);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#deleteByNo(int)
	 */
	@Override
	public int deleteByNo(int t_no){
		return tastyDao.deleteByNo(t_no);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#selectAll()
	 */
	@Override
	public List<Tasty> selectAll(){
		return tastyDao.selectAll();
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#selectByNo(int)
	 */
	@Override
	public Tasty selectByNo(int t_no){
		return tastyDao.selectByNo(t_no);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#selectCount()
	 */
	@Override
	public ListResultBean_tasty selectCount(ListPageConfigBean pageConfig) throws Exception {
		// 전체 글 개수 반환하기
		int totalRecordCount = tastyDao.countAll();

		// 게시판 밑에 페이지 번호 구하기 (페이지 카운터, 페이지 행, 페이지 수, 전체행수
		ListResultBean_tasty resultBean = PageCounter_tasty.getPagingInfo(Integer.parseInt(pageConfig.getSelectPage()),
				pageConfig.getRowCountPerPage(), pageConfig.getPageCountPerPage(), totalRecordCount);

		// List<Hoogi> findHoogi(int start, int last); 받아오기 처음 시작하는 숫자, 마지막 숫자
		List<Tasty> tastyList = tastyDao.selectCount(resultBean.getStartRowNum(), resultBean.getEndRowNum());

		resultBean.setList(tastyList);
		return resultBean;
	}
	
		
	
	
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#selectDate()
	 */
	@Override
	public ListResultBean_tasty selectDate(ListPageConfigBean pageConfig) throws Exception{
		// 전체 글 개수 반환하기
				int totalRecordCount = tastyDao.countAll();

				// 게시판 밑에 페이지 번호 구하기 (페이지 카운터, 페이지 행, 페이지 수, 전체행수
				ListResultBean_tasty resultBean = PageCounter_tasty.getPagingInfo(Integer.parseInt(pageConfig.getSelectPage()),
						pageConfig.getRowCountPerPage(), pageConfig.getPageCountPerPage(), totalRecordCount);

				// List<Hoogi> findHoogi(int start, int last); 받아오기 처음 시작하는 숫자, 마지막 숫자
				List<Tasty> tastyList = tastyDao.selectDate(resultBean.getStartRowNum(), resultBean.getEndRowNum());

				resultBean.setList(tastyList);
				return resultBean;
	}
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#selectImgByNo(int)
	 */
	@Override
	public String selectImgByNo(int t_no){
		return tastyDao.selectImgByNo(t_no);
	}
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#selectAddressByNo(int)
	 */
	@Override
	public String selectAddressByNo(int t_no){
		return tastyDao.selectAddressByNo(t_no);
	}
	/* (non-Javadoc)
	 * @see fooddk.service.TastyService#selectByTitle(java.lang.String)
	 */
	@Override
	public ListResultBean_tasty selectByTitle(String t_title,ListPageConfigBean pageConfig) throws Exception{
		List<Tasty> tasty = tastyDao.selectByTitle(t_title);
		int totalRecordCount = tastyDao.countAll();

		// 게시판 밑에 페이지 번호 구하기 (페이지 카운터, 페이지 행, 페이지 수, 전체행수
		ListResultBean_tasty resultBean = PageCounter_tasty.getPagingInfo(Integer.parseInt(pageConfig.getSelectPage()),
				pageConfig.getRowCountPerPage(), pageConfig.getPageCountPerPage(), totalRecordCount);

		resultBean.setList(tasty);
		return resultBean;
	}
	
	public int countAll(){
		return tastyDao.countAll();
	}


}
