package fooddk.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fooddk.domain.Member;
import fooddk.service.member.MemberServiceImpl;

@Controller
public class MemberListController {

	@Autowired
	private MemberServiceImpl memberServiceImpl;
	
	
	public MemberListController() {
		System.out.println("####MemberListController()생성자");
	}

	@RequestMapping("/member_list")
	public String member_list(Model model){
		
		String forwardPath ="";
		
		List<Member> memberList = memberServiceImpl.selectMemberAll();
		
		model.addAttribute("memberList", memberList);
		String manager= "";
		for (Member member : memberList) {
			if (member.getM_manager() == 2) {
				manager = "운영자";
				model.addAttribute("manager1", manager);
			}else if(member.getM_manager() == 1){
				manager = "매니저";
				model.addAttribute("manager2", manager);
			}else{
				manager = "일반회원";
				model.addAttribute("manager3", manager);
				
			}
		}
		
		forwardPath ="member_list";
		
		return forwardPath;
		
	}
	
	
	
}




