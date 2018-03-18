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
import org.springframework.web.multipart.MultipartFile;

import fooddk.domain.Hoogi;
import fooddk.domain.Tasty;
import fooddk.service.hoogi.HoogiService;
import fooddk.service.recipe.RecipeServiceImpl;
import fooddk.service.tasty.TastyService;

@Controller
public class HoogiUpdateActionController {

	Hoogi hoogi;
	// 서비스받아오기
	@Autowired
	private HoogiService hoogiservice;

	@Autowired
	private TastyService tastyservice;

	@Autowired
	private RecipeServiceImpl recipeserviceimpl;

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	// 폼 매핑하기
	@RequestMapping("/Hoogi_Modify_form_1")
	public String handleRequest(Model model, @RequestParam int h_no) {

		Hoogi hoogiselect = hoogiservice.selectByNo(h_no);

		model.addAttribute("hoogiselect", hoogiselect);
		// 포워드 .jsp
		String forwardPath = "Hoogi_Modify_form_1";
		// String forwardPath="HoogiUpdateForm";
		// 맛집 리스트 뽑아오기
		List<Tasty> tastyList = tastyservice.selectAll();

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

		// 맛집 리스트 보여주기
		model.addAttribute("tastyList", tastyList);

		return forwardPath;
	}

	// 모델추가해줘야함
	@RequestMapping(value = "/Hoogi_Modify_Action", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest req, @RequestParam MultipartFile file, @ModelAttribute Hoogi hoogi,
			Model model, @ModelAttribute("sId") String sId) {
		String forwardPath = "";

		if (!file.isEmpty()) {

			try {

				// 바이트로 받고

				String rootPath = req.getSession().getServletContext().getRealPath("/assets/images/uploadfile");

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

				/*
				 * DB에서 가져오는 칼럼 잘라주기 int pathNum =
				 * serverFile.getAbsolutePath().lastIndexOf("images");
				 * System.out.println(serverFile.getAbsolutePath().substring(
				 * pathNum));
				 */
				// 자름
				/*
				 * String path =serverFile.getAbsolutePath().substring(pathNum);
				 * 
				 * 
				 * model.addAttribute("path", path);
				 */

				// hoogi.setH_img("/tmpFiles/"+serverFile.getAbsolutePath());
				// hoogi.setH_img("assets/images/uploadfile/"+hhh_img.getOriginalFilename());
				// hoogi.setH_img(serverFile.getAbsolutePath());

				// 경로이름 : + 파일이름
				hoogi.setH_img("images/" + file.getOriginalFilename());

				// return "You successfully uploaded file=" +
				// h_img.getOriginalFilename();
				System.out.println("절대경로" + serverFile.getAbsolutePath());
				System.out.println("경로images/" + file.getOriginalFilename());

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

		int udpateByNo = hoogiservice.updateByNo(hoogi);
		System.out.println("udpateByNo!!!!!!!!!!!!!!" + udpateByNo);
		if (udpateByNo == 1) {
			// 컨트롤러보낼때
			forwardPath = "redirect:HoogiView_1.?h_no=" + hoogi.getH_no();
		} else {
			return forwardPath = "redirect:HoogiList_1";
		}

		return forwardPath;
	}
	// 액션 매핑 및 메소드방법

}
