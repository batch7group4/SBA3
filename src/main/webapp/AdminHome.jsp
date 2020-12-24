<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
	 	<title>Admin Login</title>
	 		 	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body>
	<h1>Admin Home</h1>
<hr/>
	<h5 align="right"> Welcome ${loginUser.getUserName}</h5>
	<div><a href="/openRequests">Open Requests</a></div>
	<div><a href="/getCustomerStatement">Customer Statement</a></div>
	<div><a href="/checkTransactions">See Transactions</a></div>
	<div><a href="index.jsp">Log Out</a></div>
	<hr/>

</body>
</html>