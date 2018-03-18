package fooddk.service.datgle;

import java.util.List;

import fooddk.dao.datgle.DatgleDao;
import fooddk.domain.Datgle;
import fooddk.paging.ListPageConfigBean_filter;
import fooddk.paging.ListResultBean_filter;
import fooddk.paging.PageCounter_filter;

public class DatgleServiceImpl implements DatgleService {

	DatgleDao datgleDao;

	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#setDatgleDao(fooddk.dao.DatgleDao)
	 */
	@Override
	public void setDatgleDao(DatgleDao datgleDao) {
		this.datgleDao = datgleDao;
	}
		
	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#selectList(fooddk.domain.ListPageConfigBean)
	 */
	@Override
	public ListResultBean_filter selectList(ListPageConfigBean_filter pageConfig) throws Exception{
		
		int totalRecordCount = datgleDao.selectCount(new Datgle(pageConfig.getD_filter(),pageConfig.getD_groupno()));

		ListResultBean_filter resultBean=PageCounter_filter.getPagingInfo(
								Integer.parseInt(pageConfig.getSelectPage()),
								pageConfig.getRowCountPerPage(),
								pageConfig.getPageCountPerPage(),
								totalRecordCount,
								pageConfig.getD_filter(),
								pageConfig.getD_groupno());
	
		List<Datgle> boardList = datgleDao.selectList(resultBean.getStartRowNum(),resultBean.getEndRowNum(),resultBean.getD_filter(),resultBean.getD_groupno());
		
		resultBean.setList(boardList);
		
		return resultBean;
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#selectByFilterTitle(fooddk.domain.Datgle)
	 */
	@Override
	public List<Datgle> selectByFilterTitle(Datgle datgle){
		return datgleDao.selectByFilterTitle(datgle);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#selectByNo(int)
	 */
	@Override
	public Datgle selectByNo(int d_no){
		return datgleDao.selectByNo(d_no);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#selectAllByFilter(java.lang.String)
	 */
	@Override
	public List<Datgle> selectAllByFilter(String d_filter){
		return datgleDao.selectAllByFilter(d_filter);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#selectCountByFilter(java.lang.String)
	 */
	@Override
	public int selectCountByFilter(String d_filter){
		return datgleDao.selectCountByFilter(d_filter);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#selectCount(fooddk.domain.Datgle)
	 */
	@Override
	public int selectCount(Datgle datgle){
		return datgleDao.selectCount(datgle);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#insert(fooddk.domain.Datgle)
	 */
	@Override
	public int insert(Datgle datgle){
		return datgleDao.insert(datgle);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#updateByNo(fooddk.domain.Datgle)
	 */
	@Override
	public int updateByNo(Datgle datgle){
		return datgleDao.updateByNo(datgle);
	}

	/* (non-Javadoc)
	 * @see fooddk.service.DatgleService#deleteByNo(int)
	 */
	@Override
	public int deleteByNo(int d_no){
		return datgleDao.deleteByNo(d_no);
	}
}
