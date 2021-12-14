<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:layout>
	<form:form  action="login" method="post"  modelAttribute="loginModel">
		Email:<form:input type="email" path="email"/>
		Password:<form:input type="password" path="password" minlength="6" maxlength="30"/>
	<input class="nav-btn" type="submit" value="Login">
	</form:form>
</t:layout>
	