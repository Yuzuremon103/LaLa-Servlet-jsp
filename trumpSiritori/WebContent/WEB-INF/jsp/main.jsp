<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Siritori" %>
<%@ page import="java.util.List" %>
<%
// リクエストスコープから回数を表すcountを取得
int count = (Integer) request.getAttribute("count");
%>
<%
// リクエストスコープから最後の文字を取得
String lastChar = (String) request.getAttribute("lastChar");
%>
<% // アプリケーションスコープに保存されたしりとりリストを取得
List<Siritori> siritori = (List<Siritori>) application.getAttribute("siritoriList");
%>
<% // リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>トランプしりとり</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	
	
	<h1>みんなでトランプしりとり</h1>
	<p>${lastChar}</p>
	
	<div id="flex">
		<% int num = new java.util.Random().nextInt(13) + 1; %>
		<img src="<%= request.getContextPath() %>/img/card<%= num %>.png" alt="ランダムトランプ">
		
		<p><a href="<%= request.getContextPath() %>/main">更新</a></p>
		
		<form action="<%= request.getContextPath() %>/main" method="post">
			<input type="text" name="text">
			<input type="hidden" name="lastChar" value="${lastChar}">
			<input type="hidden" name="count" value="${count}">
			<input type="hidden" name="num" value="<%= num %>">
			<input type="submit" value="しりとる ! ">
		</form>
	</div>
	<c:if test="${not empty errorMsg}">
		<p style="color: red;">${errorMsg}</p>
	</c:if>
	
	
	<c:forEach var="siritori" items="${siritoriList}">
		<p><c:out value="${siritori.text}"/></p>
	</c:forEach>
	
</body>
</html>