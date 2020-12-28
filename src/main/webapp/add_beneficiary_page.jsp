<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %><html>
	<head>
	<link href ="${pageContext.request.contextPath}/images/Styling.css" type ="text/css" rel ="stylesheet"></link>
	 	<title>Beneficiaries page</title>
	 	
<jsp:include page="menu.jsp"/>
<link rel="stylesheet" type="text/css" href="styles.css">

	</head>
	
	          <table >
                <tr><td>
                	<table  >
                            <tr >
                                
                                <a href="/viewBnfcry?userName=${userName}" >View All Beneficiaries<br></a>
                            <tr>
                            
                        </table>
                    </td>
                </tr>
            </table>
<body>
	
	
	
		<form:form action="/addBnfcry?userName=${userName}" method="POST" modelAttribute="addBnf" class="form">
	<h5>Welcome ${userName }</h5>
	<table>
			<table>
			<tr><td><strong>Beneficiary Acct Number </strong></td> 
			<td><em><input type="number" name="bnfcryAcctNum" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Name </strong></td> 
			<td><em><input type="text" name="bnfcryAcctName" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Bank</strong></td> 
			<td><em><input type="text" name="bnfcryBankName" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary IFSC code</strong></td> 
			<td><em><input type="text" name="bnfcryBankIfsc" required /></em></td>
			</tr>
			<tr><td><strong>Beneficiary Mobile Num</strong></td> 
			<td><em><input type="text" name="bnfcryMblNum" required /></em></td>
			</tr>
			<tr><td ><button>Add</button></td> 
			<td><em></em></td>
			</tr>
			
			
</table>
			
			
			</form:form>
			
</body>
</html>