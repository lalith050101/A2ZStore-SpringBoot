<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<t:layout>
	<div class="container">
		<div class="row mr-md-4 pr-md-5">
		  <div class="col-12 text-center pr-md-5">
			  <h2>Login</h2>
		  </div>
		</div>
	 </div>
 
	 <div class="container p-2">
		 <form:form  action="login" method="post"  modelAttribute="loginModel">
			 
		 
			 <div class="form-group row ml-5">
				 <label for="validationDeafult01" class="col-md-2 pl-md-5 col-form-label">Email</label>
				 <div class="col-md-6">
					 <form:input class="form-control" type="email" path="email" 
					 name="username" 
					 id="validationDeafult01"/>
				 </div>
			 </div>
	 
			 <div class="form-group row ml-5">
				 <label for="validationDeafult02" class="col-md-2 pl-md-5 col-form-label">Password</label>
				 <div class="col-md-6">
					 <form:input class="form-control" path="password" minlength="6" maxlength="30" type="password" name="pswrd" id="validationDeafult02"/>
				 </div>
			 </div>
	 
			 <div class="form-group row mr-md-4">
				 <div class="col-11 text-center">
					 <button type="submit" class="btn btn-primary">Login</button>
				 </div>
			 </div>
	 
			 <div class="col-12 pl-5 ml-5">
				 Don't have an account? <a href="/signup">Register here.</a>
			 </div>
			 
		 </form:form>
	 </div>
</t:layout>
	