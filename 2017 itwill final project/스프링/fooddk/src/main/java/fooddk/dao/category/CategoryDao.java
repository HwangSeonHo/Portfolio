package fooddk.dao.category;

import java.util.List;

import fooddk.domain.Category;

public interface CategoryDao {
	
	int insertCategory(Category category);
	int updateCategory(Category category);
	
	List<Category> AllCategory();
	Category selectCategoryNumber(int c_no);
	int deleteCategory(int c_no);
}
