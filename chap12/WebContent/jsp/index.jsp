<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サンプル</title>
<link rel="stylesheet" href="/chap12/css/style.css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="/jsp/header.jsp" />
		
		<div id="contents">
			<main>
				<h1>旨い</h1>
				<p>美味い !</p>
			</main>
			
			<jsp:include page="/jsp/aside.jsp" />
		</div>
		<jsp:include page="/jsp/footer.jsp" />
	</div>
</body>
</html>