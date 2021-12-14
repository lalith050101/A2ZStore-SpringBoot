package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emailsender.EmailSenderV1;
import com.emailsender.EmailSenderV1Imp;
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
		
		try {
		EmailSenderV1 es = new EmailSenderV1Imp();
		es.sendEmail(userModel.getEmail(), "Account Creation", "Your account for Spring A2Z Store have been created successfully..." + "Email: " + userModel.getEmail());

		} catch(Exception e) {
			System.out.println("Email not sent for signup");
		}
		return new ModelAndView("redirect:/login");

	}
	
}
