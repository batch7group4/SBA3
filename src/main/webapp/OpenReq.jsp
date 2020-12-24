<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page isELIgnored="false" %>
<html>
	<head>
	 	<title>Admin Open Requests</title>
	 		 	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body>
	<h1>IBS Bank - Admin Home</h1>
<hr/>
	<h5 align="right"> Welcome Admin</h5>
	<div><a href="/openRequests">All Open Requests</a></div>
	<div><a href="/getCustomerStatement">All Customer Statements</a></div>
	<div><a href="/checkTransactions">See Transactions</a></div>
	<div><a href="index.jsp">Log Out</a></div>
	
	<hr/>
	<h6>${approvalStatus}</h6>
	<c:choose>
				<c:when test="${allOpenRequests==null || allOpenRequests.isEmpty() }">
					<div class="alert alert-info">
						<strong>No Open Account Requests Available</strong>
					</div>
				</c:when>
				<c:otherwise>
					<table class="table table-bordered table-striped">
						<thead>
							<tr align="center" bgcolor="#E3E4FA" valign="top">
								<th>Reg Id</th>
							<th>User Name</th>
							<th>Mobile Num</th>
							<th>Type Of Account</th>
							<th>Customer Accounts</th>
							<th colspan="2">Admin Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${allOpenRequests }">
								<tr bgcolor="#FAF8CC">
									<td>${c.regId }</td>
									<td>${c.userName }</td>
									<td>${c.mobileNum}</td>
									<td>${c.typeOfAcctHolder}</td>
									<td>${c.custAcctType }</td>
									<td>
										<a href="/approve?regId=${c.regId }" class="btn btn-sm btn-danger">
											Approve
										</a>
									</td>
									<td>
										<a href="/reject?regId=${c.regId }" class="btn btn-sm btn-info">
											Reject
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>					
					</table>
				</c:otherwise>
			</c:choose>
		

</body>
</html>