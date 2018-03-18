package fooddk.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Member;
import fooddk.service.member.MemberService;
import fooddk.service.member.MemberServiceImpl;

@Controller
public class MemberWriteFormActionController {

	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/member_write_form" , method=RequestMethod.GET)
	public String memberInsertForm(){
		
		
		return "member_write_form";
		
		
		
		
	}
	@RequestMapping(value ="/member_write_action ", method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String memberInsertAction(@ModelAttribute Member member){
		
		String forwardPath = "";
		
		System.out.println(member);
		memberService.insertMember(member);
		
		forwardPath = "forward:member_main";
		return  forwardPath;
		
		
	}
	
	@RequestMapping("/member_id_check")
	public @ResponseBody String memberCheckAction(@RequestParam String m_id,Model model){
		
		String data = "";
		boolean result = memberService.selectMemberIDCheck(m_id);
		if(result == true){
			data = "true";
		}else{
			data = "false";
		}
		
//		model.addAttribute("data" , data);
		return data;
		
		
	}
	
	
	
	
}
