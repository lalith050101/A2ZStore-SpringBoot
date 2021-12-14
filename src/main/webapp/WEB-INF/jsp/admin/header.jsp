<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="loginValidation.jsp" %>
	
<div style="display:flex; justify-content:space-between; align-items:center">
	<h1><a href="/adminHome">A2Z</a></h1>

	<div class="nav-right">
		<h2> <a class="nav-btn" href="/allOrders">All Orders</a></h2>
		<h2> <a class="nav-btn" href="/addProduct">Add Product</a></h2>
		<h2 style="padding:3px">
			${username}
		</h2>
		<form action="/logout" method="post">
			<input type="submit" class="nav-btn" value="Logout">
		</form>
	</div>
</div>
