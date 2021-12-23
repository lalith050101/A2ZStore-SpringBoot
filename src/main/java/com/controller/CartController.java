package com.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.model.CartItemModel;
import com.model.ProductModel;
import com.model.UserModel;
import com.repository.CartItemModelRepository;
import com.repository.ProductRepository;
import com.repository.UserModelRepository;
import com.service.UserModelService;

@Controller
public class CartController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserModelService userModelService;

	@Autowired
	private UserModelRepository userModelRepository;

	@Autowired
	private CartItemModelRepository cartItemModelRepository;

	@PostMapping("/addToCart/{productId}")
	public ModelAndView addToCart(@PathVariable long productId, ModelAndView mandv, HttpServletRequest request, Authentication authentication) {
		System.out.println("add to cart called........");
		UserModel userModel = userModelService.extractUserModel(authentication.getName());

		mandv.addObject("productModel", productRepository.findById(productId).orElse(null));
		mandv.addObject("title", "Product Details");
		mandv.setViewName("customer/productDetails");
		mandv.addObject("addToCart", "Added to Cart");

		int quantity = Integer.parseInt(request.getParameter("quantity"));
		ProductModel product = productRepository.findById(productId).orElse(null);

		Set<CartItemModel> cartItems = cartItemModelRepository.findAllByUserId(userModel);
		for (CartItemModel c : cartItems) {
			if (c.getProductId().equals(product)) {
				c.setQuantity(quantity + c.getQuantity());
				cartItemModelRepository.save(c);

				return mandv;
			}
		}
		System.out.println("add to cart 2 called........");

		CartItemModel cartItemModel = new CartItemModel();
		cartItemModel.setUserId(userModel);
		cartItemModel.setProductId(product);
		cartItemModel.setQuantity(quantity);

		cartItemModelRepository.save(cartItemModel);

		return mandv;
	}

	@GetMapping(path = "cart")
	public ModelAndView getCartItems(ModelAndView mandv, HttpServletRequest request, Authentication authentication) {
		UserModel userModel = userModelService.extractUserModel(authentication.getName());

		Set<CartItemModel> cartItemModels = cartItemModelRepository.findAllByUserId(userModel);
		for (CartItemModel cartItemModel : cartItemModels) {
			cartItemModel.setProceedToPayment(false);
			cartItemModelRepository.save(cartItemModel);
		}

		mandv.addObject("cartItems", cartItemModels);

		mandv.addObject("title", "Cart");
		mandv.setViewName("customer/cart");
		return mandv;
	}

	@GetMapping(path = "/removeCartItem/{cartItemId}")
	public ModelAndView removeCartItem(@PathVariable Long cartItemId, ModelAndView mandv, HttpServletRequest request, Authentication authentication) {
		UserModel userModel = userModelService.extractUserModel(authentication.getName());

		cartItemModelRepository.deleteById(cartItemId);

		mandv.setViewName("redirect:/cart");
		return mandv;
	}

	@GetMapping(path = "updateCart/{cartItemId}/{quantity}")
	public ModelAndView updateCart(@PathVariable Long cartItemId, @PathVariable int quantity, ModelAndView mandv, HttpServletRequest request) {
		System.out.println("update cart called......");

		CartItemModel cartItemModel = cartItemModelRepository.findById(cartItemId).orElse(null);
		cartItemModel.setQuantity(quantity);

		cartItemModelRepository.save(cartItemModel);

		mandv.setViewName("redirect:/cart");
		return mandv;
	}

	@PostMapping(path = "proceedOrder")
	public ModelAndView proceedToPayment(ModelAndView mandv, HttpServletRequest request) {

		String[] selectedCartItemIds = request.getParameterValues("proceedToPayment");

		for (String cartItemId : selectedCartItemIds) {
			System.out.println(cartItemId);
			CartItemModel cartItemModel = cartItemModelRepository.findById(Long.parseLong(cartItemId)).orElse(null);
			cartItemModel.setProceedToPayment(true);
			cartItemModelRepository.save(cartItemModel);
		}

		mandv.setViewName("redirect:/orderDetails");
		return mandv;
	}

}
