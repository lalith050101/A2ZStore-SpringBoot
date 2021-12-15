package com.service;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import com.model.CartItemModel;
import com.model.OrderItemModel;
import com.model.OrderModel;
import com.model.UserModel;
import com.repository.CartItemModelRepository;
import com.repository.OrderItemModelRepository;
import com.repository.OrderModelRepository;

@Service
@Transactional
public class OrderModelService {

	
	@Autowired
	private UserModelService userModelService;

	
	@Autowired
	private CartItemModelRepository cartItemModelRepository;

	@Autowired
	private OrderItemModelRepository orderItemModelRepository;
	
	@Autowired
	private OrderModelRepository orderModelRepository;

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
	
	public boolean updatePayment(Long orderId, String paymentId) {
		
		OrderModel orderModel = orderModelRepository.findById(orderId).orElse(null);
		
		orderModel.setStatus("paid");
		
		orderModel.setPaymentId(paymentId);
	
		orderModelRepository.save(orderModel);
		UserModel user = userModelService.getUserModel(orderModel.getUserId());
		
		copyCartToOrders(user, orderModel);
		cartItemModelRepository.deleteAllByUserIdAndProceedToPayment(user, true);
		return true;
	}
	
	
}
