package fooddk.controller.tasty;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

import fooddk.controller.hoogi.FileUploadController;
import fooddk.domain.Hoogi;
import fooddk.domain.Recipe;
import fooddk.domain.Tasty;
import fooddk.service.hoogi.HoogiServiceImpl;
import fooddk.service.tasty.TastyService;

@Controller
public class TastyWriteController {
	
	@Autowired
	private TastyService tastyService;
	
	@Autowired
	private HoogiServiceImpl hoogiService;
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	@RequestMapping(value="/TastyWriteAction")
	public String tastyWriteAction(@ModelAttribute Tasty tasty, @RequestParam("file") MultipartFile file,HttpServletRequest req){
		
		/*이미지 저장*/
		if(!file.isEmpty()){
			try {
				String rootPath =  req.getSession().getServletContext().getRealPath("/assets/images/uploadfile");
				File dir = new File(rootPath);
				if(!dir.exists()) dir.mkdirs();

				System.out.println(dir.getAbsolutePath());
				
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				byte[] bytes = file.getBytes();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(serverFile));
				bos.write(bytes);
				bos.close();
				logger.info("Server File Location=" + serverFile.getAbsolutePath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
			}
			String location = geocoding(tasty.getT_address());
			tasty.setT_location(location);
		}
		tasty.setT_img("images/"+file.getOriginalFilename());
		
		/*location 저장*/
		/*System.out.println("strLocation" + strLocation);
		System.out.println("length" + strLocation.length());
		
		strLocation.substring(1, strLocation.length());
		strLocation.trim();
		System.out.println("location"+strLocation);
		tasty.setT_location(strLocation);*/
		
		
		tastyService.insert(tasty);
		
		return "forward:TastyList";
	}
	
	@RequestMapping(value="/TastyWrite")
	public String tastyWriteForm(Model model){
		List<Hoogi> extraList = hoogiService.findHoogi(0, 7);
		model.addAttribute("hoogiList",extraList);
		return "TastyWriteForm_1";
	}
	
	@RequestMapping(value="/a_TastyWriteAction")
	public @ResponseBody int tastyWriteAction(@RequestParam(value="uploadedfile" , required=false)  MultipartFile file, HttpServletRequest req, @ModelAttribute Tasty tasty){
		tasty.setT_location("0,0");
		System.out.println("###controller실행");
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

				tasty.setT_img("images/" + file.getOriginalFilename());
 
				System.out.println("경로  ->" + file.getOriginalFilename());

			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			tasty.setT_img("images/default.jpg");
		}
		
		String location = geocoding(tasty.getT_address());
		tasty.setT_location(location);
		
		System.out.println("###controller 종료");
		return tastyService.insert(tasty);
	}
	
	private String geocoding(String address){

		Geocoder geocoder = new Geocoder();
		GeocoderRequest geoReq = new GeocoderRequestBuilder().setAddress(address).setLanguage("ko").getGeocoderRequest();
		GeocodeResponse geoRes;
		String location="0,0";
		
		try {
			geoRes = geocoder.geocode(geoReq);
			if(geoRes.getStatus() == GeocoderStatus.OK){
				GeocoderResult geocoderResult=geoRes.getResults().iterator().next();
				LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();
								  
				Float[] coords = new Float[2];
				coords[0] = latitudeLongitude.getLat().floatValue();
				coords[1] = latitudeLongitude.getLng().floatValue();
				
				location = coords[0]+","+coords[1];

			}else{
				System.out.println("지오코딩에러");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
	}
}
