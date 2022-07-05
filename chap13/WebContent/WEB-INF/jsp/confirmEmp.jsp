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
			<h1>${title}</h1>
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
			<form action="${pageContext.request.contextPath}${goToUrl}" method="post">
				<input type="hidden" name="id" value='<c:out value="${emp.id}" />'>
				<input type="hidden" name="name" value='<c:out value="${emp.name}" />'>
				<input type="hidden" name="age" value='<c:out value="${emp.age}" />'>
				<button type="submit" class="submit-btn">${submitBtnLabel}</button>
				<!-- ↑更新,削除など -->
				
				<c:choose>
					<c:when test="${mode == 'delete'}">
						<a href="${pageContext.request.contextPath}/list">
							<button class="cancel-btn" type="button">戻る</button>
						</a>
					</c:when>
					<c:otherwise>
						<button formaction="${pageContext.request.contextPath}${fix_link}"
						 type="submit" class="cancel-btn">戻る
						</button>
					</c:otherwise>
				</c:choose>
			</form>
		</article>
	</main>
	
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="<%= request.getContextPath() %>/js/script.js">

	</script>
</body>
</html>