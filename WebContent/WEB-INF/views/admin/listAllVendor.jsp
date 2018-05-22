<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vendor List</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
</head>
<body>
<div class="container">
<h3 align="center" style="color:green">Vendors List</h3>
<div class="table-responsive">
<table class="table ">
<thead><tr><th>Resturant Name</th><th>city</th><th>vaddress</th><th>vendorEmail</th><th>vendorid</th><th>delete</th><th>update</th></tr></thead>
<c:forEach   var="vendor" items="${vendorsList}">

<tr>
<td>${vendor.restaurantName}</td>
<td>${vendor.city}</td>
<td>${vendor.vaddress}</td>
<td>${vendor. vendorEmail}</td>

<td>${vendor.vendorid}</td>
<td><a href="VendorDelete?id=${vendor.vendorid}">delete</a></td>
<td><a href="updateVendor?id=${vendor.vendorid}">update</a></td>
</tr>

</c:forEach></table>
</div>
</div>
</body>
</html>