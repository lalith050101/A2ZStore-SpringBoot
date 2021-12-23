package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.UserModel;
import com.service.UserModelService;

@Controller

public class CustomerController {

	@Autowired
	UserModelService userModelService;

	@GetMapping(path = "profile")
	public ModelAndView loadUserProfile(ModelAndView mandv, HttpServletRequest request, Authentication authentication) {
		UserModel userModel = userModelService.extractUserModel(authentication.getName());
		mandv = new ModelAndView();
		userModel.setPassword("");
		mandv.addObject("userModel", userModel);
		mandv.setViewName("customer/profile");

		return mandv;
	}

	@PostMapping(path = "updateProfile")
	public ModelAndView updateUserProfile(UserModel userModel, ModelAndView mandv) {
		System.out.println("update profile....");
		if (!userModelService.updateUserModel(userModel)) {
			mandv.setViewName("customer/profile");
			System.out.println("not update profile....");

			return mandv;
		}
		System.out.println("updated profile....");

		mandv.setViewName("redirect:/home");
		return mandv;

	}

}
