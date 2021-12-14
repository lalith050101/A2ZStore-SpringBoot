<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:customerLayout>
	<div align="center">	
           <h1 id="pdheading">CART ITEMS</h1>
           
           <c:set var="inputDisplay" value="1" /> <!-- This same as your request attribute -->
			<c:choose>
			    <c:when test="${cartItems.size() != 0}">
			        
			    
    	   <form method="post" action="proceedOrder" >
            <table id="cartItems" >
                <tr >
                <th>S. No </th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Amount</th>
                <th colspan="2" >ACTION</th>
                 </tr>
                
                <c:forEach var="cartItem" items="${cartItems}" varStatus="status">
                <tr>
                	<td>
                	<input type="checkbox" value="${cartItem.cartItemId}" name="proceedToPayment">
                	</td>
                    <td>${status.index + 1}</td>
                    <td>${cartItem.productId.productName}</td>
                    <td>${cartItem.productId.price}</td>
                    <td>
	             	<input type="number" value="${cartItem.quantity}" name="quantity" required>
	             	
	             	</td>
                    
                    <td>${cartItem.productId.price * cartItem.quantity}</td>
                    <td>    
                        <a class="actionlink" href="/getProduct/${cartItem.productId.productId}">View</a>
                    </td>
                    <td>
                    	<a class="actionlink" href="/removeCartItem/${cartItem.cartItemId}">Remove</a>
                    </td>
                    <td>
                    	<img style="object-fit: cover;" src="${cartItem.productId.imageUrl}" width="100" height="100"/>
                    </td>         
                </tr>
                </c:forEach>             
            </table>
            
            <input type="submit" name="submit" value="Proceed Order">
            </form>
            
            </c:when>
			    <c:otherwise>
			        <h2> No items added to cart</h2>
			    </c:otherwise>      
			</c:choose>
        </div>
</t:customerLayout>

