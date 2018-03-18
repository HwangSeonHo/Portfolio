package fooddk.controller.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.domain.Developer;
import fooddk.service.developer.DeveloperService;

@Controller
public class DeveloperController {
 
 
	@Autowired
	private DeveloperService developerService;
	
	
   public DeveloperController() {
      // TODO Auto-generated constructor stub
	   System.out.println("아두이노짜징맨");
   }
   
   @RequestMapping(value="/developer")
   public String button(Model model, @ModelAttribute Developer developer) throws Exception{
      
	   List<Developer> developerList = developerService.All();
      
		for(Developer developer1: developerList){
			System.out.println("디벨로퍼"+developerList);				
		}
		
	System.out.println("5555%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%끝");
	
	model.addAttribute("DList", developerList);
      
      return "developer";
      
   }

   @RequestMapping(value="/developer_view")
   public String developer(Model model, @ModelAttribute Developer developer, @RequestParam int developer_no) throws Exception{
	   
	   Developer sd1 = developerService.selectByNo(developer_no);
	   Developer sd2 = developerService.selectByNo(2);
	   Developer sd3 = developerService.selectByNo(3);
	   
		
	System.out.println("5555%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%끝");
	
	model.addAttribute("sd1", sd1);
	model.addAttribute("sd", sd2);
	model.addAttribute("sd", sd3);
	
	   return "developer_view";
	   
   }
}