<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<link href ="${pageContext.request.contextPath}/images/Styling.css" type ="text/css" rel ="stylesheet"></link>
	<head>
	 	<title>IBS Login</title>
	 	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
<body>
	<jsp:include page="menu.jsp"/>
	
	 	<form:form action="/login" method="POST" modelAttribute="login" class="form">
 
    <table>

			<tr>
				<td>UserName</td>
				<td><input type="text" placeholder="UserName"  name="userName" required  /></td>
				
			</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" placeholder="password" name="password"	required/></td>
			</tr>
			
				<tr><td><strong>Role&nbsp;</strong></td> 
		<td><div class="role">
        			<input type="radio" name="role" value="Customer" CHECKED/><label for="customer">Customer</label>
        			<input type="radio" name="role" value="Admin" /><label for="Admin">Admin</label>
        			<input type="radio" name="role" value="Svc Provider" /><label for="Svc Proider">Svc Provider</label>
      				</div></td>
		</tr>
			
	
				
		</table>
	<button type="submit">Login</button>   </a>
			<button type="button" class="cancelbtn"> Cancel</button> 
			<a href="#"> Forgot password? </a>
		
		</form:form>   
</body>
</html>