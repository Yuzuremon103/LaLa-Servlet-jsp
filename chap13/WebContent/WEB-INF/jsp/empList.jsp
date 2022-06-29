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
			<h1>社員一覧</h1>
			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
					<c:forEach var="emp" items="${empList}">
						<tr>
							<td><c:out value="${emp.id}" /></td>
							<td><c:out value="${emp.name}" /></td>
							<td><c:out value="${emp.age}" /></td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</article>
	</main>
	
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="<%= request.getContextPath() %>/js/script.js">

	</script>
</body>
</html>