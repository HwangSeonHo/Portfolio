package fooddk.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fooddk.domain.Grade;
import fooddk.domain.Member;
import fooddk.service.category.CategoryService;
import fooddk.service.grade.GradeService;
import fooddk.service.grade.GradeServiceImpl;
import fooddk.service.member.MemberService;
import fooddk.service.member.MemberServiceImpl;

@SessionAttributes("sId")
@Controller
public class MemberViewController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private CategoryService categoryService; 
	
	@RequestMapping("/member_view")
	public String member_view(@ModelAttribute("sId") String sId , Model model){
		String forwardPath = "";
		
		if(sId != null){
		Member selectMember = memberService.selectMemberCheckId(sId);
			System.out.println(selectMember);
		
		String grade = gradeService.selectGradeOne(selectMember.getG_no()).getG_grade();
		String kind = categoryService.selectCategoryNumber(selectMember.getC_no()).getC_kind();
		model.addAttribute("member", selectMember);
		model.addAttribute("grade",grade);
		model.addAttribute("ckind",kind);
		
		forwardPath ="member_view";
		}else{
			forwardPath = "myaccount";
		}
		
		
		return forwardPath;
		
	}
	@RequestMapping("/member_view1")
	public String member_view1(@RequestParam String m_id , Model model){
		String forwardPath = "";
		System.out.println("ASdasddda" +m_id);
		if(m_id != null){
			Member selectMember = memberService.selectMemberCheckId(m_id);
			System.out.println(selectMember);
			
			String grade = gradeService.selectGradeOne(selectMember.getG_no()).getG_grade();
			String kind = categoryService.selectCategoryNumber(selectMember.getC_no()).getC_kind();
			int manage = selectMember.getM_manager();
			
			if(manage == 2){
				model.addAttribute("manager", "운영자");
				
			}else if(manage == 1){
				model.addAttribute("manager", "매니저");
			}else{
				model.addAttribute("manager", "일반회원");
				
			}
			model.addAttribute("member", selectMember);
			model.addAttribute("grade",grade);
			model.addAttribute("ckind",kind);
			
			forwardPath ="member_view2";
		}else{
			forwardPath = "myaccount";
		}
		
		
		return forwardPath;
		
	}
	
	
}
