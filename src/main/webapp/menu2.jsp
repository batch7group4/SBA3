<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %><html>
<body>
<link href ="${pageContext.request.contextPath}/images/Styling.css" type ="text/css" rel ="stylesheet"></link>
		<!-- <body style="background-color:AliceBlue;">
    </body> -->
	
		 <img class="image" src="images/ibsbank.png" 
		 alt="ibsbank" height="150" style="vertical-align:bottom">
<nav>
	<hr>
	<button>
	 <a href="/acctSummary?userName=${userName}">Account Summary</a>
	 </button>
	 <button>
	 <a href="/acctStmt?userName=${userName}">Account Statement</a>
	  </button>
	 <button>
	 <a href="/addBnfPage?userName=${userName}">Beneficiaries</a>
	  </button>
	 <button>
	 <a href="/transfer?userName=${userName}">Transfer Funds</a>
	  </button>
	 <button>
	 <a href="index.jsp">LogOut</a> 
	  </button>
	<hr>
</nav>
</html>