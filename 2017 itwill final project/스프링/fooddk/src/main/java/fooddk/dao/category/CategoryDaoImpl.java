package fooddk.dao.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Category;

public class CategoryDaoImpl implements CategoryDao {
	public static final String namespace ="com.category.mapper.CategoryMapper.";
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2. ### CotegoryDaoImpl.setSqlSession("+sqlSession+") 인젝션됨");
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertCategory(Category category) {
		System.out.println(category.getC_no());
		System.out.println(category.getC_kind());
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+"insertCategory",category);
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+"updateCategory",category);
	}

	@Override
	public int deleteCategory(int c_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+"deleteCategory",c_no);
	}

	@Override
	public Category selectCategoryNumber(int c_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"selectCategoryNumber",c_no);
	}

	@Override
	public List<Category> AllCategory() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"AllCategory");
	}

	

}
