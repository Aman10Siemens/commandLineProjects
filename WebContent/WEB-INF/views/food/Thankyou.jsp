<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thank you </title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
</head>
<body>
<div class="container">
  <h2>Thank you for ordering with us ,happy to serve you</h2>
            
  <table border=2 class="table table-hover">
   
    <tbody>
     <tr><td>Order Id:</td>
     <td>${order_obj.orderId}</td></tr>
      <tr><td>Order Date:</td>
     <td>${order_obj.orderDate}</td></tr>
      <tr><td>Order Shipping Address:</td>
     <td>${order_obj.shippingAddress}</td></tr>
      <tr><td>Order Total Bill:</td>
     <td>${order_obj.totalBill}</td></tr>
  </table>
</div>

</body>
</html>

