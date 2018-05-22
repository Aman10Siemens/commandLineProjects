<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<c:url value='/resources/theme1/bootstrap/css/bootstrap.min.css' />">
 <link rel="stylesheet" type="text/css" href="resources/theme1/addFoodItem.css">
</head>
<body>

<h1 align="center" style="color:red;">${valid_vendorobj.restaurantName}</h1>
<div class="container" >
	<div class="row">
	<div class="col-sm-3"></div>
		<div class="col-sm-6">
			
			<div class="panel panel-default"><form method="POST" action="addFood" class="form-horizontal" enctype="multipart/form-data">
				<h3>Add more Food Items...</h3>
				<div class="panel-body">
				<div class="form-group">
					<label class="control-label col-sm-4" for="foodname">Food Name</label>
					<div class="col-sm-8">
						<input type="text" name="foodname" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="price">Price</label>
					<div class="col-sm-8">
						<input type="text" name="price" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="foodType">Food Type</label>
					<div class="col-sm-8">
						<select class="form-control" name="foodType">
			                 <option value="Veg">Veg</option>
			                 <option value="Non-Veg">Non-Veg</option>
			                
			            </select> 
				</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="foodCategory">Food Category</label>
					<div class="col-sm-8">
						<input type="text" name="foodCategory" class="form-control">
					</div>
	
				</div>
				<div class="form-group">
					<label class="control-label col-sm-4" for="file">Food Image</label>
					<div class="col-sm-8">
						<input type="file" name="file" class="form-control-file">
					</div>
	
				</div>
				<input type="hidden" name="vendor.vendorid" value="${valid_vendorobj.vendorid}" readonly><br><br>
				
				<div class="form-group">
					
					<div class="col-sm-offset-2 col-sm-8 text-center">
						<input type="submit" class="btn btn-success btn-lg btn-block" value="Add Food">
					</div>
	
				</div>
			    </div>
			</form>
			
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>
</div>

${food.foodname} 
</body>
</html>