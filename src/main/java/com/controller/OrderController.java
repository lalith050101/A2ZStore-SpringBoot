package com.controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.CartItemModel;
import com.model.OrderModel;
import com.model.UserModel;
import com.repository.CartItemModelRepository;
import com.repository.OrderModelRepository;
import com.service.CartItemModelService;
import com.service.OrderModelService;
import com.service.UserModelService;

@Transactional
@Controller
public class OrderController {
	
	@Autowired
	UserModelService userModelService;
	
	@Autowired
	CartItemModelService cartItemModelService;
	
	@Autowired
	CartItemModelRepository cartItemModelRepository;
	
	@Autowired
	OrderModelRepository orderModelRepository;
	
	@Autowired
	OrderModelService orderModelService;
	
	@GetMapping(path="orderDetails")
	public ModelAndView orderDetails(ModelAndView mandv, HttpServletRequest request) {
        UserModel userModel = userModelService.extractUserModel(request);
		
        Set<CartItemModel> cartItemModels = cartItemModelRepository.findAllByUserIdAndProceedToPayment(userModel, true);
        
        mandv.addObject("cartItems", cartItemModels);
        mandv.setViewName("customer/orderDetails");
        return mandv;
		
	}
	
	@PostMapping(path="placeOrder")
	public ModelAndView placeOrder(ModelAndView mandv, HttpServletRequest request) {
        UserModel userModel = userModelService.extractUserModel(request);
        
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String contactNo = request.getParameter("contactNumber");
        String paymentType = request.getParameter("paymentType");

        OrderModel orderModel = new OrderModel() ;
        orderModel.setName(name);
        orderModel.setAddress(address);
        orderModel.setContactNumber(contactNo);
        orderModel.setPaymentType(paymentType);
        orderModel.setUserId(userModel.getEmail());
        orderModel.setTotalPrice(cartItemModelService.getTotalPrice(userModel));
        orderModel.setPaymentId("COD" + new Date().toString());
        orderModel.setStatus("ordered");
        
        orderModelRepository.save(orderModel);
        
        System.out.println("ordermode id: " + orderModel.getId());
        orderModelService.copyCartToOrders(userModel, orderModel);
        
        cartItemModelRepository.deleteAllByUserIdAndProceedToPayment(userModel, true);
        
        mandv.setViewName("redirect:/home");
        return mandv;
		
	}
	
	@GetMapping(path="orders")
	public ModelAndView getUserOrders(ModelAndView mandv, HttpServletRequest request) {
        UserModel userModel = userModelService.extractUserModel(request);
		
        Set<OrderModel> Orders = orderModelRepository.findAllByUserId(userModel.getEmail());
        
        mandv.addObject("orders", Orders);
        mandv.setViewName("customer/orders");
        return mandv;
		
	}
	
	@GetMapping(path="allOrders")
	public ModelAndView getAllOrders(ModelAndView mandv, HttpServletRequest request) {
		        
        mandv.addObject("orders", orderModelRepository.findAll());
        mandv.setViewName("admin/orders");
        return mandv;
	}
	
}