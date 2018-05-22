<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pojos.FoodItem" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<title>Insert title here</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<a align="left" style="color:blue" href="javascript:history.go(-1)">Go Back</a>
<div>
<h4 align="right"><a href="clogout"><h3 style="color:sky blue"><i>Logout</i></h3></a></h4></div>

<h3>Have a look At Food Items at our Place....</h3>
<h3>Click on the food image to add to cart</h3>
<table>
<tr><th>Food image</th><th>Quantity</th></tr>
<c:forEach var="foodItems" items="${Food_Items_List}">
<tr><td><a href="showDescriptionFood?foodid=${foodItems.foodid}"><img src="${foodItems.fimage}"></a></td>
 <td><%  FoodItem f =(FoodItem) pageContext.getAttribute("foodItems"); String s="food"+f.getFoodid();   
 
    
 
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
</c:forEach>
</table>
<!-- Items in Cart(Food_Id):${addedFoodId} -->
<a href="ViewCart">View Cart</a>
</body>
</html>