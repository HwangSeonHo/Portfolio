package fooddk.controller.tasty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Tasty;
import fooddk.service.tasty.TastyServiceImpl;

@Controller
public class TastyRemoveController {
	
	@Autowired
	TastyServiceImpl tastyService;

	@RequestMapping("/TastyRemoveAction")
	public String tastyRemove(@RequestParam int t_no){
		String forwardPath = "";
		int isSuccess = tastyService.deleteByNo(t_no);
		if(isSuccess == 1){
			forwardPath = "forward:TastyList";
		}else{
			forwardPath = "forward:TastyView";
		}
		return forwardPath;
	}
	
	@RequestMapping("/a_TastyRemove")
	public @ResponseBody int a_TastyRemove(int t_no){
		return tastyService.deleteByNo(t_no);
	}
}
