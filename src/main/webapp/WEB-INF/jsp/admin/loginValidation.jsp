<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>

<%
	response.setHeader("cache-control", "no-cache,no-store,must-revalidate"); ///works after: HTTP 1.1   
	
	response.setHeader("pragma","no-cache"); //HTTP 1.0
	
	response.setHeader("Expires","0"); //Proxies
	
	if(session.getAttribute("email")==null)
	{
		response.sendRedirect("login");
		return;
	}
	
%>


