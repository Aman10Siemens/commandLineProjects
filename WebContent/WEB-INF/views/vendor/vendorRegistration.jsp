<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" type="text/css" href="resources/theme1/style.css">
</head>
<body>
<!--  <h3 align="center">${messege2}</h3> -->	

	
<div class="container" >
	<div class="row">
	<div class="col-sm-3"></div>
		<div class="col-sm-6">
		<h3 align="center">${requestScope.registrationmessage}</h3>
			<form:errors path="v.*" />
			<div class="panel panel-default">
			<form method="POST" action="vendorRegister" class="form-horizontal" enctype="multipart/form-data">
				<h3>Vendor Registration Form</h3>
				<div class="panel-body">
				<div class="form-group">
					<label class="control-label col-sm-4" for="restaurantName">Restaurant Name</label>
					<div class="col-sm-8">
						<input type="text" name="restaurantName" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="vendorEmail">Vendor Email</label>
					<div class="col-sm-8">
						<input type="email" name="vendorEmail" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="vpassword">Vendor Password</label>
					<div class="col-sm-8">
						<input type="password" name="vpassword" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="vcontactNo">Restaurant Contact Number</label>
					<div class="col-sm-8">
						<input type="text" name="vcontactNo" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="vaddress">Restaurant Address</label>
					<div class="col-sm-8">
						<input type="text" name="vaddress" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="city">Restaurant City</label>
					<div class="col-sm-8">
						<select class="form-control" name="city">
			                 <option value="Pune">Pune</option>
			                 <option value="Bhopal">Bhopal</option>
			                 <option value="Delhi">Delhi</option>
			            </select> 
					</div>
	
				</div>
                <div class="form-group">
					<label class="control-label col-sm-4" for="file">Restaurant Image</label>
					<div class="col-sm-8">
						<input type="file" name="file" class="form-control-file">
					</div>
	
				</div>
				<div class="form-group">
					
					<div class="col-sm-offset-2 col-sm-8 text-center">
						<input type="submit" class="btn btn-success btn-lg btn-block" value="Register Vendor">
					</div>
	
				</div>
			    </div>
			</form>
			
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
</div>
</body>
</html>