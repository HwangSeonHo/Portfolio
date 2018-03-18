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
import fooddk.paging.ListResultBean;

import fooddk.service.recipe.RecipeServiceImpl;

@Controller
public class RecipeMainController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	public RecipeMainController() {
		// TODO Auto-generated constructor stub
	}
	
	/*@RequestMapping(value="/recipe_main")
	public String recipe_list(Model model, @RequestParam(defaultValue="1") String selectPage) throws Exception{
		String forwardPath="";
		
	
		ListPageConfigBean pageConfig = new ListPageConfigBean(6, 5, selectPage, "a", "b");
	
		ListResultBean listResultBean =  recipeServiceImpl.selectList(pageConfig);
		
		model.addAttribute("listResultBean", listResultBean);
		forwardPath="recipe_list_all";
		
		return forwardPath;
		
	}*/
	/*@RequestMapping(value="/recipe_orderbycount")
	public String order_by_count_list(Model model) throws Exception{
		String forwardPath="";
		
		List<Recipe> orderyByCount = recipeServiceImpl.selectByCount();
		
		model.addAttribute("orderByCount", orderyByCount);
		forwardPath="r_order_by_count";
		return forwardPath;
	}*/
}
