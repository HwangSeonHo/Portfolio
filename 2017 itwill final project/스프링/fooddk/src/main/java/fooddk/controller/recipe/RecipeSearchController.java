package fooddk.controller.recipe;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.domain.Recipe;
import fooddk.service.recipe.RecipeServiceImpl;

@Controller
public class RecipeSearchController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	public RecipeSearchController() {
		System.out.println("RecipeSearchController()생성자");
	}
	@RequestMapping(value="/recipe_search_list")
	public String recipe_search(Model model, HttpServletRequest request){
		String r_title = request.getParameter("r_title");
		List<Recipe> searchList = recipeServiceImpl.selectByTitle(r_title);
		model.addAttribute("searchList", searchList);
		return "recipe_search_list";
	}
}
