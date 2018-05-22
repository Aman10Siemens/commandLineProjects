<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
	<link rel="stylesheet" type="text/css" href="resources/theme1/style.css">
<title>Customer registration</title>
</head>
<body>
<h3 align="center">${messege}</h3>
<div class="container" >
	<div class="row">
	<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<h3 align="center">${requestScope.registrationmessage}</h3>
	        <form:errors  path="c.*" />
			<div class="panel panel-default">
			<form method="POST" action="/OnlineFood/customer_registration" class="form-horizontal" >
				<h3>Registration Form</h3>
				<div class="panel-body">
				<div class="form-group">
					<label class="control-label col-sm-4" for="customerName">Customer Name</label>
					<div class="col-sm-8">
						<input type="text" name="customerName" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="customerEmail">Customer Email</label>
					<div class="col-sm-8">
						<input type="email" name="customerEmail" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="password">Password</label>
					<div class="col-sm-8">
						<input type="password" name="password" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="contactNumber">Contact Number</label>
					<div class="col-sm-8">
						<input type="text" name="contactNumber" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="customerAddress">Address</label>
					<div class="col-sm-8">
						<input type="text" name="customerAddress" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					
					<div class="col-sm-offset-2 col-sm-8 text-center">
						<input type="submit" class="btn btn-success btn-lg btn-block" value="Register">
					</div>
	
				</div>
			    </div>
			</form>
			
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
</body>
</html>
