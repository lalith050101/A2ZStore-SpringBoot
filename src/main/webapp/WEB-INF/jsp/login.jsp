<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

				<c:set var="contextPath" value="${pageContext.request.contextPath}" />

				<t:layout>
					<section class="vh-100">
						<div class="container py-1 h-100">
							<div class="row d-flex justify-content-center h-100">
								<div class="col-12 col-md-8 col-lg-6 col-xl-5">
									<div>
										<div class="card-body p-3">

											<h3 class="mb-5 d-flex justify-content-center">Login</h3>
											<form:form action="login" method="post" modelAttribute="loginModel">
												<div class="form-group d-flex justify-content-center" style="color:red">
													<p>${errorMessage}</p>
												</div>

												<div class="form-outline mb-4">
													<label class="form-label text-left" for="typeEmailX">Email</label>
													<form:input id="typeEmailX" class="form-control form-control-lg"
														type="email" path="email" name="username" />

												</div>

												<div class="form-outline mb-4">
													<label class="form-label" for="typePasswordX">Password</label>
													<form:input id="typePasswordX" class="form-control form-control-lg"
														path="password" minlength="6" maxlength="30" type="password"
														name="pswrd" />

												</div>


												<button class="btn btn-primary btn-lg btn-block"
													type="submit">Login</button>
												<hr class="my-4">

											</form:form>

											<p class="mb-0">Don't have an account? <a href="/signup"
													class="text-white-50 fw-bold">Sign Up</a></p>

										</div>
									</div>
								</div>
							</div>
						</div>

					</section>
				</t:layout>