package fooddk.controller.hoogi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Hoogi;
import fooddk.service.hoogi.HoogiService;

@Controller
public class HoogiTitleJsonController {

	@Autowired
	private HoogiService hoogiservice;
	
	
	public HoogiTitleJsonController(){
		System.out.println("HoogiTitleJsonConroller 생성자");
	}
	//responseBody는 JSON이나 XML 데이터를 맵핑할 때 사용하기 적합
	//POST바익으로 전달된 Http 요청 데이터의 body를 통으로 읽어오게함
	@RequestMapping(value="/Hoogi_title_json")
	public  @ResponseBody Map  HoogiTitleJson(@RequestParam String h_title){
		List<Hoogi> hoogititlelist = hoogiservice.selectByTitle(h_title);
		
		//맵에 맵을 해쉬맵해주어야함
		Map map = new HashMap<Object, Object>();
		
		for(int i=0; i <hoogititlelist.size();i++){
			Map map_map = new HashMap<Object, Object>();
			
			map_map.put("h_title",hoogititlelist.get(i).getH_title());
			map_map.put("h_no", hoogititlelist.get(i).getH_no());
			map.put(i, map_map);
			
		}
		return map;
	}
}
