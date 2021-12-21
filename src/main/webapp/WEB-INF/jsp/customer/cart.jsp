<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:customerLayout>
                    <div align="center" class="container">
                        <h1 id="pdheading">CART ITEMS</h1>

                        <c:set var="inputDisplay" value="1" /> <!-- This same as your request attribute -->
                        <c:choose>
                            <c:when test="${cartItems.size() != 0}">


                                <form method="post" action="proceedOrder">

                                    <table class="table" id="cartItems">
                                        <thead class="thead-light">
                                            <tr>
                                                <th scope="col"></th>
                                                <th scope="col">S. No</th>
                                                <th scope="col">Product Name</th>
                                                <th scope="col">Price</th>
                                                <th scope="col">Quantity</th>
                                                <th scope="col">Amount</th>
                                                <th colspan="3" class="pl-5">Action</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="cartItem" items="${cartItems}" varStatus="status">


                                                <tr>
                                                    <th scope="row"><input type="checkbox"
                                                            value="${cartItem.cartItemId}" name="proceedToPayment"></th>
                                                    <td>${status.index + 1}</td>
                                                    <td>${cartItem.productId.productName}</td>
                                                    <td>${cartItem.productId.price}</td>
                                                    <td><input type="number" value="${cartItem.quantity}"
                                                            onchange="changeQuantity(this)" name="quantity"
                                                            id="${cartItem.cartItemId}" required></td>
                                                    <div style="display:none" id="productId">${cartItem.cartItemId}
                                                    </div>

                                                    <td>${cartItem.productId.price * cartItem.quantity}</td>
                                                    <td>
                                                        <a class="actionlink btn btn-primary"
                                                            href="/getProduct/${cartItem.productId.productId}">View</a>
                                                    </td>
                                                    <td>
                                                        <a class="actionlink btn btn-danger"
                                                            href="/removeCartItem/${cartItem.cartItemId}">Remove</a>
                                                    </td>
                                                    <td>
                                                        <img style="object-fit: cover;"
                                                            src="${cartItem.productId.imageUrl}" width="100"
                                                            height="100" />
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>


                                    <input type="submit" name="submit" value="Proceed Order">
                                </form>

                            </c:when>
                            <c:otherwise>
                                <h3 style="color:slategray"> No items added to cart</h3>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <script>
                        function changeQuantity(e) {
                            var qnty = e.value;
                            var cartItemId = e.id;

                            console.log(cartItemId + " : " + qnty);
                            var xmlHttp = new XMLHttpRequest();
                            xmlHttp.open("GET", "updateCart/" + cartItemId + "/" + qnty, false); // false for synchronous request
                            xmlHttp.send(qnty);
                            return xmlHttp.responseText;
                        }


                        $(document).ready(function(){
                            $("form").submit(function(){
                        if ($('input:checkbox').filter(':checked').length < 1){
                                alert("Please Check at least one cart item");
                        return false;
                        }
                            });
                        });
                    </script>
                </t:customerLayout>