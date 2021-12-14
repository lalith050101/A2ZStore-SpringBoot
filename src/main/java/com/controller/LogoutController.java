package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.service.UserModelService;

@Controller
@RequestMapping("logout")
public class LogoutController {
	
	@Autowired
	UserModelService userModelService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processLogoutPage(ModelAndView mandv, HttpServletRequest request) {
//		if(!userModelService.checkUser(LoginModel)) {
//			mandv.setViewName("login");
//			return mandv;
//		}

		HttpSession session =  request.getSession();
//		String username = (String)session.getAttribute("username");
		session.removeAttribute("email");
		session.removeAttribute("username");
		session.invalidate();
		return new ModelAndView("redirect:/login");
	}
	
}
