<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:customerLayout>
                    <div align="center">
                        <h1 id="pdheading">ORDERS</h1>
                        
                        <h3 style="color:green"> ${orderStatus} </h3>
                        
                        
                        <c:choose>
                            <c:when test="${orders.size() != 0}">
									
                                    <c:forEach var="order" items="${orders}" varStatus="status">
                                    
                                   
                                    
                                   
									
                                        <div class="container mt-2">
                                        
                                        
                                        <table class="table">
									  <thead class="thead-light">
									    <tr>
									    	
	                                        <th scope="col">Order ID</th>
	                                        <th scope="col">Total Price</th>
	                                        <th scope="col">Name</th>
	                                        <th scope="col">Address</th>
	                                        <th scope="col">Contact No.</th>
									      
									    </tr>
									  </thead>
									  <tbody>
									    <tr>
                                            <th scope="row">${order.id}</th>
                                            <td>${order.totalPrice}</td>
                                            <td>${order.name}</td>
                                            <td>${order.address}</td>
                                            <td>${order.contactNumber}</td>
									    </tr>
									    
									  </tbody>
									</table>
                                        
                                            <div class="row mb-3 ml-5">
                                        
                                                <c:forEach var="orderItem" items="${order.orderItems}"
                                                    varStatus="status">
                                                    <div class="card col-12 col-md-8 col-lg-3 mr-5 mb-3 p-1">

                                                        <img src="${orderItem.productId.imageUrl}" class="card-img-top"
                                                            height="300" />
                                                        <div class="card-body d-flex flex-column">
                                                            <h5 class="card-title"><a class="actionlink"
                                                                    href="/getProduct/${orderItem.productId.productId}">${orderItem.productName}</a>
                                                            </h5>
                                                            <h6>Price: ${orderItem.quantity}</h6>
                                                            <h6>quantity: ${orderItem.quantity}</h6>

                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                       
                                    </c:forEach>                        
                            </c:when>
                            <c:otherwise>
                                <h2> Not Ordered any item yet! </h2>
                                <a href="/cart"> Order items from cart </a>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </t:customerLayout>