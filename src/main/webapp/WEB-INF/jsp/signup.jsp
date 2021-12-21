<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

				<c:set var="contextPath" value="${pageContext.request.contextPath}" />

				<t:layout>
					<section class="vh-100">
						<div class="container py-2 h-100">
							<div class="row d-flex justify-content-center h-100">
								<div class="col-12 col-md-8 col-lg-6 col-xl-5">
									<div>
										<div class="card-body p-1">
											<h3 class=" d-flex justify-content-center">Sign Up</h3>
											<form:form action="signup" method="post" modelAttribute="userModel">
												<div class="form-group d-flex justify-content-center" style="color:red">
													<p>${errorMessage}</p>
												</div>
										</div>

										<div class="form-outline mb-4">
											<label class="form-label text-left"
												for="validationDeafult01">Username</label>
											<form:input id="validationDeafult01" class="form-control form-control-lg"
												type="text" path="username" minlength="5" maxlength="30"
												name="username" />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label text-left" for="validationDeafult02">Email</label>
											<form:input id="validationDeafult02" class="form-control form-control-lg"
												type="email" path="email" name="username" />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label text-left" for="validationDeafult03">Mobile
												No</label>
											<form:input id="validationDeafult03" class="form-control form-control-lg"
												type="tel" path="mobileNumber" pattern="[6-9]{1}[0-9]{9}"
												name="username" />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label text-left"
												for="validationDeafult04">Address</label>
											<form:textarea id="validationDeafult04" class="form-control form-control-lg"
												path="address" minlength="5" maxlength="250" name="username" />
										</div>

									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="validationDeafult05">Password</label>
										<form:input id="validationDeafult05" class="form-control form-control-lg"
											path="password" minlength="6" maxlength="30" type="password" name="pswrd" />
									</div>


									<button class="btn btn-primary btn-lg btn-block" type="submit">Register</button>
									<hr class="my-4">

									</form:form>

									<p class="mb-0">Already have an account? <a href="/login"
											class="text-white-50 fw-bold">Log In here</a></p>

								</div>
							</div>
						</div>
						</div>
						</div>

					</section>
				</t:layout>