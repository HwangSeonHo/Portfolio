package fooddk.controller.etc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fooddk.domain.Item;
import fooddk.domain.Jumon;
import fooddk.service.arduino.ItemServiceImpl;
import fooddk.service.arduino.JumonServiceImpl;
import fooddk.service.recipe.RecipeServiceImpl;

@Controller
public class IdoenoButtonController {
   @Autowired
   private RecipeServiceImpl recipeServiceImpl;
   @Autowired
   private ItemServiceImpl itemServiceImpl;
   @Autowired
   private JumonServiceImpl jumonServiceImpl;
   
   public IdoenoButtonController() {
      // TODO Auto-generated constructor stub
	   System.out.println("아두이노짜징맨");
   }
   
   @RequestMapping(value="/button_real")
   public String button(Model model) throws Exception{
      
	   List<Item> itemList = itemServiceImpl.selectAll();
	   List<Jumon> jumonList = jumonServiceImpl.selectAll();
      
      for (Item item : itemList) {
    	  System.out.println("********아이템리스트"+itemList);
      }
      ArrayList<String> list = new ArrayList<String>();
      
      for (Jumon jumon : jumonList) {
    	  System.out.println("********주문리스트"+jumonList);   	 
    	  list.add(itemServiceImpl.selectByNo(jumon.getI_no()).getI_name());
      }            
      
      model.addAttribute("itemList",itemList);
      model.addAttribute("jumonList",jumonList);
      model.addAttribute("string",list);
      
      
      return "button_real";
      
   }

}