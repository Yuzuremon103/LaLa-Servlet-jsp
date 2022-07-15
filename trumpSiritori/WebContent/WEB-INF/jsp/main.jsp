<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// リクエストスコープから最後の文字を取得
String lastChar = (String) request.getAttribute("lastChar");
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
	
	
	<p><a href="<%= request.getContextPath() %>/siritori">更新</a></p>
	<form action="<%= request.getContextPath() %>/siritori" method="post">
		<input type="text" name="text">
		<input type="hidden" name="lastChar" value="${lastChar}">
		<input type="submit" value="しりとる ! ">
	</form>
<!-- <c:if test="${not empty errorMsg}">
		<p style="color: red;">${errorMsg}</p>
	</c:if>
	<c:forEach var="mutter" items="${mutterList}">
		<p><c:out value="${mutter.userName}" />:
			<c:out value="${mutter.text}" /></p>
	</c:forEach>
	
	-->
	
</body>
</html>