<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Update Question Page</title>
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
		<h2>Update Question</h2>
	</center>

	<div style="text-align: right">
		<a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
	</div>
	
	<div>
	<h3> Update question: </h3>
	<form action="<%=request.getContextPath()%>/UpdateQuestionServlet" method="post">
	<label for="question">Topic: </label>
	<input type="text" name="topic" id="topic" class="question" style="width: 600px;" value="<%=request.getAttribute("topic")%>" readOnly></input><br/> <br/>
	<label for="question">Question: </label>
	<input type="text" name="question" id="question" class="question" style="width: 600px;" value="<%=request.getAttribute("question")%>"></input> <br/> <br/>
	<label for="option1">Option 1:</label>
	<input type="text" name="option1" id="option1" class="question" style="width: 300px;" value="<%=request.getAttribute("option1")%>"/><br/> <br/>
	<label for="option2">Option 2:</label>
	<input type="text" name="option2" id="option2" class="question" style="width: 300px;" value="<%=request.getAttribute("option2")%>"/><br/> <br/>
	<label for="option3">Option 3:</label>
	<input type="text" name="option3" id="option3" class="question" style="width: 300px;" value="<%=request.getAttribute("option3")%>"/><br/> <br/>
	<label for="option4">Option 4:</label>
	<input type="text" name="option4" id="option4" class="question" style="width: 300px;" value="<%=request.getAttribute("option4")%>"/><br/> <br/>
	<label>New Answer:</label>
	<select name="answer" id="answer" >
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select>
	<br/> <br/>
	<input type="hidden" name="id" id="id" class="question" value="<%=request.getAttribute("id")%>"/>
	<input type="submit" value="Update"/>	
	</form>
	<a href="<%=request.getContextPath()%>/QuestionManageServlet"><button>Cancel</button></a>
	</div>
</body>
</html>