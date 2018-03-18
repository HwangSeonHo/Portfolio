package fooddk.dao.datgle;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Datgle;

public interface DatgleDao {

	void setSqlSession(SqlSession sqlSession);

	List<Datgle> selectList(int start, int last, String filter, int d_groupno);

	List<Datgle> selectByFilterTitle(Datgle datgle);

	Datgle selectByNo(int d_no);

	List<Datgle> selectAllByFilter(String d_filter);

	int selectCountByFilter(String d_filter);
	
	int selectCount(Datgle datgle);

	int insert(Datgle datgle);

	int updateByNo(Datgle datgle);

	int deleteByNo(int d_no);

}