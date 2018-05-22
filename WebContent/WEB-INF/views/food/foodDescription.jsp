<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a align="center" style="color:blue" href="javascript:history.go(-1)">Go Back</a>
<h1>FoodId:${FoodId}</h1>
<h1>Food Name:${Food_Description.foodname}</h1>
<h1>Food Type:${Food_Description.foodType}</h1>
<h1>Food Category:${Food_Description.foodCategory}</h1>
<h1>Food Price:${Food_Description.price}</h1>
<hr>
<img src="${Food_Description.fimage}">
<form method="POST" action="addToCart">
 Select Quantity<select name="quantity" value="0">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
<input type="hidden" value="${FoodId}" name="foodid">
<input type="submit" value="addtocart">
</form>
</body>
</html>