package fooddk.controller.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.service.faq.FaqService;

@Controller
public class FaqRemoveActionController {

	
	@Autowired
	private FaqService faqservice;
	
	@RequestMapping(value="/Faq_Remove_Action",method = RequestMethod.POST)
	public String handleRequest(@RequestParam("f_no") int f_no){
		System.out.println(f_no);
		String forwardPath="";
		
		int faqRemove = faqservice.removeFaq(f_no);
		
		
		//System.out.println("HoogiRemove!!!!!!!!!"+HoogiRemove);
		//model.addAttribute("deletehoogi",HoogiRemove);
		if(faqRemove ==1){
			forwardPath = "redirect:Faq_List";
		}else{
			
			forwardPath="Faq_List";
		}
		
		return forwardPath;
	}
	
}
