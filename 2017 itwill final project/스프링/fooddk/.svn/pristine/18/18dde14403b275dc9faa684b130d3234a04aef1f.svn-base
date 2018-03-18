package fooddk.controller.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.domain.Recipe;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListPageConfigBean_recipe;
import fooddk.paging.ListResultBean;
import fooddk.paging.ListResultBean_recipe;
import fooddk.service.recipe.RecipeServiceImpl;

@Controller
public class RecipeListController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	public RecipeListController() {
		System.out.println("RecipeListController()생성자!!");
	}
	
	@RequestMapping(value="/recipe_list")
	public String recipe_list(Model model, @RequestParam(defaultValue="1") String selectPage, int c_no) throws Exception{
		String forwardPath="";
		
		ListPageConfigBean_recipe pageConfig = new ListPageConfigBean_recipe(6, 3, selectPage, "a", "b", c_no);
	
		ListResultBean_recipe listResultBean =  recipeServiceImpl.selectListByCno(pageConfig);
		
	
		model.addAttribute("listResultBean", listResultBean);
		model.addAttribute("c_no", c_no);
		forwardPath="recipe_list_all";
		
		return forwardPath;
		
	}
	
}
