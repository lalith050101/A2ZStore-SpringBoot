<%@page import="java.util.ResourceBundle" %>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

		<%@ include file="loginValidation.jsp" %>



			<div class="container-fluid mb-2 p-0">
				<nav class="navbar navbar-dark navbar-expand-md bg-dark">
					<a class="navbar-brand" href="/adminHome" style="color: white;">A2Z</a>

					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler"
						aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse" id="navbarToggler">
						<ul class="navbar-nav ml-auto">

							<li class="nav-item">
								<a class="nav-link" href="/adminHome" style="color: white;">Home</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/allOrders" style="color: white;">All Orders</a>
							</li>

							<li class="nav-item">
								<a class="nav-link" href="/addProduct" style="color: white;">Add Product</a>
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