<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>IBS Bank-Benf List</title>
    <jsp:include page="menu2.jsp"/>
<link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    
    <body>
    <form:form action="/viewBnfcry?userName=${userName}" method="GET" modelAttribute="viewBnfcry" class="form">
    
    <tr>
      <tr align="right"><p>Welcome ${userName} !! </p></tr>


        <table>
                <tr>
                        <br>
                        <br>
                    </td>
                    <td>
                 
                        <h4><a href="/addBnfPage?userName=${userName}">Add Beneficiary</a>
                        <span><a href="/transfer?userName=${userName}">Transfer Funds</a></span></h4>
               <c:choose>
				<c:when test="${bncfryList==null || bncfryList.isEmpty()}">
					<div class="alert alert-info">
						<strong>No Beneficiaries Available</strong>
					</div>
				</c:when>
				<c:otherwise>
                        <table class="table table-bordered table-striped" border = "1" >
						<thead>
                            <tr align="center" >
                                <th >Beneficiary ID</th>
                                <th>Account Name</th>
                                <th>Account Number</th>
                                <th>IFSC </th>
                            	<th>Bank Name</th>
                            	<th>Mobile #</th>
                            	<th colspan="1">Action</th>
                            	</tr>
                            </thead>
						<tbody>
						
							<c:forEach var="c" items="${bncfryList}">
								<tr >
									<td>${c.bnfcryId }</td>
									<td>${c.bnfcryAcctName }</td>
									<td>${c.bnfcryAcctNum}</td>
									<td>${c.bnfcryBankIfsc}</td>
									<td>${c.bnfcryBankName}</td>
									<td>${c.bnfcryMblNum}</td>
									<!-- <td>
										<a href="/transferFunds?bnfcryId=${c.bnfcryId }" class="btn btn-sm btn-danger">Transfer</a>
									</td> -->
									<td>
										<a href="/deleteBnfcry?bnfcryId=${c.bnfcryId }" class="btn btn-sm btn-danger">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>					
					</table>
					</c:otherwise>
			</c:choose>
            <table border="0" cellspacing="0" cellpadding="0" width="100%">
            </table>
            </form:form>
            </body>
            </html>