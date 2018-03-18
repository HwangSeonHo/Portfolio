package fooddk.controller.hoogi;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import fooddk.domain.Hoogi;
import fooddk.domain.Member;
import fooddk.domain.Tasty;
import fooddk.service.hoogi.HoogiService;
import fooddk.service.member.MemberService;
import fooddk.service.recipe.RecipeServiceImpl;
import fooddk.service.tasty.TastyService;

@SessionAttributes("sId")
@Controller
public class HoogWriteActionController {

	// 서비스불러오기
	@Autowired
	private HoogiService hoogiservice;
	@Autowired
	private MemberService memberservice;

	@Autowired
	private TastyService tastyservice;

	@Autowired
	private RecipeServiceImpl recipeserviceimpl;

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	// 매핑 폼
	@RequestMapping("/Hoogi_Write_form_1")
	public String handleRequest(Model model) {

		// 레시피 동적 뽑아오기 (하나하나 다 뽑아와야함)
		int recipecount1 = recipeserviceimpl.countAllByDynamic(1);
		int recipecount2 = recipeserviceimpl.countAllByDynamic(2);
		int recipecount3 = recipeserviceimpl.countAllByDynamic(3);
		int recipecount4 = recipeserviceimpl.countAllByDynamic(4);
		int recipecount5 = recipeserviceimpl.countAllByDynamic(5);

		// 카운트뽑아오기
		model.addAttribute("recipecount1", recipecount1);
		model.addAttribute("recipecount2", recipecount2);
		model.addAttribute("recipecount3", recipecount3);
		model.addAttribute("recipecount4", recipecount4);
		model.addAttribute("recipecount5", recipecount5);

		// 맛집 리스트 뽑아오기
		List<Tasty> tastyList = tastyservice.selectAll();

		// 맛집 리스트 보여주기
		model.addAttribute("tastyList", tastyList);

		String forwardPath = "Hoogi_Write_form_1";
		return forwardPath;

	}
	/*@RequestMapping(value = "/HoogiWriteAction1")
	   public @ResponseBody String uploadFileHandler(HttpServletRequest request, @RequestParam MultipartFile file) {

	      if (!file.isEmpty()) {
	         try {
	            byte[] bytes = file.getBytes();

	            // Creating the directory to store file
	            //String rootPath = System.getProperty("catalina.home");
	
	           
	            
	            String rootPath =request.getSession().getServletContext().getRealPath("/assets/images/uploadfile");
	            
	            File dir = new File(rootPath + File.separator);
	            if (!dir.exists())
	               dir.mkdirs();

	            // Create the file on server
	            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
	            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	            stream.write(bytes);
	            stream.close();

	            logger.info("Server File Location=" + serverFile.getAbsolutePath());

	            return "You successfully uploaded file=" + file.getOriginalFilename();
	         } catch (Exception e) {
	            return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
	         }
	      } else {
	         return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
	      }
	   }*/

	@RequestMapping(value = "/HoogiWriteAction1")
	public  String handleRequest(HttpServletRequest req, @RequestParam MultipartFile file, @ModelAttribute Hoogi hoogi, Model model,
			@ModelAttribute("sId") String sId) throws UnsupportedEncodingException {
		// System.out.println("zzzz");
		String forwardPath = "";

		// 임의로 지정한 1번 바꿔줘야함
		// hoogi.setM_no(1);
		hoogi.setM_no(memberservice.selectMemberCheckId(sId).getM_no());
		hoogi.setT_no(1);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	
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
				
				
				model.addAttribute("path", path);*/
				
				
				
//				hoogi.setH_img("/tmpFiles/"+serverFile.getAbsolutePath());
				//hoogi.setH_img("assets/images/uploadfile/"+hhh_img.getOriginalFilename());
//				hoogi.setH_img(serverFile.getAbsolutePath());
				
				//경로이름 : + 파일이름
				hoogi.setH_img("images/"+file.getOriginalFilename());
				
				
				// return "You successfully uploaded file=" +
				// h_img.getOriginalFilename();
				System.out.println("절대경로" +serverFile.getAbsolutePath());
				System.out.println("경로images/"+file.getOriginalFilename());
				
			} catch (Exception e) {
				e.printStackTrace();
				// return "You failed to upload " +
				// hhh_img.getOriginalFilename() + " => " + e.getMessage();
			}
		} else {
		// return "You failed to upload " + hhh_img.getOriginalFilename() +
			// " because the file was empty.";
		}
		
		// 멤버 받아오기
		// Member member = memberService.selectMemberMyNo(hoogi.getM_no());
		/*
		 * String m_name = member.getM_name();
		 */
		// m_no 만들어주고 m_name으로저장
		// model.addAttribute("m_name",m_name);

		int insert = hoogiservice.insertHoogi(hoogi);
		if (insert == 1) {

			forwardPath = "redirect:HoogiList_1";
		} else {

			return forwardPath = "forward:/WEB-INF/view/HoogiMasadasdin.jsp";
		}

		return forwardPath;
	}

}



/********************내일****************************/

/*


package fooddk.controller.hoogi;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import fooddk.domain.Hoogi;
import fooddk.domain.Member;
import fooddk.domain.Tasty;
import fooddk.service.hoogi.HoogiService;
import fooddk.service.member.MemberService;
import fooddk.service.recipe.RecipeServiceImpl;
import fooddk.service.tasty.TastyService;

@SessionAttributes("sId")
@Controller
public class HoogWriteActionController {

   // 서비스불러오기
   @Autowired
   private HoogiService hoogiservice;
   @Autowired
   private MemberService memberservice;

   @Autowired
   private TastyService tastyservice;

   @Autowired
   private RecipeServiceImpl recipeserviceimpl;

   private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

   // 매핑 폼
   @RequestMapping("/Hoogi_Write_form_1")
   public String handleRequest(Model model) {

      // 레시피 동적 뽑아오기 (하나하나 다 뽑아와야함)
      int recipecount1 = recipeserviceimpl.countAllByDynamic(1);
      int recipecount2 = recipeserviceimpl.countAllByDynamic(2);
      int recipecount3 = recipeserviceimpl.countAllByDynamic(3);
      int recipecount4 = recipeserviceimpl.countAllByDynamic(4);
      int recipecount5 = recipeserviceimpl.countAllByDynamic(5);

      // 카운트뽑아오기
      model.addAttribute("recipecount1", recipecount1);
      model.addAttribute("recipecount2", recipecount2);
      model.addAttribute("recipecount3", recipecount3);
      model.addAttribute("recipecount4", recipecount4);
      model.addAttribute("recipecount5", recipecount5);

      // 맛집 리스트 뽑아오기
      List<Tasty> tastyList = tastyservice.selectAll();

      // 맛집 리스트 보여주기
      model.addAttribute("tastyList", tastyList);

      String forwardPath = "Hoogi_Write_form_1";
      return forwardPath;

   }
   
   @RequestMapping(value = "/HoogiWriteAction1")
   public @ResponseBody String uploadFileHandler(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

      if (!file.isEmpty()) {
         try {
            byte[] bytes = file.getBytes();

            // Creating the directory to store file
            //String rootPath = System.getProperty("catalina.home");
            String rootPath =request.getSession().getServletContext().getRealPath("/assets/images/uploadfile");
            
            File dir = new File(rootPath + File.separator);
            if (!dir.exists())
               dir.mkdirs();

            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

            logger.info("Server File Location=" + serverFile.getAbsolutePath());

            return "You successfully uploaded file=" + file.getOriginalFilename();
         } catch (Exception e) {
            return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
         }
      } else {
         return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
      }
   }

   

}
*/