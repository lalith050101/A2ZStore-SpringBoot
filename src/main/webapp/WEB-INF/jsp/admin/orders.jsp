<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:adminLayout>
                    <div align="center">
                        <h1 id="pdheading">ORDERS</h1>
                            <div>
                                <th>S. No.</th>
                                <th>Order ID</th>
                                <th>Total Price</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Contact No.</th>
                            </div>

                            <c:forEach var="order" items="${orders}" varStatus="status">
                                <div>

                                    <td>${status.index + 1}</td>
                                    <td>${order.id}</td>
                                    <td>${order.totalPrice}</td>
                                    <td>${order.name}</td>
                                    <td>${order.address}</td>
                                    <td>${order.contactNumber}</td>
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
                            </c:forEach>
                    </div>
                </t:adminLayout>