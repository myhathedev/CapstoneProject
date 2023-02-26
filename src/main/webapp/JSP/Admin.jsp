<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Page</title>
</head>
<%
//In case, if Admin session is not set, redirect to Login page
if ((request.getSession(false).getAttribute("Admin") == null)) {
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%
}
%>
<body>
	<center>
		<h2>Admin Home Page</h2>
	</center>

	Welcome
	<%=session.getAttribute("Admin")%>

	<div style="text-align: right">
		<a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
	</div>
	
	<div>
	<a href="JSP/NewQuestion.jsp"><button>Create New Question</button></a> <br/> <br />
	<a href="<%=request.getContextPath()%>/QuestionManageServlet"><button>Question List</button></a>
	</div>
</body>
</html>