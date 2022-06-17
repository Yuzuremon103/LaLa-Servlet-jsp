<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Employee" %>
<% 
	Employee emp = new Employee("0001", "湊 雄輔");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>練習</title>
</head>
<body>
	<% int i = 0; %>
	<% while(i < 10){ %>
		<% if(i == 3 || i == 0 || i == 6 || i == 9) { %>
			<p style="color: red;">
		<% } else { %>
			<p>
		<% } %>
		IDは <%= emp.getId() %>、名前は<%= emp.getName() %>です。</p>
		<% i++; %>
	<% } %>

</body>
</html>