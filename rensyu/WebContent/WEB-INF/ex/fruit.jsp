<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Fruit" %>
<%
// リクエストスコープに保存されたfruitインスタンスを取得
Fruit fruit = (Fruit) request.getAttribute("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="font-size: 5rem; font-weight: bold;">
		<%= fruit.getName() %>の値段は<%= fruit.getPrice() %>ペソです。
	</p>
</body>
</html>