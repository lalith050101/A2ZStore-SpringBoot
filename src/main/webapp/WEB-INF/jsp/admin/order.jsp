<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:adminLayout>
                    <div align="center">
                        <h1 id="pdheading">ORDERS</h1>
   
   				<center>
					<div class="container p-2">
						
							<div class="form-group row ml-5">
								<label for="validationDeafult02" class="col-md-7 pl-md-5"><strong>Order Id</strong></label>
								<div class="col-1">
									${order.id}
								</div>
							</div>
							<div class="form-group row ml-5">
								<label for="validationDeafult01" class="col-md-7 pl-md-5"><strong>Total Price</strong></label>
								<div class="col-md-1">
								${order.totalPrice}
								</div>
							</div>
							<div class="form-group row ml-5">
								<label for="validationDeafult03" class="col-md-7 pl-md-5"><strong>Customer Name</strong></label>
								<div class="col-md-1">
									${order.name}
								</div>
							</div>

							<div class="form-group row ml-5">
								<label for="validationDeafult04" class="col-md-7 pl-md-5"><strong>Address</strong></label>
								<div class="col-md-1">
									${order.address}
								</div>
							</div>

							<div class="form-group row ml-5">
								<label for="validationDeafult05" class="col-md-7 pl-md-5"><strong>Contact Number</strong></label>
								<div class="col-md-1">
									${order.contactNumber}
								</div>
							</div>

					</div>
					
					</center>

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