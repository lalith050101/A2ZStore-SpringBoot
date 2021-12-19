<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:customerLayout>
                    

                    <div class="container">
                        <div class="row">
                            <h3 style="color:green" class="col-12 text-center"> ${addToCart} </h3>
                            <h1 class="col-12 text-center mb-4">${productModel.productName}</h1>
                            <div class="col-5 pr-2">
                                <img src="${productModel.imageUrl}" alt="" height="300px" width="300px">
                            </div>
                            <div class="col-7">

                                
                                <p><strong>Price:</strong> ${productModel.price}</p>
                                <p><strong>Category:</strong> ${productModel.category}</p>
                                <p><strong>Description:</strong> ${productModel.description}</p>
                                <p><strong>Available quantity:</strong> ${productModel.quantity}</p>
                                <form:form action="/addToCart/${productModel.productId}" method="post">


                                    <div class="form-group row ml-5">
                                        <label for="validationDeafult01" class="col-md-2 pt-1">Quantity:</label>
                                        <div class="col-md-6">
                                            <input class="form-control" type="number" value="1" name="quantity"
                                                id="validationDeafult01" >
                                        </div>
                                    </div>
                                    <div class="form-group row mr-md-4">
                                        <div class="col-md-11 text-center">
                                            <button type="submit" class="btn btn-primary">Add to Cart</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </t:customerLayout>