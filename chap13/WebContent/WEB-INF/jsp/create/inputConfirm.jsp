<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/common/head.jsp" />
<body>
	
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	
	<main id="main">
		<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		<article id="main-content">
			<h1>新規社員登録確認</h1>
			<table>
				<tr>
					<th>ID</th>
					<td><c:out value="${emp.id}"></c:out></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><c:out value="${emp.name}"></c:out></td>
				</tr>	
				<tr>
					<th>年齢</th>
					<td><c:out value="${emp.age}"></c:out></td>
				</tr>	
				
			</table>
			<form action="<%= request.getContextPath() %>/inputRegister" method="post">
				<input type="hidden" name="id" value='<c:out value="${emp.id}" /> '>
				<input type="hidden" name="name" value='<c:out value="${emp.name}" /> '>
				<input type="hidden" name="age" value='<c:out value="${emp.age}" /> '>
				<button type="submit" class="submit-btn">登録</button>
				<a href="<%= request.getContextPath() %>/list">
					<button type="button" class="cancel-btn">戻る</button>
				</a>
			</form>
		</article>
	</main>
	
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="<%= request.getContextPath() %>/js/script.js">

	</script>
</body>
</html>