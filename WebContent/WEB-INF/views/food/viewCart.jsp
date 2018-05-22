<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pojos.FoodItem ,java.util.*,java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Cart Details</title>
 <link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
</head>
<body>
<h3>Customer name : ${valid_cust.customerName}</h3>

<div class="container">
<h3>Cart Details:</h3>
<div class="table-responsive">
<table class="table" id="tb">
<thead>
 <tr>
 <th>Food Name</th>
  <th>Food Type</th> 
  <th>Food Category</th>
  <th>Price</th>
   <th>Quantity</th>
 <tr>
</thead>

<c:forEach var="listCart" items="${FoodInCart}">
<tbody>
<tr>
<td>${listCart.foodname}</td>
<td>${listCart.foodType}</td>
<td>${listCart.foodCategory}</td>
<td>${listCart.price}</td>
<td><%  FoodItem f =(FoodItem) pageContext.getAttribute("listCart"); String s="food"+f.getFoodid();   
 
    
 
 if(session.getAttribute(s)==null)
 {
	out.print("0");	 
 }
 else
 {
 out.print(session.getAttribute(s));
 }
 %></td>
</tr>
</tbody>
</c:forEach>


</table>
</div>
<h1>Your bill is:${total}</h1>
<br><br>
<h4>We Currently support cash on Delivery only.</h4>
<br>
<form method="post" action="saveOrder">
Enter Shipping details:<input type="text" name="ShippingAddress" >
<input type="hidden" name="customerId" value="${valid_cust.customerId}">
<input type="hidden" name="totalBill" value="${total}">
<input type="hidden" name="OrderDate" value="<%=  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format( new Date())%>">
<input type="submit" value="OrderNow">
</form>
</body>
</html>












<!-- 
<table border=5>
<tr><th>Food name</th><th>Food Category</th><th>food Type</th><th>price </th><th>quantity </th></tr>
<c:forEach var="listCart" items="${FoodInCart}">
<tr><td>${listCart.foodname}</td>
<td>${listCart.foodCategory}</td>
<td>${listCart.foodType}</td>
<td>${listCart.price}</td>
<td></td>
</tr>
</c:forEach>
</table>/ -->