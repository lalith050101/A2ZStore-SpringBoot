package com.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadSignupPage() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("userModel", new UserModel());

		mandv.addObject("title", "Sign Up");
		mandv.setViewName("signup");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSignupPage(UserModel userModel, HttpServletRequest request) {
		userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		if (!userModelService.addUserModel(userModel)) {
			ModelAndView mandv = new ModelAndView("signup");
			mandv.addObject("loginModel", userModel);
			request.setAttribute("errorMessage", "Email Already Exists");
			return mandv;
		}

		try {
			EmailSenderV1 es = new EmailSenderV1Imp();
			es.sendEmail(userModel.getEmail(), "Account Creation",
					"Your account for Spring A2Z Store have been created successfully..." + "Email: "
							+ userModel.getEmail());

		} catch (Exception e) {
			System.out.println("Email not sent for signup");
		}
		return new ModelAndView("redirect:/login");

	}

}
