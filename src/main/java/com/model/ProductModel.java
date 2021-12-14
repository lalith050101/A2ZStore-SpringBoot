package com.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(columnDefinition = "text")
    private String imageUrl;

    private String productName;

    private String price;

    @Column(columnDefinition = "text")
    private String description;

    private String quantity;
    
    private String category;
    
    @OneToMany(mappedBy="productId",fetch=FetchType.LAZY)
    private Set<CartItemModel> cartItems;

    public ProductModel() {

    }

	public ProductModel(Long productId, String imageUrl, String productName, String price, String description,
			String quantity, String category, Set<CartItemModel> cartItems) {
		super();
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.cartItems = cartItems;
	}



	public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public void setCategory(String category) {
		this.category = category;
	}
    
    public String getCategory() {
		return category;
	}
    
    public void setCartItems(Set<CartItemModel> cartItems) {
		this.cartItems = cartItems;
	}
    
    public Set<CartItemModel> getCartItems() {
		return cartItems;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartItems, category, description, imageUrl, price, productId, productName, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductModel other = (ProductModel) obj;
		return Objects.equals(productId, other.productId);
	}
    
    
}