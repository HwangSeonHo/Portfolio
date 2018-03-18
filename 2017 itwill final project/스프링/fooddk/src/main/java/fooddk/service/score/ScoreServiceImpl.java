package fooddk.service.score;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.dao.score.ScoreDao;
import fooddk.domain.Score;

public class ScoreServiceImpl implements ScoreDao{
	public static final String namespace ="com.score.mapper.ScoreMapper.";
	private SqlSession sqlSession;
	private ScoreDao scoreDao;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2. ### ScoreDaoImpl.setSqlSession("+sqlSession+") 인젝션됨");
		this.sqlSession = sqlSession;
	}
	
	public void setScoreDao(ScoreDao scoreDao) {
		System.out.println("ScoreServiceImpl.setScoreDao()생성자 호출"+scoreDao);
		this.scoreDao = scoreDao;
	}

	@Override
	public int insertScore(Score score) {
		// TODO Auto-generated method stub
		return scoreDao.insertScore(score);
	}

	@Override
	public int updateScore(Score score) {
		// TODO Auto-generated method stub
		return scoreDao.updateScore(score);
	}

	@Override
	public int deleteScore(int s_no) {
		// TODO Auto-generated method stub
		return scoreDao.deleteScore(s_no);
	}

	@Override
	public Score selectOneScore(int s_no) {
		// TODO Auto-generated method stub
		return scoreDao.selectOneScore(s_no);
	}

	@Override
	public List<Score> selectAll() {
		// TODO Auto-generated method stub
		return scoreDao.selectAll();
	}

}
