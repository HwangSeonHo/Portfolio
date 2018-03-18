package fooddk.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fooddk.domain.Member;
import fooddk.service.member.MemberServiceImpl;


@SessionAttributes("sId")
@Controller
public class MemberUpdateFormActionController {

	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	
	@RequestMapping(value = "member_modify_form",method=RequestMethod.POST)
	public String MemberUpdateform(@ModelAttribute("sId") String sId, Model model){
		Member selectMember = memberServiceImpl.selectMemberCheckId(sId);
		System.out.println(selectMember);
		Member updateMember = memberServiceImpl.selectMemberMyInfo(selectMember);
		System.out.println(updateMember);
		model.addAttribute("member", updateMember);
		return "member_update_form";
		
		
	}
	@RequestMapping(value = "member_modify_action",method=RequestMethod.POST)
	public String MemberUpdateAction(@ModelAttribute Member member){
		
		String forwardPath = "";
		
		memberServiceImpl.updateMember(member);
		
		forwardPath = "forward:member_view";
		return forwardPath;
				
		
	}
	@RequestMapping(value = "member_modify_action2",method=RequestMethod.POST)
	public String MemberUpdateAction2(@ModelAttribute Member member){
		
		System.out.println("modifyaction2"+member);
		String forwardPath = "";
		
		memberServiceImpl.updateManagerByno(member);
		
		forwardPath = "redirect:member_view1?m_id="+member.getM_id();
		return forwardPath;
		
		
	}
	
	
}
