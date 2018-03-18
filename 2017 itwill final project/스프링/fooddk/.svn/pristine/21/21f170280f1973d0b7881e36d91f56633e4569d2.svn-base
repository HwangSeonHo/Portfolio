package fooddk.service.datgle;

import java.util.List;

import fooddk.dao.datgle.DatgleDao;
import fooddk.domain.Datgle;
import fooddk.paging.ListPageConfigBean_filter;
import fooddk.paging.ListResultBean_filter;

public interface DatgleService {

	void setDatgleDao(DatgleDao datgleDao);

	ListResultBean_filter selectList(ListPageConfigBean_filter pageConfig) throws Exception;

	List<Datgle> selectByFilterTitle(Datgle datgle);

	Datgle selectByNo(int d_no);

	List<Datgle> selectAllByFilter(String d_filter);

	int selectCountByFilter(String d_filter);
	
	int selectCount(Datgle datgle);

	int insert(Datgle datgle);

	int updateByNo(Datgle datgle);

	int deleteByNo(int d_no);

}