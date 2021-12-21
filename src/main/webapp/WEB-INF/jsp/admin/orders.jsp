<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:adminLayout>
                    <div align="center">
                        <h1 id="pdheading" class="mb-3">ORDERS</h1>


                        <c:choose>
                            <c:when test="${orders.size() != 0}">
                                <div class="container" align="center">
                                    <div class="row ml-5">
                                        <div class="col-4">

                                        </div>
                                        <div class="col-3">
                                            <table class="table">
                                                <thead class="thead-light">
                                                    <tr>

                                                        <th scope="col">Order ID</th>
                                                        <th></th>

                                                    </tr>
                                                </thead>

                                                <c:forEach var="order" items="${orders}" varStatus="status">

                                                    <tbody>
                                                        <tr>
                                                            <td>${order.id}</td>
                                                            <td><a class="actionlink btn btn-primary"
                                                                    href="/getOrder/${order.id}">View order</a></td>
                                                        </tr>

                                                    </tbody>
s                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </div>

                            </c:when>
                            <c:otherwise>
                                <h3 style="color:slategray"> No orders :(</h3>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </t:adminLayout>