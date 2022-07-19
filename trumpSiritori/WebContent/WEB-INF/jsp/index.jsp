<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>トランプしりとり</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	
	<h1>みんなでトランプしりとり</h1>

	<form action="<%= request.getContextPath() %>/last" method="post">
		<input type="text" name="text">
		<input type="submit" value="しりとる ! ">
	</form>

</body>
</html>