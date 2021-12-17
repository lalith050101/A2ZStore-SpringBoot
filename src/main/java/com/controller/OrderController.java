package com.controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.model.CartItemModel;
import com.model.Order;
import com.model.OrderModel;
import com.model.UserModel;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.repository.CartItemModelRepository;
import com.repository.OrderModelRepository;
import com.service.CartItemModelService;
import com.service.OrderModelService;
import com.service.PaypalService;
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
	
	@Autowired
	PaypalService payPalService;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";
	
	@GetMapping(path="orderDetails")
	public ModelAndView orderDetails(ModelAndView mandv, HttpServletRequest request) {
        UserModel userModel = userModelService.extractUserModel(request);
		
        Set<CartItemModel> cartItemModels = cartItemModelRepository.findAllByUserIdAndProceedToPayment(userModel, true);
        
        mandv.addObject("title", "Order Details");
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
        
        orderModel.setStatus("yetToPay");
   	 	orderModelRepository.save(orderModel);
        
        if(paymentType.equals("OnlinePayment")) {
        	
        	try {

           	 Order order = new Order(orderModel.getTotalPrice(), "USD", "PayPal", "sale", orderModel.getId().toString());
          
     			Payment payment = payPalService.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
     					order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
     					"http://localhost:8080/" + SUCCESS_URL);
     			for(Links link:payment.getLinks()) {
     				System.out.println("Link: " + link.getRel() + " : " + link.getHref());
     				if(link.getRel().equals("approval_url")) {
     					return new ModelAndView("redirect:"+link.getHref());
     				}
     			}
     			
     		} catch (PayPalRESTException e) {
     		
     			e.printStackTrace();
     		}
        	 
        	 
        	 
        	 
        }
        else {
        	orderModel.setPaymentId("COD" + new Date().toString());
        	orderModel.setStatus("ordered");
        	 
        	orderModelRepository.save(orderModel);
             
            orderModelService.copyCartToOrders(userModel, orderModel);
             
            cartItemModelRepository.deleteAllByUserIdAndProceedToPayment(userModel, true);
             
                        
            mandv.addObject("orderStatus", "Successful! Order placed!");
            Set<OrderModel> Orders = orderModelRepository.findAllByUserId(userModel.getEmail());
            mandv.addObject("orders", Orders);
            
            mandv.addObject("title", "Orders");
            
    		mandv.setViewName("customer/orders");
        }
        
        return mandv;
		
	}
	
	@GetMapping(path="paymentSuccess")
	public ModelAndView paymentSuccess(ModelAndView mandv, HttpServletRequest request) {
        UserModel userModel = userModelService.extractUserModel(request);
		
        mandv.addObject("orderStatus", "Payment Done Successfully! Order placed!");
        
        Set<OrderModel> Orders = orderModelRepository.findAllByUserId(userModel.getEmail());
        mandv.addObject("orders", Orders);
        
        mandv.addObject("title", "Orders");
        
		mandv.setViewName("customer/orders");
        return mandv;
		
	}
	
	
	@GetMapping(path="orders")
	public ModelAndView getUserOrders(ModelAndView mandv, HttpServletRequest request) {
        UserModel userModel = userModelService.extractUserModel(request);
		
        Set<OrderModel> Orders = orderModelRepository.findAllByUserId(userModel.getEmail());
        
        mandv.addObject("orders", Orders);
        
        mandv.addObject("title", "Orders");
        mandv.setViewName("customer/orders");
        return mandv;
		
	}
	
	@GetMapping(path="allOrders")
	public ModelAndView getAllOrders(ModelAndView mandv, HttpServletRequest request) {
		        
        mandv.addObject("orders", orderModelRepository.findAll());
        mandv.addObject("title", "Orders");
        mandv.setViewName("admin/orders");
        return mandv;
	}
	
}
