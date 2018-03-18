package fooddk.controller.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import fooddk.domain.Member;
import fooddk.domain.Recipe;
import fooddk.service.member.MemberService;
import fooddk.service.member.MemberServiceImpl;

import fooddk.service.recipe.RecipeServiceImpl;
@SessionAttributes("sId")
@Controller
public class RecipeViewController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	@Autowired
	private MemberService memberService;
	
	public RecipeViewController() {
		System.out.println("RecipeViewController()생성자!!!");
	}
	@RequestMapping(value="/recipe_detail")
	public String recipe_view(@ModelAttribute Recipe recipe, Model model, @ModelAttribute("sId") String sId){
		String forwardPath="";
		int r_count = recipeServiceImpl.updateCount(recipe.getR_no());
		Recipe recipe1 = recipeServiceImpl.selectByNo(recipe.getR_no());
		model.addAttribute("recipe", recipe1);
		Member member = memberService.selectMemberMyNo(recipe1.getM_no());
		String m_name = member.getM_name();
		String m_id = member.getM_id();
		int m_point = member.getM_point();
		model.addAttribute("m_name", m_name);
		model.addAttribute("m_id", m_id);
		model.addAttribute("m_point", m_point);
		
	
		List<Recipe> listByCount = recipeServiceImpl.selectAllByCount();
		model.addAttribute("listByCount",listByCount);
		
		forwardPath="recipe_detail";
		return forwardPath; 
		
	}
}
