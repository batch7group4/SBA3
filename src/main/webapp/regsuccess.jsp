<%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<link href ="${pageContext.request.contextPath}/images/Styling.css" type ="text/css" rel ="stylesheet"></link>
	<head>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<title>Registration Successful</title>
	</head>
<body>
	<h1>IBS Bank</h1>
	<h3>Welcome! Register below</h3>
	<jsp:include page="menu.jsp"/>
	
	<h2>Registration successful !! Thank you.  </h2>
	
</body>
</html>