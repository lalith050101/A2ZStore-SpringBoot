<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

				<c:set var="contextPath" value="${pageContext.request.contextPath}" />

				<t:layout>
						
					<div class="container">
						<div class="row mr-md-4 pr-md-5">
							<div class="col-12 text-center pr-md-5">
								<h2>Register</h2>
							</div>
						</div>
					</div>

					<div class="container p-2">
						<form:form method="post" action="signup" modelAttribute="userModel">
							<div class="form-group row ml-5">
								<label for="validationDeafult01" class="col-md-2 pl-md-5">Username</label>
								<div class="col-md-6">
									<form:input class="form-control" path="username" minlength="5" maxlength="30"
										type="text" name="username" id="validationDeafult01" />
								</div>
							</div>

							<div class="form-group row ml-5">
								<label for="validationDeafult02" class="col-md-2 pl-md-5">Email id</label>
								<div class="col-md-6">
									<form:input class="form-control" type="email" path="email" id="validationDeafult02" />
								</div>
							</div>

							<div class="form-group row ml-5">
								<label for="validationDeafult03" class="col-md-2 pl-md-5">Mobile No:</label>
								<div class="col-md-6">
									<form:input class="form-control" type="tel" path="mobileNumber"
										pattern="[6-9]{1}[0-9]{9}" id="validationDeafult03" />
								</div>
							</div>

							<div class="form-group row ml-5">
								<label for="validationDeafult04" class="col-md-2 pl-md-5">Address</label>
								<div class="col-md-6">
									<form:textarea path="address" minlength="5" maxlength="250" class="form-control"
										id="validationDeafult04" />
								</div>
							</div>

							<div class="form-group row ml-5">
								<label for="validationDeafult05" class="col-md-2 pl-md-5">Password</label>
								<div class="col-md-6">
									<form:input class="form-control" path="password" type="password" name="pswrd"
										id="validationDeafult05" />
								</div>
							</div>


							<div class="form-group row mr-md-4">
								<div class="col-md-11 text-center">
									<button type="submit" class="btn btn-primary">Register</button>
								</div>
							</div>

							<div class="col-12 pl-md-5 ml-5">
								Already have an account? <a href="/login">Log In here.</a>
							</div>

							</form:form>
					</div>
				</t:layout>