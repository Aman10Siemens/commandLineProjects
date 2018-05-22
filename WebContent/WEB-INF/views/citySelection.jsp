<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
	<link rel="stylesheet" type="text/css" href="resources/theme1/style.css">
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<div class="container">
<h2 style="color:yellow">Welcome ${valid_cust.customerName}</h2>
<h4 align="left"><a href="clogout"><h4 style="color:yellow">logout</h4></a></h4>
<!--<h3>${status}</h3>
<h3>customer details are:${valid_cust}</h3>-->
<br><br>
<h3>Select city to serve your meal</h3>
<form method="post" action="orderDirectCity">
<select name="city" class="form-control">
<option value="Pune">Pune</option>
<option value="Bhopal">Bhopal</option>
<option value="Delhi">Delhi</option>
</select><br><br>
<div align="center"><input type="Submit"  value="Select city" class="btn btn-success btn-lg"/></div>>
 
</form>
</div>
</body>
</html>