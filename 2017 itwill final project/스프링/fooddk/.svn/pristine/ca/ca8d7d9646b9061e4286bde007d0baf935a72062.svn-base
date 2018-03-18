package fooddk.dao.score;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Score;

public class ScoreDaoImpl implements ScoreDao{
	public static final String namespace ="com.score.mapper.ScoreMapper.";
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2. ### ScoreDaoImpl.setSqlSession("+sqlSession+") 인젝션됨");
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertScore(Score score) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"insertScore",score);
	}

	@Override
	public int updateScore(Score score) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"updateScore",score);
	}

	@Override
	public int deleteScore(int s_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"deleteScore",s_no);
	}

	@Override
	public Score selectOneScore(int s_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"selectOneScore",s_no);
	}

	@Override
	public List<Score> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"selectAll");
	}

}
