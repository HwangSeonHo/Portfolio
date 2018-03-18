package fooddk.dao.arduino;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Jumon;

public interface JumonDao {

	void setSqlSession(SqlSession sqlSession);

	List<Jumon> selectAll();

	List<Jumon> selectBySeatNo(Jumon jumon);

	int insert(Jumon jumon);

	int update(Jumon jumon);

	int delete(int j_no);

}