<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Admin home page</title>
</head>
<body style="background-color:skyblue;">
<h1>Welcome to ${valid_adminobj.adminName}</h1>
<h3>${status}</h3>

<a href="listAllVendor">Click to view list of all vendor</a>
<a href="listAllCustomer">Click to view list of all customer</a>
</body>
</html>