package fooddk.service.recipe;

import java.util.List;
import java.util.Map;

import fooddk.dao.recipe.RecipeDao;
import fooddk.domain.Recipe;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListPageConfigBean_recipe;
import fooddk.paging.ListResultBean;
import fooddk.paging.ListResultBean_recipe;
import fooddk.paging.PageCounter;
import fooddk.paging.PageCounter_recipe;

public class RecipeServiceImpl {

	RecipeDao recipeDao;
	

	public void setRecipeDao(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}
	
	/*
	 * 1. 게시글 생성하기
	 */


	public int insert(Recipe recipe) {
		
		return recipeDao.insert(recipe);
	}
	/*
	 * 2. 게시글 삭제하기
	 */

	public int deleteByNo(int r_no) {
		
		return recipeDao.deleteByNo(r_no);
	}
	/*
	 * 3.  게시글 수정하기
	 */

	public int updateByNo(Recipe recipe) {
		
		return recipeDao.updateByNo(recipe);
	}
	/*
	 * 4. 게시글 전체리스트 보기
	 */

	public List<Recipe> selectAll() {
		
		return recipeDao.selectAll();
	}
	/*
	 * 5. 이미지 선택하기
	 */

	public String selectImgByNo(int r_no) {
		
		return recipeDao.selectImgByNo(r_no);
	}
	/*
	 * 6. 조회수로 오름차순 정렬 
	 */

	public List<Recipe> selectByCount() {
		
		return recipeDao.selectByCount();
	}
	/*
	 * 7. 날짜순으로 오름차순 정렬
	 */


	public List<Recipe> selectByDate() {
		
		return recipeDao.selectByDate();
		
	}
	/*
	 * 8. 게시글 제목으로 검색하기
	 */

	public List<Recipe> selectByTitle(String r_title) {
	
		return recipeDao.selectByTitle(r_title);
	}
	/*
	 * 9. 조회수 증가하기
	 */

	public int updateCount(int r_no) {
		
		return recipeDao.updateCount(r_no);
	}
	/*
	 * 10.  전체 게시물 개수
	 */

	public int countAll() {
		return recipeDao.countAll();
	}
	/*
	 * 11. 선택한 게시물 개수 리스트 가져오기
	 */	

	/*public ListResultBean selectList(ListPageConfigBean pageConfig) throws Exception{
			int totalRecordCount = recipeDao.countAll();
	
			ListResultBean resultBean=PageCounter.getPagingInfo(
									Integer.parseInt(pageConfig.getSelectPage()),
									pageConfig.getRowCountPerPage(),
									pageConfig.getPageCountPerPage(),
									totalRecordCount);
		
			List<Recipe> boardList = recipeDao.findRecipeList(resultBean.getStartRowNum(), resultBean.getEndRowNum());
			
			resultBean.setList(boardList);
			
			return resultBean;
		}*/
	/*
	 * 12. 번호로 검색
	 */

	public Recipe selectByNo(int r_no){
		return recipeDao.selectByNo(r_no);
		
	}
	/*
	 * 13. 종류별 선택한 게시물 가져오기
	 */	

	public ListResultBean_recipe selectListByCno(ListPageConfigBean_recipe pageConfig) throws Exception{
			int totalRecordCount = recipeDao.countAllByDynamic(pageConfig.getC_no());
			System.out.println("****************"+pageConfig.getC_no());
			
	
			ListResultBean_recipe resultBean=PageCounter_recipe.getPagingInfo(
									Integer.parseInt(pageConfig.getSelectPage()),
									pageConfig.getRowCountPerPage(),
									pageConfig.getPageCountPerPage(),
									totalRecordCount, pageConfig.getC_no());
		
		List<Recipe> boardList = recipeDao.findRecipelistByCno(resultBean.getStartRowNum(), resultBean.getEndRowNum(), pageConfig.getC_no());
			
			resultBean.setList(boardList);

			
			return resultBean;
		}
	/*
	 * 14. 종류별 게시물 개수
	 */
	public int countAllByDynamic(int c_no){
		return recipeDao.countAllByDynamic(c_no);
	}
	
	/*
	 * 15. 조회수 10이상 게시물 리스트
	 */
	public List<Recipe> selectAllByCount(){
		return recipeDao.selectAllByCount();
	}
	
}
