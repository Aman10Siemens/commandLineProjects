<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="resources/theme1/custom.css">
</head>
<body>
	<h1 align="center">Foood@Home</h1>

<div class="container" style="margin-top:100px;">

	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<h4>Vendor Login Form</h4>
				<!-- <span><i class="fa fa-facebook"></i></span> -->
			
			
				<hr>
				<div class="panel-body">
				<h2>${requestScope.message}</h2> 
					<form action="/OnlineFood/VendorLoginValidate" method="POST">
						
						<div class="form-group">
						  
							<input type="email" name="vendorEmail" class="form-control" placeholder="enter email">
                           
						</div>
	                    <div class="form-group">
							<input type="password" name="vpassword" class="form-control" placeholder="enter password">
					    </div>
						
						<div class="form-group">
							<input type="submit"  class="btn btn-success btn-lg btn-block" value="Login" >
							
						</div><br>
                        New User:<a  href="vendorRegister">Register here...</a>
					</form>
				</div>

			</div>

		</div>
	</div>

</div>


</body>

</html>