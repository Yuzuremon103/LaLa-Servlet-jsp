<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 String name = "湊 雄輔";
 int age = 23;
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MINATO</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

私の名前は<%= name %>。年齢は<%= age %>才です。

</body>
</html>