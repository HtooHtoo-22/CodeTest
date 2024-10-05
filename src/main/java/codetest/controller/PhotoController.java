package codetest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Model.PhotoBean;
import codetest.repository.PhotoRepo;

@Controller
public class PhotoController {
	
	@GetMapping("/photo")
	public ModelAndView addphoto() {
		PhotoBean bean=new PhotoBean();
		return new ModelAndView("photo","Photo",bean);
	}
	
	@PostMapping("/uploadphoto")
	public String uploadPhoto(@ModelAttribute("Photo")PhotoBean photoBean) throws IOException {
		byte[] photoByte=photoBean.getFile().getBytes();
		PhotoRepo repo=new PhotoRepo();
		int i=repo.uploadPhoto(photoByte);
		if(i>0) {
			return "uploadsuccess";
		}else {
			System.out.println("cannot upload ");
		}
		return null;
	}
	
	@GetMapping("viewphoto")
	public String viewPhoto(Model model) {
		PhotoRepo repo=new PhotoRepo();
		List<String>photoList=repo.viewPhoto();
		model.addAttribute("Photo", photoList);
		return "viewphoto";
	}
}
