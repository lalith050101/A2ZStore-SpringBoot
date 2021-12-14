package com.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CartItemModel;
import com.model.OrderItemModel;
import com.model.OrderModel;
import com.model.UserModel;
import com.repository.CartItemModelRepository;
import com.repository.OrderItemModelRepository;

@Service
public class OrderModelService {

	@Autowired
	private CartItemModelRepository cartItemModelRepository;

	@Autowired
	private OrderItemModelRepository orderItemModelRepository;

	public boolean copyCartToOrders(UserModel userModel, OrderModel orderModel) {
		Set<CartItemModel> cartItems = cartItemModelRepository.findAllByUserIdAndProceedToPayment(userModel, true);
		
		for(CartItemModel cartItem: cartItems) {
			OrderItemModel orderItem = new OrderItemModel();
			orderItem.setOrderId(orderModel);
			orderItem.setPrice(cartItem.getProductId().getPrice());
			orderItem.setProductId(cartItem.getProductId());
			orderItem.setProductName(cartItem.getProductId().getProductName());
			orderItem.setQuantity(cartItem.getQuantity());
			
			orderItemModelRepository.save(orderItem);
		}
		
		return true;
	}
	
}
