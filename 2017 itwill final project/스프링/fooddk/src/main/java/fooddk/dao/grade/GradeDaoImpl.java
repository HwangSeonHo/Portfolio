package fooddk.dao.grade;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Grade;

public class GradeDaoImpl implements GradeDao{
	public static final String namespace ="mapper.GradeMapper.";
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2. ### GradeDaoImpl.setSqlSession("+sqlSession+") 인젝션됨");
		this.sqlSession = sqlSession;
	}

	@Override
	   public int insertGrade(Grade grade) {
	      // TODO Auto-generated method stub
	      return sqlSession.insert(namespace+"insertGrade",grade);
	   }

	   @Override
	   public int updateGrade(Grade grade) {
	      // TODO Auto-generated method stub
	      return sqlSession.update(namespace+"updateGrade",grade);
	   }

	   @Override
	   public int deleteGrade(int g_no) {
	      // TODO Auto-generated method stub
	      return sqlSession.delete(namespace+"deleteGrade",g_no);
	   }

	   @Override
	   public Grade selectGradeOne(int g_no) {
	      // TODO Auto-generated method stub
	      return sqlSession.selectOne(namespace+"selectGradeOne",g_no);
	   }

	   @Override
	   public List<Grade> selectGradeAll() {
	      // TODO Auto-generated method stub
	      return sqlSession.selectList(namespace+"selectGradeAll");
	   }
	
	

	

}
