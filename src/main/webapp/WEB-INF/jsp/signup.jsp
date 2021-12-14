<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:layout>
	<form:form method="post" action="signup" modelAttribute="userModel" >
		UserName:<form:input path="username" minlength="5" maxlength="30"/><br> <br>
		Email:<form:input type="email" path="email"/><br> <br>
		Mobile No.:<form:input type="tel" path="mobileNumber" pattern="[6-9]{1}[0-9]{9}"/><br> <br>
		Address:<form:textarea path="address" minlength="5" maxlength="250"/><br> <br>
		Password:<form:input type="password" path="password" minlength="6" maxlength="30"/><br> <br>
		
	<input class="nav-btn" type="submit" value="Signup">
	</form:form>
</t:layout>


