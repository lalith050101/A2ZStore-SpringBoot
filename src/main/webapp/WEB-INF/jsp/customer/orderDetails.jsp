<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:customerLayout>
                    <div align="center" class="container">
                        <h1 id="pdheading">ORDER ITEMS</h1>

                        <table class="table" id="cartItems">
                            <thead class="thead-light">
                                <tr>

                                    <th scope="col">S. No</th>
                                    <th scope="col">Product Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th colspan="2" scope="col">Amount</th>


                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cartItem" items="${cartItems}" varStatus="status">


                                    <tr>

                                        <td>${status.index + 1}</td>
                                        <td>${cartItem.productId.productName}</td>
                                        <td>${cartItem.productId.price}</td>
                                        <td>${cartItem.quantity}</td>
                                        <td>${cartItem.productId.price * cartItem.quantity}</td>
                                        <td>
                                            <img style="object-fit: cover;" src="${cartItem.productId.imageUrl}"
                                                width="100" height="100" />
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>


                        <form method="post" action="placeOrder">

                            <div class="form-group row ml-5">
                                <label for="validationDeafult01" class="col-md-2 pl-md-5">Name:</label>
                                <div class="col-md-6">
                                    <input class="form-control" name="name" type="text" id="validationDeafult01">
                                </div>
                            </div>
                            <div class="form-group row ml-5">
                                <label for="validationDeafult02" class="col-md-2 pl-md-5">Address</label>
                                <div class="col-md-6">
                                    <textarea name="address" placeholder="type address..." minlength="5" maxlength="300"
                                        class="form-control" rows="5" cols="40" id="validationDeafult02"></textarea>
                                </div>
                            </div>



                            <div class="form-group row ml-5">
                                <label for="validationDeafult03" class="col-2 pl-5">Mobile No:</label>
                                <div class="col-6">
                                    <input class="form-control" type="tel" name="contactNumber"
                                        pattern="[6-9]{1}[0-9]{9}" id="validationDeafult03" />
                                </div>
                            </div>




                            <div class="custom-control custom-radio row">
                                <input type="radio" id="cod" name="paymentType" class="custom-control-input col-2"
                                    value="COD">
                                <label class="custom-control-label col-2" for="cod"> Cash on Delivery</label>
                            </div>
                            <div class="custom-control custom-radio row">
                                <input type="radio" id="OnlinePayment" name="paymentType"
                                    class="custom-control-input col-2" value="OnlinePayment">
                                <label class="custom-control-label col-2" for="OnlinePayment">Online Payment</label>
                            </div>


                            <div class="form-group row mr-md-4 mt-4">
                                <div class="col-md-11 text-center">
                                    <button type="submit" class="btn btn-primary">Place Order</button>
                                </div>
                            </div>


                        </form>

                    </div>
                </t:customerLayout>