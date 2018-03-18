package fooddk.dao.arduino;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Jumon;
import fooddk.domain.Porce;

public class JumonDaoImpl implements JumonDao {
	public static final String namespace = "mapper.JumonMapper.";
	private SqlSession sqlSession;

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.JumonDao#setSqlSession(org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.JumonDao#selectAll()
	 */
	@Override
	public List<Jumon> selectAll(){
		return sqlSession.selectList(namespace+"selectAll");
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.JumonDao#selectBySeatNo(fooddk.domain.Jumon)
	 */
	@Override
	public List<Jumon> selectBySeatNo(Jumon jumon){
		return sqlSession.selectList(namespace+"selectBySeatNo",jumon);
	}

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.JumonDao#insert(fooddk.domain.Jumon)
	 */
	@Override
	public int insert(Jumon jumon){
		sqlSession.insert(namespace+"insert",jumon);
		return jumon.getJ_no();
	}


	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.JumonDao#update(fooddk.domain.Jumon)
	 */
	@Override
	public int update(Jumon jumon){
		return sqlSession.update(namespace+"update",jumon);
	}
	

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.JumonDao#delete(int)
	 */
	@Override
	public int delete(int j_no){
		return sqlSession.delete(namespace+"delete",j_no);
	}
	
}
