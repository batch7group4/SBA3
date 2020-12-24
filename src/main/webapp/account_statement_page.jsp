<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><html>
	<head>
	 	<title>Statement Form</title>
	 	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<jsp:include page="menu.jsp"/>
	<h3>Account Statement</h3>
	<h5>Welcome ${userName }</h5>
	 <c:choose>
				<c:when test="${acctStmt==null || acctStmt.isEmpty()}">
					<div class="alert alert-info">
						<strong>No transaction available for the selected user</strong>
					</div>
				</c:when>
				<c:otherwise>
                        <table class="table table-bordered table-striped" border = "1">
						<thead>
                            <tr align="center" bgcolor="#98AFC7">
                                <th >Transaction ID</th>
                                <th>From Account</th>
                                <th>To Account</th>
                                <th>Transaction Amount</th>
                                <th>Transaction Date</th>
                                <th>Comments </th>
                            	</tr>
                            </thead>
						<tbody>
							<c:forEach var="c" items="${acctStmt}">
								<tr bgcolor="#FAF8CC">
									<td>${c.txnId }</td>
									<td>${c.fromAcct}</td>
									<td>${c.toAcct}</td>
									<td>${c.amount}</td>
									<td>${c.txnDate}</td>
									<td>${c.remarks}</td>
								</tr>
							</c:forEach>
						</tbody>					
					</table>
					</c:otherwise>
			</c:choose>

<button>Submit</button>
</html>
