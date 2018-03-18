package fooddk.dao.recipe;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import fooddk.domain.Recipe;
import fooddk.paging.ListResultBean_filter;
import fooddk.paging.ListResultBean_recipe;

public class RecipeDaoImpl implements RecipeDao{
	private SqlSession sqlSession;
	private static final String namespace = "Recipe.mapper.RecipeMapper.";
	
	public RecipeDaoImpl() {
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/*
	 * 1. 게시글 생성하기
	 */
	@Override
	public int insert(Recipe recipe) {
		return sqlSession.insert(namespace+"insert", recipe);
	}
	/*
	 * 2. 게시글 삭제하기
	 */
	@Override
	public int deleteByNo(int r_no) {
		return sqlSession.delete(namespace+"deleteByNo", r_no);
	}
	/*
	 * 3.  게시글 수정하기
	 */
	@Override
	public int updateByNo(Recipe recipe) {
		return sqlSession.update(namespace+"updateByNo", recipe);
	}
	/*
	 * 4. 게시글 전체리스트 보기
	 */
	@Override
	public List<Recipe> selectAll() {
		return sqlSession.selectList(namespace+"selectAll");
	}
	/*
	 * 5. 이미지 선택하기
	 */
	@Override
	public String selectImgByNo(int r_no) {
		
		return sqlSession.selectOne(namespace+"selectImgByNo", r_no);
	}
	/*
	 * 6. 조회수로 오름차순 정렬 
	 */
	@Override
	public List<Recipe> selectByCount() {
	
		return sqlSession.selectList(namespace+"selectByCount");
	}
	/*
	 * 7. 날짜순으로 오름차순 정렬
	 */
	@Override
	public List<Recipe> selectByDate() {
		
		return sqlSession.selectList(namespace+"selectByDate");
	}
	/*
	 * 8. 게시글 제목으로 검색하기
	 */
	@Override
	public List<Recipe> selectByTitle(String r_title) {
		
		return sqlSession.selectList(namespace+"selectByTitle", r_title);
	}
	/*
	 * 9. 조회수 증가하기
	 */
	@Override
	public int updateCount(int r_no) {
		
		return sqlSession.update(namespace+"updateCount", r_no);
	}
	/*
	 * 10. 전체 게시물 개수
	 */
	@Override
	public int countAll() {
		return sqlSession.selectOne(namespace+"countAll");
	}
	/*
	 * 11. 선택한 게시물 개수 리스트 가져오기
	 */
	/*@Override
	public List<Recipe> findRecipeList(int start, int last) {
		ListResultBean_filter resultBean = new ListResultBean_filter();
		resultBean.setStartRowNum(start);
		resultBean.setEndRowNum(last);
		return sqlSession.selectList(namespace+"findRecipeList", resultBean);
	}*/
	/*
	 * 12. 번호로 검색하기
	 */
	@Override
	public Recipe selectByNo(int r_no) {
		return sqlSession.selectOne(namespace+"selectByNo", r_no);
	}
	/*
	 * 13. 종류별 총 게시물 개수
	 * 
	 */
	@Override
	public int countAllByDynamic(int c_no) {
		return sqlSession.selectOne(namespace+"countAllByDynamic", c_no);
	}
	/*
	 * 14. 선택한 종류별 게시물 가져오기
	 */
	@Override
	public List<Recipe> findRecipelistByCno(int start, int last, int c_no) {
		ListResultBean_recipe resultBean = new ListResultBean_recipe();
		resultBean.setStartRowNum(start);
		resultBean.setEndRowNum(last);
		resultBean.setC_no(c_no);
		System.out.println(">>>>>>>>>>"+resultBean.getC_no());
		return sqlSession.selectList(namespace+"findRecipeByDynamic", resultBean);
	}
	
	/*
	 * 	15. 조회수 10이상인 리스트 가져오기
	 */
	@Override
	public List<Recipe> selectAllByCount() {
		
		return sqlSession.selectList(namespace+"selectAllByCount");
	}
	
	
	

}
