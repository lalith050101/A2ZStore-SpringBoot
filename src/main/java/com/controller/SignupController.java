package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.UserModel;
import com.service.UserModelService;

@Controller
@RequestMapping("signup")
public class SignupController {
	
	@Autowired
	UserModelService userModelService;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loadSignupPage() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("userModel",new UserModel());
		
		mandv.addObject("title", "Sign Up");
		mandv.setViewName("signup");
		return mandv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processSignupPage(UserModel userModel,ModelAndView mandv) {
	
		if(!userModelService.addUserModel(userModel)) {
			mandv.setViewName("signup");
			return mandv;
		}

		
		return new ModelAndView("redirect:/login");

	}
	
}
