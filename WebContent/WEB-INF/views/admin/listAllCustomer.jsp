<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customers List</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
</head>
<body>
<div class="container">
<h3 align="center" style="color:green">Customers List</h3>
<div class="table-responsive">
<table class="table ">
<thead><tr><th>Customer Name</th><th>CustomerEmail</th><th>CustomerContactNumber</th><th>CustomerAddress</th><th>CustomerId</th><th>delete</th><th>update</th></tr></thead>
<c:forEach   var="customer" items="${customerList}">

<tr>
<td>${customer.customerName}</td>
<td>${customer.customerEmail}</td>
<td>${customer.contactNumber}</td>
<td>${customer. customerAddress}</td>

<td>${customer.customerId}</td>
<td><a href="CustomerDelete?id=${customer.customerId}">delete</a></td>
<td><a href="updateCustomer?id=${customer.customerId}">update</a></td>
</tr>

</c:forEach></table>
</div>
</div>

</body>
</html>