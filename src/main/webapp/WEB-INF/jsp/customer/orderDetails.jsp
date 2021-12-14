<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:customerLayout>	
	<div align="center">
           <h1 id="pdheading">ORDER ITEMS</h1>
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
                    <td>${status.index + 1}</td>
                    <td>${cartItem.productId.productName}</td>
                    <td>${cartItem.productId.price}</td>
                    <td>${cartItem.quantity}</td>
                    <td>${cartItem.productId.price * cartItem.quantity}</td>
                    <td>
                    	<img style="object-fit: cover;" src="${cartItem.productId.imageUrl}" width="100" height="100"/>
                    </td>         
                </tr>
                </c:forEach>             
            </table>
            <form method="post" action="placeOrder" >
            Name: <input name="name"> <br>
            Address: <textarea name="address" placeholder="type address..." minlength="5" maxlength="300" rows="5" cols="40"></textarea><br>
            Contact No.:<input type="tel" name="contactNumber" pattern="[6-9]{1}[0-9]{9}"/><br> <br>
             
            <input type="radio" id="cod"  name="paymentType" value="COD">
			<label for="cod">Cash on Delivery</label><br>
			<input type="radio" id="OnlinePayment" name="paymentType" value="OnlinePayment">
			<label for="OnlinePayment">Online Payment</label><br>
            <input type="submit" name="submit" value="Place Order">
            </form>
</div>
</t:customerLayout>

