package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class CartItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    private ProductModel productId;
    private int quantity;

    @ManyToOne(fetch=FetchType.LAZY)
    private UserModel userId;
    
    private boolean proceedToPayment;

    public CartItemModel() {

    }

	public CartItemModel(Long cartItemId, ProductModel productId, int quantity, UserModel userId,
			boolean proceedToPayment) {
		super();
		this.cartItemId = cartItemId;
		this.productId = productId;
		this.quantity = quantity;
		this.userId = userId;
		this.proceedToPayment = proceedToPayment;
	}

	public void setProductId(ProductModel productId) {
		this.productId = productId;
	}
	
	public ProductModel getProductId() {
		return productId;
	}

	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UserModel getUserId() {
		return userId;
	}

	public void setUserId(UserModel userId) {
		this.userId = userId;
	}

	public boolean isProceedToPayment() {
		return proceedToPayment;
	}

	public void setProceedToPayment(boolean proceedToPayment) {
		this.proceedToPayment = proceedToPayment;
	}
	
}