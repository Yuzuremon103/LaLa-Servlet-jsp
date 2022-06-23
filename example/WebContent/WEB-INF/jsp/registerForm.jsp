<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errMsg = (String) session.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(errMsg != null && errMsg.length() > 0) { %>
		<form action="/example/RegisterUser" method="post">
			<p style="color: red;"><%= errMsg %></p>
	<% } %>
			ログインID:<input type="text" name="id"><br>
			パスワード:<input type="password" name="pass"><br>
			名前:<input type="text" name="name"><br>
			<input type="submit" value="確認">
		</form>
</body>
</html>