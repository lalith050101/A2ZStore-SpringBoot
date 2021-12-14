<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:customerLayout>
	<div align="center" class="product-list">
           
            <table id="products" >
                <tr >
                <th>S. No </th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Category</th>
                <th>IMAGE</th>
                <th colspan="2" >ACTION</th>
                 </tr>
                <c:forEach var="product" items="${productList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.category}</td>
                    <td><img style="object-fit: cover;" src="${product.imageUrl}" width="100" height="100"/></td>
                    <td>    
                        <a class="actionlink" href="/getProduct/${product.productId}">View</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
</t:customerLayout>

