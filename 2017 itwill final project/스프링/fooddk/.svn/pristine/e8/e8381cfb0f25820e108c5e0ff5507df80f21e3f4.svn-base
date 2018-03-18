package fooddk.dao.arduino;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Item;

public interface ItemDao {

	void setSqlSession(SqlSession sqlSession);

	List<Item> selectAll();

	Item selectByNo(int i_no);

	int insert(Item item);

	int update(Item item);

	int delete(int i_no);

}