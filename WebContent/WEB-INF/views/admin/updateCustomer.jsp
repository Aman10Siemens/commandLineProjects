<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update customer</title>
</head>
<body>
	<h3>Please fill the detail you want to change</h3>
	<form method="post" action="updateCustomer">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter New Address</td>
				<td><input type="text" name="customerAddress"
					value="${customer_obj.customerAddress}" /></td>
			</tr>
			<tr>
				<td>Enter New contact number</td>
				<td><input type="text" name="contactNumber"
					value="${customer_obj.contactNumber}" /></td>
			</tr>
			<tr>
				<td>Enter email</td>
				<td><input type="text" name="customerEmail"
					value="${customer_obj.customerEmail}" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="Update Customer Details" /></td>
			</tr>
		</table>
		
	</form>
	
</body>
</html>