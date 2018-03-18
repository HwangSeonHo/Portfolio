package fooddk.controller.datgle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Datgle;
import fooddk.service.datgle.DatgleService;

@Controller
public class DatgleDeleteController {

	@Autowired
	DatgleService datgleService;
	
	@RequestMapping("/datgleDelete")
	public @ResponseBody String datgleDelete(Datgle datgle){
		
		int deleteCount = datgleService.deleteByNo(datgle.getD_no());
		if(deleteCount == 1){
			return "true";
		}
		
		return "false";
	}
	
}
