package com.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CartItemModel;
import com.model.UserModel;
import com.repository.CartItemModelRepository;
import com.repository.UserModelRepository;

@Service
public class CartItemModelService {

	@Autowired
	private CartItemModelRepository cartItemModelRepository;


	public Long getTotalPrice(UserModel userModel) {
		Set<CartItemModel> cartItems = cartItemModelRepository.findAllByUserIdAndProceedToPayment(userModel, true);
		Long totalPrice = 0L;
		for(CartItemModel cartItem: cartItems) {
			totalPrice += Long.parseLong(cartItem.getProductId().getPrice())*cartItem.getQuantity();
		}
		return totalPrice;
	}
	
}
