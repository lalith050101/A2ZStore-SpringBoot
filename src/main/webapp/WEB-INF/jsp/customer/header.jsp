<%@page import="java.util.ResourceBundle" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

		<%@ include file="loginValidation.jsp" %>


			<div class="container-fluid mb-2 p-0">
				<nav class="navbar navbar-dark navbar-expand-md bg-dark">
					<a class="navbar-brand" href="/home" style="color: white;">A2Z</a>

					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
						aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarToggler">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item">
								<a class="nav-link" href="/home" style="color: white;">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/orders" style="color: white;">My Orders</a>
							</li>

							<li class="nav-item">
								<a class="nav-link" href="/cart" style="color: white;">Cart</a>
							</li>

							<li class="nav-item">
								<a class="nav-link" href="/profile" style="color: white;">Profile</a>
							</li>


							<li class="nav-item p-1 mt-1">
								<p style="color: white;"><strong>${username}</strong></p>
							</li>



							<li class="nav-item">
								<a class="nav-link" href="/logout" style="color: white;">Logout</a>

							</li>

						</ul>
					</div>
				</nav>
			</div>
			</header>