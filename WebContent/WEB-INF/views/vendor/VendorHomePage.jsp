<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"><u>Welcome to ${valid_vendorobj.restaurantName}</u></h1>
<!-- <h3>${status}</h3>  -->


<!--Name:${valid_vendorobj.restaurantName}</br> -->
<div align="right"><h3>Contact Num:</h3>${valid_vendorobj.vcontactNo}</br>
<h3>Email:</h3>${valid_vendorobj.vendorEmail}</div>

<div class="container">
<h3>Food Items</h3>
<div class="table-responsive">
<table class="table " id="tb">
<thead>
 <tr>
  <th>#</th>
  <th>Food Name</th>
  <th>Food Type</th> 
  <th>Food Category</th>
 <tr>
</thead>

<c:forEach var="local" items="${foodlist}">
<tbody>
<tr>
<td>${local.foodid}</td>
<td>${local.foodname}</td>
<td>${local.foodType}</td>
<td>${local.foodCategory}</td>
<td><a href="deleteFoodDetails?foodid=${local.foodid}">Remove Food</a></td>
</tr>
</tbody>
</c:forEach>


</table>
</div>
</div>





<form action="addFood" method="GET">
<div align="center"><input type="submit" value ="Add Food Item" ></div>
</form>








</body>
</html>