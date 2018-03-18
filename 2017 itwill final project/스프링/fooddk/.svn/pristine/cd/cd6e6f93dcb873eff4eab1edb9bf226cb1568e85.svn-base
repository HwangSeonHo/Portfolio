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
public class FaqModifyController {
	@Autowired
	private FaqService faqService;
	
	@Autowired
	private MemberService memberservice;
	
    // @RequestMapping("/Faq_Write_form")
    // value="", method="전송방식"   	
	@RequestMapping(value = "/Faq_Modify_form" , method=RequestMethod.GET)
	public String Faq_Modify_form(Model model, int f_no){
		
		Faq faq = faqService.selectFaq(f_no);
		model.addAttribute("faq",faq);
		
		return "Faq_Modify_form";
	}
	
	@RequestMapping(value ="/Faq_Modify_Action ",  method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String Faq_Modify_Action(@ModelAttribute Faq faq, @ModelAttribute("sId") String sId){
		
		System.out.println("번호"+faq.getF_no());
		System.out.println("제목"+faq.getF_title());
		System.out.println("내용"+faq.getF_content());
		
		String forwardPath = "";
		faq.setM_no(memberservice.selectMemberCheckId(sId).getM_no());
		//faq.setM_no(memberservice.selectMemberCheckId(sId).getM_no());
		//int m_no = member.getM_no();
		
		//System.out.println(faq);
		faqService.modifyFaq(faq);
		
		
		/*System.out.println("삽입");
		Faq faq1 = new Faq(12, "이종화", 1, "조장");
		int fd = faqService.modifyFaq(faq1);
		System.out.println("수정완료= "+fd);
		System.out.println("끝");*/
		
		forwardPath = "forward:Faq_List";
		return  forwardPath;
		
		
	}
	
	
}
