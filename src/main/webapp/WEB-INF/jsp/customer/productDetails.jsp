<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:customerLayout>
	<div align="center" class="product-list">
           <h1 id="pdheading">${productModel.productName}</h1>
            <h3 style="color:green"> ${addToCart} </h3>
            <table id="products" >
                
                <tr>
                <th>Price</th>
                <td>${productModel.price}</td>
                </tr>
                <tr>
                <th>Category</th>
                <td>${productModel.category}</td>
                </tr> 
                <tr>
                <th>Description</th>
                <td>${productModel.description}</td>
                </tr> 
                <tr>
                <th>Available Quantity</th>
                <td>${productModel.quantity}</td>
                </tr>
                
                <tr>
                <td><img src="${productModel.imageUrl}" width="200" height="200"/></td>
                </tr>                          
            </table>
            <br>
            
            <form:form  action="/addToCart/${productModel.productId}" method="post">
				Quantity:<input type="number" value="1" name="quantity"/>
			<input class="nav-btn" type="submit" value="Add to Cart">
			</form:form>                        
        </div>	
</t:customerLayout>
        