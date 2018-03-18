package fooddk.controller.recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Recipe;
import fooddk.service.recipe.RecipeServiceImpl;

@Controller
public class RecipeTitleJsonController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	public RecipeTitleJsonController() {
		System.out.println("RecipeTitleJsonController생성자");
	}
	@RequestMapping(value="/recipe_title_json")
	public @ResponseBody Map recipeTitleJson(@RequestParam String r_title){
		List<Recipe> recipeTitleList = recipeServiceImpl.selectByTitle(r_title);
		Map map = new HashMap<Object, Object>();
		
		for(int i=0; i<recipeTitleList.size();i++){
			Map map_map = new HashMap<Object, Object>();
			map_map.put("r_title", recipeTitleList.get(i).getR_title());
			map_map.put("r_no", recipeTitleList.get(i).getR_no());
			map.put(i, map_map);
		}
		return map;
	}
}
