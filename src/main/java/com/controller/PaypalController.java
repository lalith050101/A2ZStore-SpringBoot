package com.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Order;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.service.OrderModelService;
import com.service.PaypalService;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;
	
	@Autowired
	OrderModelService orderModelService;
	
	 @GetMapping(value = "pay/cancel")
	    public String cancelPay() {
		 	
	        return "customer/paymentFailed";
	    }

	    @GetMapping(value = "pay/success")
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
	        try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            
	            JSONObject obj = new JSONObject(payment.toJSON());
//	            System.out.println("payment id : " + obj.getString("id"));
	           	System.out.println("payment id3 2 : " + obj.getJSONArray("transactions").getJSONObject(0).getString("description"));

	           	
	            if (payment.getState().equals("approved")) {
	            	Long order = Long.parseLong(obj.getJSONArray("transactions").getJSONObject(0).getString("description"));
	            	orderModelService.updatePayment(order, obj.getString("id"));
	            	
	            	System.out.println(obj.getString("intent"));
	            	System.out.println(obj.getString("id"));

	            	
	                return "redirect:/paymentSuccess";
	            }
	        } catch (PayPalRESTException e) {
	         System.out.println(e.getMessage());
	        }
	        return "redirect:/";
	    }

}