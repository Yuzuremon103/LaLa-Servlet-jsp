<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	chap05</title>
</head>
<body>
	
	<form action="/example/FormSampleServlet" method="post">
		名前:<input type="text" name="name"><br>
		性別:
		男:<input type="radio" name="gender" value="0">
		女:<input type="radio" name="gender" value="1"><br>
		携帯電話:<input type="text" name="tel" placeholder="000-0000-0000"><br>
		<input type="submit" value="送信">
	</form>
	
</body>
</html>