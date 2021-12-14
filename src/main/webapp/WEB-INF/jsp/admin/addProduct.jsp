<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:adminLayout>
	<form:form method="post" action="addProduct" modelAttribute="productModel" >
		Product Name:<form:input path="productName" minlength="3" maxlength="30"/><br> <br>
		Price:<form:input type="number" path="price"/><br> <br>
		Description:<form:textarea path="description" minlength="5" maxlength="750" rows="5" cols="40"/><br> <br>
		Quantity:<form:input type="number" path="quantity"/><br> <br>
		Category:<form:input path="category" minlength="3" maxlength="30"/><br> <br>
		Product Image link:<form:textarea path="imageUrl" minlength="5" maxlength="300" rows="5" cols="40"/><br> <br>
		<input class="nav-btn" type="submit" value="Add Product">
	</form:form>
</t:adminLayout>

