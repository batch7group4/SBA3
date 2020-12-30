<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
   	 		<link rel="stylesheet" type="text/css" href="styles.css">
        <title> Funds Transfer</title>
    </head>
   <body>
	<h1>IBS Bank</h1>
            <table border="0" cellspacing="0" cellpadding="0">
                <tr><td>
                	<table border="0.5" >
                            <tr bgcolor="#FFF0FF">
                                <th align="center"><a href="/acctSummary?userName=${userName}">Account Summary</a></th>
                                <th align="center"><a href="/fundsTransferHome?userName=${userName}">Funds Transfer&nbsp;&nbsp;</a></th>
                                <th align="center"><a href="/fixedDeposit?userName=${userName}">Fixed Deposit&nbsp;&nbsp;</a></th>
                                <th><a href="/recurringDeposit?userName=${userName}">Recurring Deposit&nbsp;&nbsp;</a></th></tr>
                            <tr>
                            <tr align="right"><p>Welcome ${userName} !! </p></tr>
                        </table>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td bgcolor="#E3E4FA" height="410" width="24%" valign="top">
                        <br><strong>Services</strong><br>
                        <a href="/acctSummary?userName=${userName}">Account Summary</a>
                        <a href="/fundsTransferHome?userName=${userName}">Funds Transfer&nbsp;&nbsp;</a>
                        <a href="/acctStmt?userName=${userName}">Account Statement&nbsp;&nbsp;</a><br><br>
                        <a href="changePassword.jsp">Change Password<br></a>
                        <a href="index.jsp">Log Out</a>
                        <br>
                        <br>
                    </td>
                    <td width="1100" height="100" bgcolor="#FAF8CC">
                        <font color="brown"><h2>Funds Transfer </h2></font>
						<h4><a href="/addBnfPage?userName=${userName}">Add Beneficiary</a>
                        <span><a href="/fundsTransferHome?userName=${userName}">View List Of Beneficiaries</a></span></h4>
                        
<form:form action="/transfer?userName=${userName}" method="POST" modelAttribute="transfer" class="form">

		<table border="0" cellspacing="0" cellpadding="0" width="40%" >
			<tr><td><strong>From Account</strong></td> 
			<td><input type="text" name="fromAcctNum"  value=${fromCustAcctNum} readonly /></td>
			</tr>
			<tr><td><strong>To Account&nbsp;</strong></td> 
			<td><select name="toAcctNum">
   				 <c:forEach items="${bncfryList}" var="c">
        			<option value="${c.bnfcryId}">${c.bnfcryAcctNum}  ${c.bnfcryAcctName} </option>
    			</c:forEach>
			</select></td>
			</tr>
			<tr><td><strong>Transfer Amount</strong></td> 
			<td><em><input type="number" name="txnAmt" min="1" max="500000" step="1" required/></em></td>
			</tr>
			<tr><td><strong>Comments</strong></td> 
			<td><em><input type="text" name="txnCmnts" required /></em></td>
			</tr>
			<tr align="right"><td><button>Transfer</button></td> 
			<td><em></em></td>
			</tr>
		</table>
	</form:form>	
            </table>
            <table border="0" cellspacing="0" cellpadding="0" width="100%">
            </table>

            <table border="0" cellspacing="0" cellpadding="0" width="100%" height="63" background="HTML/images/bot.gif">
                <tr>
                    <td>
                        <table border="0" cellspacing="0" cellpadding="0" width="780" background="" height="25">
                            <footer>Copyright&copy;2020 IBS Bank.com. All rights reserved | Designed by Batch-7 Group3</footer><br/></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                    </td>
                </tr>
            </table>
    </body>
</html>