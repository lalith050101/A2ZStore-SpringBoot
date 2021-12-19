<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:adminLayout>
                    <div align="center">
                        <h1 id="pdheading">ORDER</h1>
   
   				
					<div class="container p-2">
						
							
                            
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
					</div>
					
					

		                    <div class="container mt-2">
		                        <div class="row mb-3 ml-5">
		                            <c:forEach var="orderItem" items="${order.orderItems}" varStatus="status">
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

                    </div>
                </t:adminLayout>