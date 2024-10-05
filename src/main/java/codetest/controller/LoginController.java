package codetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import Model.LoginBean;
import Model.UserBean;
import codetest.repository.UserRepo;

@Controller
public class LoginController {
	
	
	
	
	@GetMapping("/")
	public ModelAndView viewlogin() {
		LoginBean bean=new LoginBean();
		return new ModelAndView("Login","userObj",bean);
	}
	
	@PostMapping("/dologin")
	public String login(@ModelAttribute("userObj")LoginBean bean,Model model) {
		UserRepo repo=new UserRepo();
		boolean result=repo.checkEmail(bean.getEmail());
		if(result) {
			UserBean ubean=repo.checkPassword(bean.getEmail(), bean.getPassword());
			if(ubean.getRole().equals("admin")) {
				return "adminview";
			}else {
				model.addAttribute("name", ubean.getName());
				return "userview";
			}
		}
		return null;
	}
	
	@GetMapping("/viewregister")
	public ModelAndView viewregister() {
		return new ModelAndView("register","userReg",new UserBean());
	}
	@PostMapping("doregister")
	public String doRegister() {
		
		return "redirect:/";
	}
	
	
}
