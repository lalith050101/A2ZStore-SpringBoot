package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.ProductModel;
import com.model.UserModel;
import com.repository.ProductRepository;
import com.service.UserModelService;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserModelService userModelService;

	@GetMapping("addProduct")
	public ModelAndView loadAddProductPage(ModelAndView mandv) {
		mandv.addObject("productModel", new ProductModel());

		mandv.addObject("title", "Add Product");
		mandv.setViewName("admin/addProduct");
		System.out.println("bfore load add prod pg........");
		return mandv;

	}

	@PostMapping("addProduct")
	public ModelAndView processAddProductPage(ProductModel productModel, ModelAndView mandv) {
		productRepository.save(productModel);

		mandv.setViewName("redirect:/home");
		return mandv;

	}

	@GetMapping("editProduct/{productId}")
	public ModelAndView editProduct(@PathVariable Long productId, ModelAndView mandv, HttpServletRequest request) {

		System.out.println("edit called");
		mandv.addObject("productModel", (ProductModel) productRepository.findById(productId).orElse(null));

		mandv.addObject("title", "Edit Product");
		mandv.setViewName("/admin/editProduct");
		System.out.println("return in editprod...");
		return mandv;

	}

	@PostMapping("editProduct/{productId}")
	public ModelAndView updateProduct(@PathVariable Long productId, ProductModel productModel, ModelAndView mandv) {
		System.out.println("updateProduct");
		productRepository.save(productModel);
		mandv.setViewName("redirect:/home");
		return mandv;

	}

	@GetMapping("/deleteProduct/{productId}")
	public ModelAndView deleteProduct(@PathVariable Long productId, ModelAndView mandv) {
		productRepository.deleteById(productId);

		mandv.setViewName("redirect:/home");
		return mandv;

	}

	@GetMapping("/getProduct/{productId}")
	public ModelAndView getProduct(@PathVariable Long productId, ModelAndView mandv, HttpServletRequest request, Authentication authentication) {
		UserModel userModel = userModelService.extractUserModel(authentication.getName());

		mandv.addObject("productModel", productRepository.findById(productId).orElse(null));

		mandv.addObject("title", "Product Details");

		if (userModel.getRole().equals("admin"))
			mandv.setViewName("admin/productDetails");

		else {
			mandv.addObject("quantity", 1);
			mandv.setViewName("customer/productDetails");

		}
		return mandv;

	}
}
