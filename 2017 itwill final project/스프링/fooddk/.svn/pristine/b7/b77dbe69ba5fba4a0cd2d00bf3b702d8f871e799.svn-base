package fooddk.controller.hoogi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.domain.Hoogi;
import fooddk.service.hoogi.HoogiService;

@Controller
public class HoogiRemoveActionController {

	
	@Autowired
	private HoogiService hoogiservice;
	
	@RequestMapping(value="/HoogiRemoveAction",method = RequestMethod.POST)
	public String handleRequest(@RequestParam("h_no") int h_no){
		System.out.println(h_no);
		String forwardPath="";
		
		int HoogiRemove = hoogiservice.deleteByNo(h_no);
		
		
		//System.out.println("HoogiRemove!!!!!!!!!"+HoogiRemove);
		//model.addAttribute("deletehoogi",HoogiRemove);
		if(HoogiRemove ==1){
			forwardPath = "redirect:HoogiList_1";
		}else{
			
			forwardPath="HoogiList_1";
		}
		
		return forwardPath;
	}
	
}
