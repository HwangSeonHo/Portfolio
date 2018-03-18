package fooddk.dao.datgle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Datgle;
import fooddk.paging.ListResultBean_filter;

public class DatgleDaoImpl implements DatgleDao {
	public static final String namespace = "mapper.datgleMapper.";
	private SqlSession sqlSession;

	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#setSqlSession(org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#selectList(int, int, java.lang.String)
	 */
	@Override
	public List<Datgle> selectList(int start, int last, String filter, int d_groupno){
		ListResultBean_filter listResultBean = new ListResultBean_filter();
		listResultBean.setStartRowNum(start);
		listResultBean.setEndRowNum(last);
		listResultBean.setD_filter(filter);
		listResultBean.setD_groupno(d_groupno);
		
		return sqlSession.selectList(namespace+"selectList", listResultBean);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#selectByFilterTitle(fooddk.domain.Datgle)
	 */
	@Override
	public List<Datgle> selectByFilterTitle(Datgle datgle){
		return sqlSession.selectList(namespace+"selectByFilterTitle", datgle);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#selectByNo(int)
	 */
	@Override
	public Datgle selectByNo(int d_no){
		return sqlSession.selectOne(namespace+"selectByNo",d_no);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#selectAllByFilter(java.lang.String)
	 */
	@Override
	public List<Datgle> selectAllByFilter(String d_filter){
		return sqlSession.selectList(namespace+"selectAllByFilter",d_filter);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#selectCount(fooddk.domain.Datgle)
	 */
	@Override
	public int selectCount(Datgle datgle){
		return sqlSession.selectOne(namespace+"selectCount", datgle);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#selectCountByFilter(java.lang.String)
	 */
	@Override
	public int selectCountByFilter(String d_filter){
		return sqlSession.selectOne(namespace+"selectCountByFilter", d_filter);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#insert(fooddk.domain.Datgle)
	 */
	@Override
	public int insert(Datgle datgle){
		sqlSession.insert(namespace+"insert",datgle);
		return datgle.getD_no();
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#updateByNo(fooddk.domain.Datgle)
	 */
	@Override
	public int updateByNo(Datgle datgle){
		return sqlSession.update(namespace+"updateByNo",datgle);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.DatgleDao#deleteByNo(int)
	 */
	@Override
	public int deleteByNo(int d_no){
		return sqlSession.delete(namespace+"deleteByNo",d_no);
	}
	
}
