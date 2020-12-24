<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %><html>
<body>
		<!-- <body style="background-color:AliceBlue;">
    </body> -->
	
		 <img class="image" src="images/ibsbank.png" 
		 alt="ibsbank" width="300" height="120" style="vertical-align:bottom">
<nav>
	<hr />
	 <a href="index.jsp"><img src="images/home.jpg" 
		 alt="ibsbank" width="70" height="50" style="vertical-align:bottom;"></a>
	 <span>|</span>
	 <a href="registration_form_page.jsp">Register</a>
	 <span>|</span>
	 <a href="login_form_page.jsp">Login</a>
	 <span>|</span>
		<a href="/acctSummary?userName=${userName}">Account Summary</a>
	 <span>|</span>
	  <a href="/acctStmt?userName=${userName}">Account Statement</a>
	 <span>|</span>
	 <a href="/addBnfPage?userName=${userName}">Beneficiaries</a>
	 <span>|</span>
	 <a href="/transfer?userName=${userName}">Fund Transfer</a>
	 <span>|</span>
	 
	
	<hr />
</nav>
</html>