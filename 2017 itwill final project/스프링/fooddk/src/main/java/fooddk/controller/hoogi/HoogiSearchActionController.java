package fooddk.controller.hoogi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.domain.Hoogi;
import fooddk.domain.Tasty;
import fooddk.service.hoogi.HoogiService;
import fooddk.service.recipe.RecipeServiceImpl;
import fooddk.service.tasty.TastyService;

@Controller
public class HoogiSearchActionController {

	
	@Autowired
	private HoogiService hoogiservice;
	
	@Autowired
	private TastyService tastyservice;
	
	@Autowired
	private RecipeServiceImpl recipeserviceimpl;
	
	@RequestMapping(value="/HoogiList_search",method = RequestMethod.POST)
	public String handleRequest(@ModelAttribute Hoogi hoogi, Model model, @RequestParam String h_title){
		String forwardPath="";
		//검색하는 후기리스트 뽑아오기
		List<Hoogi> hoogiListTitle = hoogiservice.selectByTitle(h_title);
		
		//맛집리스트를 불러오기 위한
		List<Tasty> tastyList = tastyservice.selectAll();
		
		//레시피 동적 뽑아오기 (하나하나 다 뽑아와야함)
				int recipecount1 = recipeserviceimpl.countAllByDynamic(1);
				int recipecount2 = recipeserviceimpl.countAllByDynamic(2);
				int recipecount3 = recipeserviceimpl.countAllByDynamic(3);
				int recipecount4 = recipeserviceimpl.countAllByDynamic(4);
				int recipecount5 = recipeserviceimpl.countAllByDynamic(5);
			
		
		//jsp로 보낼 어튜리뷰트 이름저장
		model.addAttribute("hoogiListTitle",hoogiListTitle);
		
		
		model.addAttribute("tastyList",tastyList);
		
		//카운트뽑아오기
				model.addAttribute("recipecount1",recipecount1);
				model.addAttribute("recipecount2",recipecount2);
				model.addAttribute("recipecount3",recipecount3);
				model.addAttribute("recipecount4",recipecount4);
				model.addAttribute("recipecount5",recipecount5);
			
				
		
		forwardPath="HoogiList_search";
		return forwardPath;
		
	}
	
	
	
	
}
