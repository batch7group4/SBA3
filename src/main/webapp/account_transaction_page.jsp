<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
	<head>
	 	<title>Transaction Form</title>
	 	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	
<body>
	
	<form:form action="/transferFunds?userName=${userName}" method="POST" modelAttribute="transfer" class="form">
	<jsp:include page="menu2.jsp"/>
	<h5><tr align="right"><p>Welcome ${userName} !! </p></tr></h5>

		<table >
			<tr><td><strong>From Account</strong></td> 
			<td><input type="text" name="fromAcct"  value=${fromCustAcctNum} readonly /></td>
			
			</tr>
			<tr><td><strong>To Account&nbsp;</strong></td> 
			<td><select name="toAcct">
   				 <c:forEach items="${bncfryList}" var="c">
        			<option value="${c.bnfcryId}">${c.bnfcryAcctNum}  ${c.bnfcryAcctName} </option>
    			</c:forEach>
			</select></td>
			</tr>
			<tr><td><strong>Transfer Amount</strong></td> 
			<td><em><input type="number" name="amount"  required/></em></td>
			</tr>
			<tr><td><strong>Comments</strong></td> 
			<td><em><input type="text" name="remarks" required /></em></td>
			</tr>
			<tr align="center"><td><button>Transfer</button></td> 
			<td><em></em></td>
			</tr>
		</table>
	</form:form>	
</body>
</html>