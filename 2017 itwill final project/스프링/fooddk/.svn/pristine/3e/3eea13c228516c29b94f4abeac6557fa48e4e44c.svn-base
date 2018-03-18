package fooddk.controller.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import fooddk.domain.Faq;
import fooddk.domain.Member;
import fooddk.service.faq.FaqService;
import fooddk.service.member.MemberService;
@SessionAttributes("sId")
@Controller
public class FaqWriteController {
	@Autowired
	private FaqService faqService;
	
	@Autowired
	private MemberService memberservice;
	
    // @RequestMapping("/Faq_Write_form")
    // value="", method="전송방식"   	
	@RequestMapping(value = "/Faq_Write_form" , method=RequestMethod.GET)
	public String Faq_Write_form(Model model){
		
		
		return "Faq_Write_form";
	}
	
	@RequestMapping(value ="/Faq_Write_Action ", method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String Faq_Write_Action(@ModelAttribute Faq faq, @ModelAttribute("sId") String sId){
		
		
		String forwardPath = "";
		
		faq.setM_no(memberservice.selectMemberCheckId(sId).getM_no());
		//int m_no = member.getM_no();
		
		System.out.println(faq);
		faqService.writeFaq(faq);
		
		/*System.out.println("삽입");
		Faq faq1 = new Faq(7, "이종화", 1, "조장", 0);
		int fd = faqService.writeFaq(faq1);
		System.out.println("삽입완료= "+fd);
		System.out.println("끝");*/
		
		forwardPath = "forward:Faq_List";
		return  forwardPath;
		
		
	}
	
	
}
