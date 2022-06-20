<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/example/myservlet?id=13" method="post">
	名前:<input type="text" name="name"><br>
	パスワード:<input type="password" name="password"><br>
	<!--  <input type="hidden" name="id" value="13"> -->
	<input type="submit" value="送信">
	</form>

</body>
</html>