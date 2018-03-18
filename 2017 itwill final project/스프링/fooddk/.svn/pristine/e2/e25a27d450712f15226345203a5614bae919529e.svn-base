package fooddk.controller.tasty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fooddk.dao.tasty.TastyDao;
import fooddk.domain.Hoogi;
import fooddk.domain.Tasty;
import fooddk.paging.ListPageConfigBean;
import fooddk.paging.ListResultBean_tasty;
import fooddk.paging.PageCounter_tasty;
import fooddk.service.hoogi.HoogiServiceImpl;
import fooddk.service.tasty.TastyServiceImpl;

@SessionAttributes("s_val")
@Controller
public class TastySearchController {
	@Autowired
	TastyServiceImpl tastyService;
	
	@Autowired
	private HoogiServiceImpl hoogiService;
	
	@SuppressWarnings("null")
	@RequestMapping(value="/SearchList")
	public String TastySearch(@RequestParam String s_val,@RequestParam(defaultValue="1") String selectPage, Model model) throws Exception{		
		ListPageConfigBean pageConfig = new ListPageConfigBean(6, 3, selectPage, "a", "a");
		ListResultBean_tasty listResult = tastyService.selectByTitle(s_val,pageConfig);

		/**
		 * 나중에 검색결과가 없을 때 페이지 만들기
		 */
		List<Hoogi> hoogiList = new ArrayList<Hoogi>() ;
		List<Hoogi> extraList = hoogiService.findHoogi(0, 7);
		for(Hoogi hoogi: extraList){
			hoogiList.add(hoogi);
		}
		

		model.addAttribute("hoogiList", hoogiList);
		model.addAttribute("ListPage", listResult);
		model.addAttribute("s_val",s_val);
		return "TastySearchList";
	}
}
