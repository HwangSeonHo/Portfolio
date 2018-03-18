package fooddk.controller.recipe;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import fooddk.controller.hoogi.FileUploadController;
import fooddk.domain.Member;
import fooddk.domain.Recipe;
import fooddk.service.member.MemberService;
import fooddk.service.recipe.RecipeServiceImpl;
@SessionAttributes("sId")
@Controller
public class RecipeModifyController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	public RecipeModifyController() {
		System.out.println("RecipeModifyController()생성자");
	}
	@RequestMapping(value="/recipe_modify_form")
	public String recipe_modify_form(@RequestParam int r_no, Model model){
		String forwardPath="";
		Recipe recipe1 = recipeServiceImpl.selectByNo(r_no);
		model.addAttribute("recipe", recipe1);
		forwardPath="recipe_modify_form";
		return forwardPath;
	}
	/*@RequestMapping(value="/recipe_modify_action", method=RequestMethod.POST)
	public String recipe_modify_action(@ModelAttribute Recipe recipe, Model model, @ModelAttribute("sId") String sId){
		String forwardPath="";
		Member member = memberService.selectMemberCheckId(sId);
		int m_no = member.getM_no();
		recipe.setM_no(m_no);
		
		int rowCount = recipeServiceImpl.updateByNo(recipe);
		if(rowCount==1){			
			
			model.addAttribute("recipe", recipe);
			forwardPath="redirect:recipe_detail?r_no="+recipe.getR_no();
		}else{
			forwardPath="recipe_error";
		}
		return forwardPath;
		
	}*/
	
	@RequestMapping(value="/recipe_modify_action", method=RequestMethod.POST)
	public String recipe_modify_action(@RequestParam MultipartFile file, HttpServletRequest req,  @ModelAttribute Recipe recipe, Model model, @ModelAttribute("sId") String sId){
		String forwardPath="";
		Member member = memberService.selectMemberCheckId(sId);
		int m_no = member.getM_no();
		recipe.setM_no(m_no);
		
		
		// 파일이미지
		System.out.println("0★★★★★★★★★★★★★★★★★★★★★★★★★");
		 // File dir = new File(rootPath + File.separator);
		if (!file.isEmpty()) {
			
			try {
			
				// 바이트로 받고
				
			    String rootPath = 
			    		req.getSession().getServletContext().getRealPath("/assets/images/uploadfile");

				
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());
				// 경로 + 파일이름

				//경로이름 : + 파일이름
				recipe.setR_img("images/"+file.getOriginalFilename());

				System.out.println("경로  ->"+file.getOriginalFilename());
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
		
		}
		
		
		
		
		int rowCount = recipeServiceImpl.updateByNo(recipe);
		if(rowCount==1){			
			
			model.addAttribute("recipe", recipe);
			forwardPath="redirect:recipe_detail?r_no="+recipe.getR_no();
		}else{
			forwardPath="recipe_error";
		}
		return forwardPath;
		
	}
}
