package fooddk.dao.recipe;

import java.util.List;

import fooddk.domain.Recipe;

public interface RecipeDao {
	
	public int insert(fooddk.domain.Recipe recipe);
	public int deleteByNo(int r_no);
	public int updateByNo(Recipe recipe);
	public List<Recipe> selectAll();
	public String selectImgByNo(int r_no);
	public List<Recipe> selectByCount();
	public List<Recipe> selectByDate();
	public List<Recipe> selectByTitle(String r_title);
	public int updateCount(int r_no);
	public int countAll();
	/*public List<Recipe> findRecipeList(int start, int last);*/
	public Recipe selectByNo(int r_no);
	public int countAllByDynamic(int c_no);
	public List<Recipe> findRecipelistByCno(int start, int last, int c_no);
	public List<Recipe> selectAllByCount();
	
}
