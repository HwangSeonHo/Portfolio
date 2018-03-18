package fooddk.controller.member;

import javax.print.attribute.standard.Fidelity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Member;
import fooddk.service.member.MemberServiceImpl;

@Controller
public class MemberFindIdAndPass {

	@Autowired
	MemberServiceImpl memberServiceImpl;
	
	
	@RequestMapping(value = "/member_find_id_pass_form" , method=RequestMethod.GET)
	public String member_find_id_pass_form(){
		
		
		return "member_find_id_pass_form";
		
		
		
		
	}
	@RequestMapping(value = "/member_find_id_action",produces="text/html;charset=UTF-8")
	public @ResponseBody String selectMemberById(@RequestParam String m_name){
		System.out.println("name"+m_name);
		Member findId = memberServiceImpl.selectMemberById(m_name);
		System.out.println(findId);
		
		String msg="";
		
	/*	if(findId==null || findId.equals("")){
		}*/
		if(findId != null){
			msg="찾으신 ID는 "+findId.getM_id()+" 입니다.";
		}else{
			msg="검색한 이름으로 등록된 ID가 없습니다.";
		}
		
		return msg;
		
		
		
		
	}
	@RequestMapping(value = "/member_find_pass_action" , produces="text/html;charset=UTF-8")
	public @ResponseBody String selectMemberByPw(@ModelAttribute Member member){
		
		Member findPw = memberServiceImpl.selectMemberByPw(member);
		
		
		String msg="";
		
		
			if(findPw != null){
				msg="찾으신 Password는 "+findPw.getM_pw()+" 입니다.";
			}else{
				msg="잘못된 정보를 입력하셨습니다 다시 입력해주세요.";
			}
			
			return msg;
		
		
		
		
		
	}

	
	
}
