package fooddk.controller.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fooddk.service.recipe.RecipeServiceImpl;

@Controller
public class RecipeRemoveController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	public RecipeRemoveController() {
		System.out.println("RecipeRemoveController()생성자!!!");
	}
	@RequestMapping(value="/recipe_remove_action", method=RequestMethod.POST)
	public String recipe_remove(@RequestParam int r_no){
		String forwardPath="";
		int rowCount = recipeServiceImpl.deleteByNo(r_no);
		if(rowCount==1){
			forwardPath="redirect:recipe_list?c_no="+0;
		}else{
			forwardPath="recipe_error";
		}
		return forwardPath;
	}
}
