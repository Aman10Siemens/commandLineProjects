<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<a align="center" style="color:blue" href="javascript:history.go(-1)">Go Back</a>
<div>
<h4 align="right"><a href="clogout"><h3 style="color:sky blue"><i>Logout</i></h3></a></h4></div>
<h3>Click on the restaurant image to select any restaurant</h3>
<table>
<c:forEach var="local" items="${VendorList}">
<tr><td><a href="foodMenu?vendorid=${local.vendorid}"><img src="${local.vimage}"></a></td></tr>
<tr><td>${local.restaurantName}</td></tr>
	
</c:forEach>
</table>
</body>
</html>