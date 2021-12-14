<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:adminLayout>
	<div align="center">	
           <h1 id="pdheading">ORDERS</h1>
            <table id="cartItems" >
                <tr >
                <th>S. No.</th>
                <th>Order ID</th>
                <th>Total Price</th>
                <th>Name</th>
                <th>Address</th>
                <th>Contact No.</th>
                 </tr>
                
                <c:forEach var="order" items="${orders}" varStatus="status">
                <tr>
                	
                    <td>${status.index + 1}</td>
                    <td>${order.id}</td>
                    <td>${order.totalPrice}</td>
                    <td>${order.name}</td>
                    <td>${order.address}</td>
	             	<td>${order.contactNumber}</td>       
                </tr>
                <tr >
                <th></th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Price</th>
                 </tr>
                <c:forEach var="orderItem" items="${order.orderItems}" varStatus="status">
                <tr>
                	<td></td>
                    <td>${orderItem.productName}</td>
                    <td>${orderItem.quantity}</td>
                    <td>${orderItem.price}</td>
                    <td><img style="object-fit: cover;" src="${orderItem.productId.imageUrl}"  width="100" height="100"></td>
                    <td>    
                        <a class="actionlink" href="/getProduct/${orderItem.productId.productId}">View</a>
                    </td>
                </tr>
                </c:forEach>   
                </c:forEach>             
            </table>            
        </div>
</t:adminLayout>

