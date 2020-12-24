<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
	 	<title>Mobile Prepaid Form</title>
	</head>
<body>
	
	<jsp:include page="menu.jsp"/>
	<table>
			<tr><td>Mobile Num </td> 
			<td><em><input type="text" name="mobileNum" required /></em></td>
			</tr>
			
			<tr><td>Operator Name</td> 
			<td><em><select name = "">
					<option>Airtel</option>
					<option>BSNL</option>
						<option>Idea</option>
					<option>Jio</option>
					</select>	
				</em></td>
			</tr>
			
			<tr><td>Location</td> 
			<td><em><select name = "">
					<option>Telangana</option>
					<option>Andhra Pradesh</option>
						<option>Karnataka</option>
					<option>Kerala</option>
					</select>	
				</em></td>
			</tr>
		
			<tr><td>Recharge Amount</td> 
			<td><em><input type="text" name="Recharge amount" required /></em></td>
			</tr>
			
			<tr><td><button>Submit</button></td> 
</table>
</html>
