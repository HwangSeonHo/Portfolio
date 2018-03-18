package fooddk.controller.tasty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fooddk.domain.Datgle;
import fooddk.domain.Hoogi;
import fooddk.domain.Tasty;
import fooddk.service.datgle.DatgleServiceImpl;
import fooddk.service.hoogi.HoogiServiceImpl;
import fooddk.service.tasty.TastyServiceImpl;

@Controller
public class TastyViewController {
	
	@Autowired
	TastyServiceImpl tastyService;
	
	@Autowired
	DatgleServiceImpl datgleService;
	
	@Autowired
	private HoogiServiceImpl hoogiService;
	
	@RequestMapping(value="/TastyView")
	public String tastyView(@RequestParam int t_no, Model model){
		tastyService.updateCount(t_no);
		Tasty tasty = tastyService.selectByNo(t_no);
		model.addAttribute("tasty",tasty);
		
		int datgleCount = datgleService.selectCount(new Datgle("tasty",t_no));
		model.addAttribute("datgleCount", datgleCount);
		System.out.println("뀨"+tasty.getT_date());
		
		/*location*/
		String location = tasty.getT_location();
		if(location != null){
			String[] locationArr = new String[2];
			locationArr = location.split(",");
			if((locationArr[0] != "" && locationArr[0] != null)||(locationArr[1] != ""&& locationArr[1] != null)){
				model.addAttribute("lat", locationArr[0]);
				model.addAttribute("lng", locationArr[1]);
			}else{
				model.addAttribute("lat", 0);
				model.addAttribute("lng", 0);
			}
		}
		
		/*연관 후기*/
		List<Hoogi> hoogiList = new ArrayList<Hoogi>() ;
		Hoogi hoogi = hoogiService.selectByt_no(t_no);
		if(hoogi != null){
			hoogiList.add(hoogi);
		}
		if(hoogiList.size() < 7){
			System.out.println();
			int size = 7-hoogiList.size();
			List<Hoogi> extraList = hoogiService.findHoogi(0, size);
			for(Hoogi hgi: extraList){
				hoogiList.add(hgi);
			}
		}
		model.addAttribute("hoogiList",hoogiList);

		return "TastyView";
	}
}
