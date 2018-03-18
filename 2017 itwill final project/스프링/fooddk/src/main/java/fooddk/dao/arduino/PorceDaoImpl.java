package fooddk.dao.arduino;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Porce;

public class PorceDaoImpl implements PorceDao  {
	public static final String namespace = "mapper.PorceMapper.";
	private SqlSession sqlSession;

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.Porce#setSqlSession(org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.Porce#selectAll()
	 */
	@Override
	public List<Porce> selectAll(){
		return sqlSession.selectList(namespace+"selectAll");
	}

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.Porce#insert(fooddk.domain.Porce)
	 */
	@Override
	public int insert(Porce porce){
		sqlSession.insert(namespace+"insert",porce);
		return porce.getP_no();
	}

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.Porce#update(fooddk.domain.Porce)
	 */
	@Override
	public int update(Porce porce){
		return sqlSession.update(namespace+"update",porce);
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.Porce#delete(int)
	 */
	@Override
	public int delete(int p_no){
		return sqlSession.delete(namespace+"delete",p_no);
	}
	
}
