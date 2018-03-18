package fooddk.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListResultBean_hoogi;
import fooddk.paging.ListResultBean_tasty;
import fooddk.service.hoogi.HoogiServiceImpl;
import fooddk.service.member.MemberServiceImpl;
import fooddk.service.recipe.RecipeServiceImpl;
import fooddk.service.tasty.TastyServiceImpl;

@Controller
public class MemberMainController {

	MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
	
	@Autowired
	private TastyServiceImpl tastyService;
		
	@Autowired
	private HoogiServiceImpl hoogiService;
	
	@Autowired
	private RecipeServiceImpl recipeService;
	
	@RequestMapping(value="/member_main")
	public String tastyList_count(Model model,@RequestParam(defaultValue="1") String selectPage) throws Exception{
		ListPageConfigBean pageConfig = new ListPageConfigBean(6, 3, selectPage, "a", "a");
		ListPageConfigBean pageConfig1 = new ListPageConfigBean(6, 3, selectPage, "a", "a");
		ListResultBean_tasty listResult = tastyService.selectCount(pageConfig);
		ListResultBean_hoogi listResult1 = hoogiService.selectDate(pageConfig1);

		
		
		model.addAttribute("ListPage", listResult);
		model.addAttribute("ListPage1", listResult1);
		
		return "index";
	}
}
