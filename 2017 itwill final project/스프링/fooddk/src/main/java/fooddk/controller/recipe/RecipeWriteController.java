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
public class RecipeWriteController {
	@Autowired
	private RecipeServiceImpl recipeServiceImpl;
	
	@Autowired
	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	public RecipeWriteController() {
		System.out.println("####RecipeWriteController()생성자!!");
	}
	
	@RequestMapping(value="/recipe_write_form", method=RequestMethod.GET)
	public String recipe_write_form(){
		String forwardPath="recipe_write_form";
		return forwardPath;
	}
	
	/*@RequestMapping(value="/recipe_write_form_action", method=RequestMethod.POST)
	public String recipe_write_action(@ModelAttribute Recipe recipe, @ModelAttribute("sId") String sId, Model model ){
		String forwardPath="";
		Member member = memberService.selectMemberCheckId(sId);
		int m_no = member.getM_no();
		recipe.setM_no(m_no);
		memberService.updatePointByno(m_no);
		memberService.updateGradeBypoint1();
		memberService.updateGradeBypoint2();
		memberService.updateGradeBypoint3();
		memberService.updateGradeBypoint4();
		memberService.updateGradeBypoint5();

		int rowCount = recipeServiceImpl.insert(recipe);
		//Member member2 =memberService.selectMemberMyNo(m_no);
		model.addAttribute("m_no", m_no);
		model.addAttribute("recipe", recipe);
		//model.addAttribute("g_no", member2.getG_no());
		
		if(rowCount==1){
			forwardPath="redirect:recipe_detail?r_no="+recipe.getR_no();
			
		}else{
			forwardPath="recipe_error";
		}
		
		return forwardPath;
	}*/
	
	@RequestMapping(value="/recipe_write_form_action", method=RequestMethod.POST)
	public String recipe_write_action(@RequestParam MultipartFile file, HttpServletRequest req, @ModelAttribute Recipe recipe,  @ModelAttribute("sId") String sId, Model model ){
		String forwardPath="";
		Member member = memberService.selectMemberCheckId(sId);
		int m_no = member.getM_no();
		recipe.setM_no(m_no);
		memberService.updatePointByno(m_no);
		int point1 = memberService.updateGradeBypoint1();
		int point2 = memberService.updateGradeBypoint2();
		int point3 = memberService.updateGradeBypoint3();
		int point4 = memberService.updateGradeBypoint4();
		int point5 = memberService.updateGradeBypoint5();
		
		Member memberPoint = memberService.selectMemberCheckId(sId);
		
		if(point2==1&&memberPoint.getM_point()==1100){
			System.out.println(">>>>>>"+point2);
			model.addAttribute("point", "실버로 등급이 변경되었습니다.");	
			model.addAttribute("modify", "1");
		}else if(point3==1&&memberPoint.getM_point()==2100){
			System.out.println(">>>>>>"+point3);
			model.addAttribute("point", "골드로 등급이 변경되었습니다.");	
			model.addAttribute("modify", "1");
		}else if(point4==1&&memberPoint.getM_point()==3100){
			model.addAttribute("point", "플레티넘로 등급이 변경되었습니다.");
			model.addAttribute("modify", "1");
			
		}else if(point5==1&&memberPoint.getM_point()==4100){
			model.addAttribute("point", "다이아로 등급이 변경되었습니다.");
			model.addAttribute("modify", "1");
		}else{
			model.addAttribute("modify", "1");
			model.addAttribute("point", "게시물 등록이 완료되었습니다.");
		}
		
		
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
				
				
				/* DB에서 가져오는 칼럼 잘라주기
				 * int pathNum = serverFile.getAbsolutePath().lastIndexOf("images");
				System.out.println(serverFile.getAbsolutePath().substring(pathNum));*/
				//자름
			/*	
				String path =serverFile.getAbsolutePath().substring(pathNum);
				
				System.out.println("경로zzz ->"+path);
				model.addAttribute("path", path);*/
				
				
				
//				hoogi.setH_img("/tmpFiles/"+serverFile.getAbsolutePath());
				//hoogi.setH_img("assets/images/uploadfile/"+hhh_img.getOriginalFilename());
//				hoogi.setH_img(serverFile.getAbsolutePath());
				
				//경로이름 : + 파일이름
				recipe.setR_img("images/"+file.getOriginalFilename());
				
				
				// return "You successfully uploaded file=" +
				// h_img.getOriginalFilename();
			
				System.out.println("경로  ->"+file.getOriginalFilename());
				
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
		
		}
		

		int rowCount = recipeServiceImpl.insert(recipe);
	
	
		model.addAttribute("m_no", m_no);
		model.addAttribute("recipe", recipe);
	
		if(rowCount==1){
		/*	forwardPath="redirect:recipe_list?c_no=0";*/
			forwardPath="forward:recipe_detail?r_no="+recipe.getR_no();
			
		}else{
			forwardPath="recipe_error";
		}
		
		return forwardPath;
	}
	
}
