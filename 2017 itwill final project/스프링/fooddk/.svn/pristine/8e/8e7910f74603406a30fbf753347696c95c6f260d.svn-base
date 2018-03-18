package fooddk.controller.datgle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fooddk.domain.Datgle;
import fooddk.domain.Hoogi;
import fooddk.service.datgle.DatgleService;
import fooddk.service.hoogi.HoogiService;
import fooddk.service.member.MemberService;

@SessionAttributes("sId")
@Controller
public class DatgleInsertController {

	@Autowired
	DatgleService datgleService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/datgleInsert")
	public @ResponseBody String datgleInsert(@ModelAttribute Datgle datgle, @ModelAttribute("sId") String sId){
		
		datgle.setM_no(memberService.selectMemberCheckId(sId).getM_no());
		
		int insertCount = datgleService.insert(datgle);
		if(insertCount == 1){
			return "true";
		}
		
		return "false";
	}
	
}
