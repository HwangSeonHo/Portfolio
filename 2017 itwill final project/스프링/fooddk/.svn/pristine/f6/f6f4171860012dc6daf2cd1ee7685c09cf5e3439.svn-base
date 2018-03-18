package fooddk.controller.datgle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Datgle;
import fooddk.paging.ListPageConfigBean_filter;
import fooddk.service.datgle.DatgleService;
import fooddk.service.member.MemberService;

@Controller
public class DatgleListJsontController {

	@Autowired
	DatgleService datgleService;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/datgleListJson")
	public @ResponseBody Map datgleListJson(@ModelAttribute ListPageConfigBean_filter config) throws Exception{

		List<Datgle> list = datgleService.selectList(config).getList();
	
		Map<Integer,Map> map = new HashMap<Integer,Map>();
		for (int i=0;i<list.size();i++) {
			Map<String,Object> map_map = new HashMap<String,Object>();
			map_map.put("d_no",list.get(i).getD_no());
			map_map.put("d_content",list.get(i).getD_content());
			map_map.put("d_date",list.get(i).getD_date());
			map_map.put("m_name",memberService.selectMemberMyNo(list.get(i).getM_no()).getM_name());	
			map_map.put("m_id",memberService.selectMemberMyNo(list.get(i).getM_no()).getM_id());	
			map.put(i, map_map);
		}
		
		Map<String,Object> map_map = new HashMap<String,Object>();
		map_map.put("isShowFirst", datgleService.selectList(config).isShowFirst());
		map_map.put("isShowPreviousGroup", datgleService.selectList(config).isShowPreviousGroup());
		map_map.put("PreviousGroupStartPageNo", datgleService.selectList(config).getPreviousGroupStartPageNo());
		map_map.put("StartPageNo", datgleService.selectList(config).getStartPageNo());
		map_map.put("EndPageNo", datgleService.selectList(config).getEndPageNo());
		map_map.put("SelectPageNo", datgleService.selectList(config).getSelectPageNo());
		map_map.put("isShowNext", datgleService.selectList(config).isShowNext());
		map_map.put("isShowNextGroup", datgleService.selectList(config).isShowNextGroup());
		map_map.put("NextGroupStartPageNo", datgleService.selectList(config).getNextGroupStartPageNo());
		map_map.put("TotalPageCount", datgleService.selectList(config).getTotalPageCount());
		
		map.put(9999, map_map);
		
		return map;
	
	}
	
}
