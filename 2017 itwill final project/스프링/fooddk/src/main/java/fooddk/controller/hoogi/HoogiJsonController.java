package fooddk.controller.hoogi;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fooddk.domain.Hoogi;
import fooddk.service.hoogi.HoogiService;

@Controller
public class HoogiJsonController {

	@Autowired
	HoogiService hoogiservice;

	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	@RequestMapping("/HoogiList_2")
	public @ResponseBody List<Hoogi> HoogiJsonList() {
		return hoogiservice.selectAll();

	}

	@RequestMapping("/HoogiRemoveAction_2")
	public @ResponseBody int HoogiJsonRemove(int h_no) {
		// 삭제
		return hoogiservice.deleteByNo(h_no);

	}

	@RequestMapping("/HoogiWriteAction_2")
	public @ResponseBody int HoogiJsonWrite(HttpServletRequest req, @ModelAttribute Hoogi hoogi,
			@RequestParam(value="uploadedfile" , required=false) MultipartFile file) {
		hoogi.setT_no(1);
		hoogi.setM_no(1);
		System.out.println("sssssssssssssssssssssssssss");
		System.out.println("스트링" + hoogi.toString());
		if (!file.isEmpty()) {

			try {
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
				// 경로이름 : + 파일이름
				hoogi.setH_img("images/" + file.getOriginalFilename());

				System.out.println("절대경로" + serverFile.getAbsolutePath());
				System.out.println("경로images/" + file.getOriginalFilename());

			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			hoogi.setH_img("images/default.jpg");
		}

		System.out.println("sssssssssssssssssssssssssss");
		System.out.println("스트링" + hoogi.toString());
		return hoogiservice.insertHoogi(hoogi);
	}

	@RequestMapping("/HoogiUpdateAction_2")
	public @ResponseBody int HoogiJsonUpdate(HttpServletRequest req, @ModelAttribute Hoogi hoogi,
			@RequestParam(value="uploadedfile" , required=false)  MultipartFile file) {
		hoogi.setT_no(1);
		hoogi.setM_no(1);
		
		System.out.println("후기 "+hoogi.toString());
		if (!file.isEmpty()) {

			try {
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
				// 경로이름 : + 파일이름
				hoogi.setH_img("images/" + file.getOriginalFilename());

				System.out.println("절대경로" + serverFile.getAbsolutePath());
				System.out.println("경로images/" + file.getOriginalFilename());

			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			hoogi.setH_img("images/default.jpg");
		}

		return hoogiservice.updateByNo(hoogi);
	}

}
