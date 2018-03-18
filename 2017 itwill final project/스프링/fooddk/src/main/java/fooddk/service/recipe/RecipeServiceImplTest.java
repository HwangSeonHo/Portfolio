package fooddk.service.recipe;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fooddk.dao.recipe.RecipeDao;
import fooddk.dao.recipe.RecipeDaoImpl;
import fooddk.domain.Recipe;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListPageConfigBean_recipe;
import fooddk.paging.ListResultBean;
import fooddk.paging.ListResultBean_recipe;

public class RecipeServiceImplTest {

	public static void main(String[] args) throws Exception {
		System.out.println("-------application context[bean factory]초기화전------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-config.xml");
		System.out.println("-------application context[bean factory]초기화후------");
		
		RecipeServiceImpl recipeServiceImpl = (RecipeServiceImpl)applicationContext.getBean("recipeService");
		/*ListPageConfigBean config = new ListPageConfigBean(10, 3, "1", "a", "b");
		
		System.out.println("1. findRecipeList");
		ListResultBean findRecipeList = recipeServiceImpl.selectList(config);
		for (Recipe find : findRecipeList.getList()) {
			System.out.println(find.getR_no());
			System.out.println(find.getR_title());
			System.out.println(find.getR_content());
		}
*/
	/*ListPageConfigBean_recipe config = new ListPageConfigBean_recipe(10, 3, "1", "a", "b", 3);
			
			System.out.println("1. findRecipeList");
			ListResultBean_recipe findRecipeListByCno = recipeServiceImpl.selectListByCno(config);
			for (Recipe find : findRecipeListByCno.getList()) {
				System.out.println(find.getR_no());
				System.out.println(find.getR_title());
				System.out.println(find.getR_content());
				System.out.println(find.getC_no());
			}*/
			int count = recipeServiceImpl.countAllByDynamic(5);
			System.out.println(">>>>>"+count);
		
	}

}
