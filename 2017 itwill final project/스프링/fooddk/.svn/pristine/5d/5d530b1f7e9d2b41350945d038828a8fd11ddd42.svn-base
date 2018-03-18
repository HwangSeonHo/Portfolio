package fooddk.controller.faq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import fooddk.domain.Faq;
import fooddk.domain.Member;
import fooddk.service.faq.FaqService;

@Controller
public class FaqListController {
	@Autowired
	private FaqService faqService;
	
	public FaqListController() {
		// TODO Auto-generated constructor stub
		System.out.println("FaqListController()생성자1");
	}
	
	@RequestMapping(value="/Faq_List")
	public String Faq_List(Model model ,@ModelAttribute Faq faq ,@ModelAttribute Member member) throws Exception{
		String forwardPath="";
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%시작");
		
		List<Faq> FaqList = faqService.selectAllFaq();
		
		//System.out.println("뀨"+Listresort.getList());
		
			for(Faq faqa: FaqList){
				System.out.println("faqlistGGGGGG"+FaqList);				
			}
			
		System.out.println("5555%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%끝");
		model.addAttribute("sId", member.getM_id());
		model.addAttribute("FaqList", FaqList);
		//model.addAttribute("c_no", c_no);
		forwardPath="Faq_List";
		
		return forwardPath;
		
	}
}
