package fooddk.dao.arduino;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Item;
import fooddk.domain.Porce;

public class ItemDaoImpl implements ItemDao {
	public static final String namespace = "mapper.ItemMapper.";
	private SqlSession sqlSession;

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.ItemDao#setSqlSession(org.apache.ibatis.session.SqlSession)
	 */
	@Override
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.ItemDao#selectAll()
	 */
	@Override
	public List<Item> selectAll(){
		return sqlSession.selectList(namespace+"selectAll");
	}
	
	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.ItemDao#selectByNo(int)
	 */
	@Override
	public Item selectByNo(int i_no){
		return sqlSession.selectOne(namespace+"selectByNo",i_no);
	}

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.ItemDao#insert(fooddk.domain.Item)
	 */
	@Override
	public int insert(Item item){
		sqlSession.insert(namespace+"insert",item);
		return item.getI_no();
	}

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.ItemDao#update(fooddk.domain.Item)
	 */
	@Override
	public int update(Item item){
		return sqlSession.update(namespace+"update",item);
	}

	/* (non-Javadoc)
	 * @see fooddk.dao.arduino.ItemDao#delete(int)
	 */
	@Override
	public int delete(int i_no){
		return sqlSession.delete(namespace+"delete",i_no);
	}
	
}
