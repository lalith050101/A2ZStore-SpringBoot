package com.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private Long totalPrice;

    private String userId;

    private String name;

    private String contactNumber;
    
    private String address;
    
    private String paymentType;
	
    private String paymentId;
    
    private String status;
    
    @OneToMany(mappedBy="orderId",fetch=FetchType.LAZY)
    private Set<OrderItemModel> orderItems;
    
    public OrderModel() {
		// TODO Auto-generated constructor stub
	}

	public OrderModel(Long id, Long totalPrice, String userId, String name, String contactNumber, String address,
			String paymentType, String paymentId, String status, Set<OrderItemModel> orderItems) {
		super();
		Id = id;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.address = address;
		this.paymentType = paymentType;
		this.paymentId = paymentId;
		this.status = status;
		this.orderItems = orderItems;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<OrderItemModel> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItemModel> orderItems) {
		this.orderItems = orderItems;
	}
}
