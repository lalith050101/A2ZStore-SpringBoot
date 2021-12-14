package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.ProductModel;
import com.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
    private ProductRepository productRepository;
	
	@GetMapping("addProduct")
	public ModelAndView loadAddProductPage(ModelAndView mandv) {
		mandv.addObject("productModel",new ProductModel());
		mandv.setViewName("admin/addProduct");
		System.out.println("bfore load add prod pg........");
		return mandv;
		
	}
	
	@PostMapping("addProduct")
	public ModelAndView processAddProductPage(ProductModel productModel, ModelAndView mandv) {
		productRepository.save(productModel);
		
		mandv.setViewName("redirect:/adminHome");
		return mandv;
		
	}
	
	@GetMapping("editProduct/{productId}")
	public ModelAndView editProduct(@PathVariable Long productId, ModelAndView mandv,  HttpServletRequest request) {
		
		if(!LoginValidationController.isValidUser(request.getSession())) {
			mandv.setViewName("redirect:/login");
			return mandv;
		}
			
			
		System.out.println("edit called");
		mandv.addObject("productModel", (ProductModel)productRepository.findById(productId).orElse(null));
		
		mandv.setViewName("/admin/editProduct");
		System.out.println("return in editprod...");
		return mandv;
		
	}
	
	@PostMapping("editProduct/{productId}")
	public ModelAndView updateProduct(@PathVariable Long productId, ProductModel productModel, ModelAndView mandv) {
		System.out.println("updateProduct");
		productRepository.save(productModel);
		mandv.setViewName("redirect:/adminHome");
		return mandv;
		
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public ModelAndView deleteProduct(@PathVariable Long productId, ModelAndView mandv) {
		productRepository.deleteById(productId);
		
		mandv.setViewName("redirect:/adminHome");
		return mandv;
		
	}
	
	@GetMapping("/getProduct/{productId}")
	public ModelAndView getProduct(@PathVariable Long productId, ModelAndView mandv) {
		mandv.addObject("productModel", productRepository.findById(productId).orElse(null));
		
		mandv.addObject("quantity", 1);

		mandv.setViewName("customer/productDetails");
		return mandv;
		
	}
}
