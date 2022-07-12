<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トランプしりとり</title>
</head>
<body>
	
	<h1>みんなでトランプしりとり</h1>
	

	<p><a href="<%= request.getContextPath() %>/siritori">更新</a></p>
	<form action="<%= request.getContextPath() %>/siritori" method="post">
		<input type="text" name="text">
		<input type="submit" value="しりとる ! ">
	</form>
	<c:if test="${not empty errorMsg}">
		<p style="color: red;">${errorMsg}</p>
	</c:if>
	<c:forEach var="mutter" items="${mutterList}">
		<p><c:out value="${mutter.userName}" />:
			<c:out value="${mutter.text}" /></p>
	</c:forEach>
	
</body>
</html>