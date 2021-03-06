<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href ="${pageContext.request.contextPath}/images/Styling.css" type ="text/css" rel ="stylesheet"></link>
<head>
<title>Account Summary Page</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<jsp:include page="menu2.jsp"/>
	<h3>Quick Links</h2>
<div id="navigation">
    <ul>
    <li><a href="/acctStmt?userName=${userName}">Account Statement</a></li>
    <li><a href="/transfer?userName=${userName}">Transfer Funds</a></li>
    <li><a href="/addBnfPage?userName=${userName}">Beneficiaries</a></li>
    </ul>
  
  
  <h2>Account Summary</h2><h5>Welcome ${userName }</h5>
   <table style="float:top;width:400px; margin:0 auto;">
	
	<c:choose>
				<c:when test="${savingsData==null || savingsData.isEmpty()}">
					<div class="alert alert-info">
						<strong>Awaiting admin approval!</strong>
					</div>
				</c:when>
				<c:otherwise>
				<table class="table table-bordered table-striped" border = "1">
						<thead>
							<tr align="center" bgcolor="#E3E4FA" valign="top">
							<th>Account Number</th>
							<th>Customer Name</th>
							<th>Account Balance</th>
							<th>Account Type</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${savingsData }">
								<tr bgcolor="#FAF8CC">
									<td>${c.custAcctNum }</td>
									<td>${c.custName }</td>
									<td>${c.availableBalance}</td>
									<td>${c.custAcctType}</td>
								</tr>
							</c:forEach>
						</tbody>					
					</table>
					</c:otherwise>
			</c:choose>

					
	</table>   
</div>


	
</body>
</html>