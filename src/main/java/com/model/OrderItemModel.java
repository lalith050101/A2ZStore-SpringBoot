package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class OrderItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne
    private ProductModel productId;
    
    private String productName;
    
    private String price;
    
    private int quantity;

    @ManyToOne(fetch=FetchType.LAZY)
    private OrderModel orderId;
    
    public OrderItemModel() {

    }

	public OrderItemModel(Long orderItemId, ProductModel productId, String productName, String price, int quantity,
			OrderModel orderId) {
		super();
		this.orderItemId = orderItemId;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}


	public ProductModel getProductId() {
		return productId;
	}


	public void setProductId(ProductModel productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public OrderModel getOrderId() {
		return orderId;
	}


	public void setOrderId(OrderModel orderId) {
		this.orderId = orderId;
	}
}