package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.UserModel;
import com.service.UserModelService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	UserModelService userModelService;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		ModelAndView mandv = new ModelAndView();
		System.out.println(mandv.getModel().get("userModel"));
		mandv.addObject("loginModel",new UserModel());
		
		mandv.addObject("title", "Login");
		mandv.setViewName("login");
		
		System.out.println("login get...............\n");
		return mandv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processLoginPage(UserModel loginModel,ModelAndView mandv, HttpServletRequest request) {
		System.out.println("in process login: " + loginModel.getEmail());
		if(!userModelService.checkUser(loginModel)) {
			return new ModelAndView("redirect:/login");
		}
		
		UserModel userModel = userModelService.getUserModel(loginModel.getEmail());
		request.getSession().setAttribute("email", loginModel.getEmail());
		request.getSession().setAttribute("username", userModel.getUsername());
		
		System.out.println("bfore login return........");
		
		if(userModel.getRole().equals("admin")) {
			return new ModelAndView("redirect:/adminHome");
		}
		return new ModelAndView("redirect:/home");
	}
	
}
