<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

                <c:set var="contextPath" value="${pageContext.request.contextPath}" />

                <t:adminLayout>
                    <div align="center">
                        <h1 id="pdheading" class="mb-3">ORDERS</h1>
                            

                            <c:forEach var="order" items="${orders}" varStatus="status">
                            <div class="container">
                            	<div class="row m-1">
	                            	<div class="col-6 text-right">
	                            		<h4>Order Id: ${order.id} </h4>
	                            	</div>
	                            	<div class="col-2">
	                                    <a class="actionlink btn btn-primary"
	                                        href="/getOrder/${order.id}">View order</a>
	                                </div>
                                </div>
                            </div>
                               
                            </c:forEach>
                    </div>
                </t:adminLayout>