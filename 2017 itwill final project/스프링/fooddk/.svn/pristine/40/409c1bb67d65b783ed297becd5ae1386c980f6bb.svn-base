package fooddk.service.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.dao.category.CategoryDao;
import fooddk.domain.Category;

public class CategoryServiceImpl implements CategoryService {
	public static final String namespace ="com.category.mapper.CategoryMapper.";
	private CategoryDao categoryDao;
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2. ### CotegoryDaoImpl.setSqlSession("+sqlSession+") 인젝션됨");
		this.sqlSession = sqlSession;
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		System.out.println("CategoryServiceImpl.setCategoryDao()생성자 호출"+categoryDao);
		this.categoryDao = categoryDao;
	}

	@Override
	public int insertCategory(Category category) {
		
		return categoryDao.insertCategory(category);
	}

	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.updateCategory(category);
	}

	@Override
	public int deleteCategory(int c_no) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategory(c_no);
	}

	@Override
	public Category selectCategoryNumber(int c_no) {
		// TODO Auto-generated method stub
		return categoryDao.selectCategoryNumber(c_no);
	}

	@Override
	public List<Category> AllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.AllCategory();
	}

	

}
