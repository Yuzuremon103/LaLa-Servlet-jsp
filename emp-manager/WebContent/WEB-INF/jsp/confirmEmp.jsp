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
					<td><c:out value="${emp.id}"/></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><c:out value="${emp.name}"/></td>
				</tr>	
				<tr>
					<th>誕生日</th>
					<td><c:out value="${emp.birthday}"/></td>
				</tr>	
				<tr>
					<th>所属ID</th>
					<td><c:out value="${emp.dept.did}"/></td>
				</tr>
				<tr>
					<th>部署名</th>
					<td><c:out value="${emp.dept.dname}"/></td>
				</tr>		
			</table>
			<form action="${pageContext.request.contextPath}${gotoUrl}" method="post">
				<input type="hidden" name="id" value='<c:out value="${emp.id}"/>'>
				<input type="hidden" name="name" value='<c:out value="${emp.name}"/>'>
				<input type="hidden" name="birthday" value='<c:out value="${emp.brithday}"/>'>
				<input type="hidden" name="did" value='<c:out value="${emp.dept.did}"/>'>
				<input type="hidden" name="dname" value='<c:out value="${emp.dept.dname}"/>'>
				<button type="submit" class="submit-btn">${submitBtnLabel}</button>
				
				<c:choose>
					<c:when test="${mode == 'delete'}">
						<a href="${pageContext.request.contextPath}/list">
							<button class="cancel-btn" type="button">戻る</button>
						</a>
					</c:when>
					<c:otherwise>
						<!-- fix_link - 指定方法 -->
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