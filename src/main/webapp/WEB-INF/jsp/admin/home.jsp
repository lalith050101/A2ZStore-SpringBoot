<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:adminLayout>
                        <div class="container mt-2">
                            <div class="row mb-3 ml-5">
                                <c:forEach var="product" items="${productList}" varStatus="status">

                                    <div class="card col-12 col-md-8 col-lg-3 mr-5 mb-3 p-1">

                                        <img  src="${product.imageUrl}" class="card-img-top"
                                            height="300" />
                                        <div class="card-body d-flex flex-column">
                                            <h5 class="card-title"><a class="actionlink"
                                                href="/getProduct/${product.productId}">${product.productName}</a></h5>
                                            <h6>Price: ${product.price}</h6>
                                            <h6>quantity: ${product.quantity}</h6>

                                            <div class="row mt-2">
            
                                                <div class="col-6">
                                                    <a class="actionlink btn btn-primary"
                                                        href="/editProduct/${product.productId}">Edit</a>
                                                </div>
                                                <div class="col-6">
                                                    <a class="actionlink btn btn-danger"
                                                        href="/deleteProduct/${product.productId}">Delete</a>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                </t:adminLayout>