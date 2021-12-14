package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.repository.ProductRepository;

@Controller
public class HomePageController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(path = "home", method=RequestMethod.GET)
	public ModelAndView loadCustomerHomePage(ModelAndView mandv) {
		mandv.addObject("productList", productRepository.findAll());

		mandv.setViewName("customer/home");
		return mandv;
	}
	
	@RequestMapping(path="adminHome", method=RequestMethod.GET)
	public ModelAndView loadAdminHomePage(ModelAndView mandv) {
		mandv.addObject("productList", productRepository.findAll());
		mandv.setViewName("admin/home");
		return mandv;
	}
	
	
	
}
