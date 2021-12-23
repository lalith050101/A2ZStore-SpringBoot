package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.repository.ProductRepository;

@Controller
public class HomePageController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(path = "home", method = RequestMethod.GET)
	public ModelAndView loadCustomerHomePage(ModelAndView mandv) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if((auth.getAuthorities().toArray()[0].toString()).equals("admin")) {
			
			mandv.addObject("productList", productRepository.findAll());

			mandv.addObject("title", "Admin Home");
			mandv.setViewName("admin/home");
			
		}
		else {
		mandv.addObject("productList", productRepository.findAll());

		mandv.addObject("title", "Home");
		mandv.setViewName("customer/home");
		}
		return mandv;
	}

//	@RequestMapping(path = "adminHome", method = RequestMethod.GET)
//	public ModelAndView loadAdminHomePage(ModelAndView mandv) {
//		
//	}

}
