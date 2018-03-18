package fooddk.controller.datgle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Datgle;
import fooddk.service.datgle.DatgleService;

@Controller
public class DatgleUpdateController {

	@Autowired
	DatgleService datgleService;
	
	@RequestMapping("/datgleUpdate")
	public @ResponseBody String datgleUpdate(Datgle datgle){
		
		int updateCount = datgleService.updateByNo(datgle);
		if(updateCount == 1){
			return "true";
		}
		
		return "false";
	}
	
}
