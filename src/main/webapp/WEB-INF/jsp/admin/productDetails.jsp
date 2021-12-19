<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:adminLayout>
   	
        <div class="container">
            <div class="row">
                <h1 class="col-12 text-center mb-4">${productModel.productName}</h1> 
                <div class="col-5 pr-2">
                    <img src="${productModel.imageUrl}" alt="" height="300px" width="300px">
                </div>
                <div class="col-7">
                    
                    <p><strong>Product ID:</strong>  ${productModel.productId}</p>
                    <p><strong>Price:</strong> ${productModel.price}</p>
                    <p><strong>Category:</strong> ${productModel.category}</p>
                    <p><strong>Description:</strong> ${productModel.description}</p>
                    <p><strong>Quantity:</strong> ${productModel.quantity}</p>
                </div>
            </div>
        </div>
</t:adminLayout>
        