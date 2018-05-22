<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Vendor</title>
</head>
<body>
	<h3>Please fill the detail you want to change</h3>
	<form method="post" action="updateVendor">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter New Address</td>
				<td><input type="text" name="vaddress"
					value="${vendor_obj.vaddress}" /></td>
			</tr>
			<tr>
				<td>Enter New contact number</td>
				<td><input type="text" name="vcontactNo"
					value="${vendor_obj.vcontactNo}" /></td>
			</tr>
			<tr>
				<td>Enter email</td>
				<td><input type="text" name="vendorEmail"
					value="${vendor_obj.vendorEmail}" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="Update Vendor Details" /></td>
			</tr>
		</table>
		
	</form>
	
</body>
</html>