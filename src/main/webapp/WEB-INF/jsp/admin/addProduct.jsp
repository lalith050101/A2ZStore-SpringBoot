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

	<div class="container">
		<div class="row mr-md-4 pr-md-5">
			<div class="col-12 text-center pr-md-5">
				<h2>Add product</h2>
			</div>
		</div>
	</div>

	<div class="container p-2">
		<form:form method="post" action="addProduct" modelAttribute="productModel" >
			<div class="form-group row ml-5">
				<label for="validationDeafult01" class="col-md-2 pl-md-5">Product Name:</label>
				<div class="col-md-6">
					<form:input class="form-control" path="productName" minlength="3" maxlength="30"
						type="text"  id="validationDeafult01" />
				</div>
			</div>

			<div class="form-group row ml-5">
				<label for="validationDeafult02" class="col-md-2 pl-md-5">Price:</label>
				<div class="col-md-6">
					<form:input class="form-control" type="number" path="price"  id="validationDeafult02" />
				</div>
			</div>


			<div class="form-group row ml-5">
				<label for="validationDeafult03" class="col-md-2 pl-md-5">Description:</label>
				<div class="col-md-6">
					<form:textarea  minlength="5" maxlength="250" rows="5" cols="40" path="description" class="form-control"
						id="validationDeafult03" />
				</div>
			</div>

			<div class="form-group row ml-5">
				<label for="validationDeafult04" class="col-md-2 pl-md-5">Quantity:</label>
				<div class="col-md-6">
					<form:input class="form-control"  type="number" path="quantity" 
						id="validationDeafult04" />
				</div>
			</div>

			<div class="form-group row ml-5">
				<label for="validationDeafult05" class="col-md-2 pl-md-5">Category:</label>
				<div class="col-md-6">
					<form:input class="form-control" type="text" path="category" minlength="3" maxlength="30"
						id="validationDeafult05" />
				</div>
			</div>

			<div class="form-group row ml-5">
				<label for="validationDeafult06" class="col-md-2 pl-md-5">Product Image link:</label>
				<div class="col-md-6">
					<form:textarea  path="imageUrl" minlength="5" maxlength="300" rows="5" cols="40" class="form-control"
						id="validationDeafult06" />
				</div>
			</div>

			<div class="form-group row mr-md-4">
				<div class="col-md-11 text-center">
					<button type="submit" class="btn btn-primary">Add Product</button>
				</div>
			</div>


			</form:form>
	</div>
</t:adminLayout>