package fooddk.dao.recipe;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.domain.Recipe;

public class RecipeDaoImplTest {

	public static void main(String[] args) {
		System.out.println("-------application context[bean factory]초기화전------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		System.out.println("-------application context[bean factory]초기화후------");
		
		RecipeDaoImpl recipeDaoImpl = (RecipeDaoImpl)applicationContext.getBean("recipeDao");
		
		System.out.println("1. ----------------selectAll");
		//List<Recipe> recipeList = recipeDaoImpl.selectAll();
		//System.out.println(recipeList.get(0).getR_title());
		
		System.out.println("2. ------------deleteByNo");
		//int deleteCount = recipeDaoImpl.deleteByNo(10);
		//System.out.println("deleteCount : "+deleteCount);

		System.out.println("3. ------------selectImgByNo");
		//String selectImgByNo = recipeDaoImpl.selectImgByNo(11);
		//System.out.println("seletImgByNo : "+selectImgByNo);
		
		System.out.println("4. ----------------selectByCount");
	/*	List<Recipe> recipeorderbycount = recipeDaoImpl.selectByCount();
		System.out.println(recipeorderbycount.size());*/
		
		System.out.println("5. ----------------selectByDate");
		//List<Recipe> recipeorderbydate = recipeDaoImpl.selectByDate();
		//System.out.println("recipeorderbydate : "+recipeorderbydate.get(0).getR_date());

		System.out.println("6. ----------------selectByTitle");
		//List<Recipe> selectByTitle = recipeDaoImpl.selectByTitle("제");
		//System.out.println(selectByTitle.get(0).getR_title());
		
		System.out.println("7. ----------------updateByNo");
		//Recipe recipe = new Recipe(8, "수정88", "수정내용88", "이미지수정88", 1);
		//int updateByNo = recipeDaoImpl.updateByNo(recipe);
		//System.out.println(">>>>>>>>updateByNo : "+updateByNo);
		
		System.out.println("8. ----------------insert");
		//int insert = recipeDaoImpl.insert(new Recipe(-92029, "ddd", 1, "aaaa", "ccccc", 1));
		//System.out.println("insert : "+insert);
		
		System.out.println("9. ----------------updateCount");
		//int updateCount = recipeDaoImpl.updateCount(11);
		//System.out.println("updateCount : "+updateCount);
		
		System.out.println("11.----------------findList");
		//List<Recipe> findRecipeList = recipeDaoImpl.findRecipeList(1);	
		
		System.out.println("12.----------------selectByNo");
		/*Recipe recipe = recipeDaoImpl.selectByNo(32);
		System.out.println(recipe.getR_no());*/
		
		System.out.println("13.----------------countAllByDynamic");
		/*int count = recipeDaoImpl.countAllByDynamic(3);
		System.out.println(count);*/

		System.out.println("14.----------------selectAllByCount");
		List<Recipe> list = recipeDaoImpl.selectAllByCount();
		System.out.println(list.size());
	}	

}
