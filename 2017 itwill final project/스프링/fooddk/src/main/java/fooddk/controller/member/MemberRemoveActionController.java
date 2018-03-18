package fooddk.controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.dao.member.PasswordNotFoundException;
import fooddk.domain.Member;
import fooddk.service.member.MemberServiceImpl;

@Controller
public class MemberRemoveActionController {

	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	
	@RequestMapping("member_remove_action")
	public String memberRemoveAction(Model model ,HttpSession session, @ModelAttribute Member member){
		String forwardPath = "";
		
		String msg;
		try {
			msg = memberServiceImpl.deleteMember(member);
			
		} catch (PasswordNotFoundException e) {
			 
			model.addAttribute("MSG", e.getMessage());
			return "forward:member_view";
		}
		
		
		
		session.invalidate();
		return forwardPath = "index"; 
		
	}
	
	@RequestMapping("member_remove_action2")
	public String memberRemoveAction2(Model model ,HttpSession session, @ModelAttribute Member member){
		String forwardPath = "";
		
		String msg;
		try {
			msg = memberServiceImpl.deleteMember(member);
			
		} catch (PasswordNotFoundException e) {
			
			model.addAttribute("MSG", e.getMessage());
			return "forward:member_view";
		}
		
		
		
		return forwardPath = "redirect:member_list"; 
		
	}
	
	
	
	
}
