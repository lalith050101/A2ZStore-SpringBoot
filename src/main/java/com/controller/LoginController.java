package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.UserModel;
import com.security.MyUserDetailsService;
import com.service.UserModelService;

@Controller
public class LoginController {

	@Autowired
	UserModelService userModelService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
    private MyUserDetailsService userDetailsService;

	@RequestMapping(path = "login", method = RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		ModelAndView mandv = new ModelAndView();
		System.out.println(mandv.getModel().get("userModel"));
		mandv.addObject("loginModel", new UserModel());

		mandv.addObject("title", "Login");
		mandv.setViewName("login");

		System.out.println("login get...............\n");
		return mandv;
	}

//	@RequestMapping(path = "login", method = RequestMethod.POST)
//	public ModelAndView processLoginPage(@ModelAttribute("loginModel") UserModel loginModel,
//			HttpServletRequest request) {
//		System.out.println("in process login: " + loginModel.getEmail());
//
//		if (!userModelService.checkUser(loginModel)) {
//			ModelAndView mandv = new ModelAndView("login");
//			mandv.addObject("loginModel", loginModel);
//			request.setAttribute("errorMessage", "Invalid credentials");
//			return new ModelAndView("login");
//		}
//		
//		authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword())
//        );
//		final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(loginModel.getEmail());
//
//		UserModel userModel = userModelService.getUserModel(loginModel.getEmail());
//		request.getSession().setAttribute("email", loginModel.getEmail());
//		request.getSession().setAttribute("username", userModel.getUsername());
//
//		System.out.println("bfore login return........");
//
//		if (userModel.getRole().equals("admin")) {
//			return new ModelAndView("redirect:/adminHome");
//		}
//		return new ModelAndView("redirect:/home");
//	}

}
