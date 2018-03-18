package fooddk.controller.hoogi;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fooddk.domain.Hoogi;
import fooddk.domain.Member;
import fooddk.domain.Tasty;
import fooddk.service.hoogi.HoogiService;
import fooddk.service.member.MemberService;
import fooddk.service.recipe.RecipeServiceImpl;
import fooddk.service.tasty.TastyService;

@SessionAttributes("sId")
@Controller
public class HoogiViewController {

	@Autowired
	private HoogiService hoogiservice;
	
	@Autowired
	private TastyService tastyservice;
	
	@Autowired
	private RecipeServiceImpl recipeserviceimpl;
	
	@Autowired
	private MemberService memberservice;
	

	
	@RequestMapping(value="/HoogiView_1")
	public String handleRequest(@ModelAttribute Hoogi hoogi, Model model, @RequestParam int h_no, @ModelAttribute("sId") String sId){
		String forwardPath="";
		
			
		
		//이 h_no가 댓글의 groupno가 됨
		System.out.println(h_no);
			
		System.out.println("로그인 한 사람" +sId);
		//session값 꺼내기

		
		//클릭 시 다음으로 넘어가는 값 넘겨주기 (후기 번호 받아서 뷰 연결)
		Hoogi hoogiview = hoogiservice.selectByNo(h_no);
		model.addAttribute("hoogi",hoogiview);
		
		
		
		//글쓴이 받아오기  --> 널 값떠러 보류  : 문제해결함
		Member name=memberservice.selectMemberMyNo(hoogiview.getM_no());
		model.addAttribute("name",name);
		System.out.println("글 쓴 사람"+name);
	
		
		//클릭 시 계속해서 조회 수 오르는거 업데이트함
		int hoogicount = hoogiservice.updateByCountNo(h_no);
		
		
		//레시피 동적 뽑아오기 (하나하나 다 뽑아와야함)
				int recipecount1 = recipeserviceimpl.countAllByDynamic(1);
				int recipecount2 = recipeserviceimpl.countAllByDynamic(2);
				int recipecount3 = recipeserviceimpl.countAllByDynamic(3);
				int recipecount4 = recipeserviceimpl.countAllByDynamic(4);
				int recipecount5 = recipeserviceimpl.countAllByDynamic(5);
				
				
		model.addAttribute("hoogicount",hoogicount);
		//맛집 리스트 뽑아오기
				List<Tasty> tastyList = tastyservice.selectAll();

		
		//맛집 리스트 보여주기
		model.addAttribute("tastyList",tastyList);
		
	/*	//세션 아이디 받기
		Member memberName= memberservice.selectMemberMyInfo();
		*/
		//카운트뽑아오기
		model.addAttribute("recipecount1",recipecount1);
		model.addAttribute("recipecount2",recipecount2);
		model.addAttribute("recipecount3",recipecount3);
		model.addAttribute("recipecount4",recipecount4);
		model.addAttribute("recipecount5",recipecount5);
	
		//사진경로 뽑아오기
		
		forwardPath="HoogiView_1";
		
		return forwardPath;
		
	}
	
}
