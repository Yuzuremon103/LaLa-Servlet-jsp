<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside id="sub-content">
	<h2>
		<span id="menu-btn">メニュー</span>
	</h2>
	<div id="menu-area">
		<ul>
			<li><a class="newEmp" href="<%= request.getContextPath() %>/create">新規社員登録</a>
				<!--            ↑chap13のこと           ↑Webアノテーション -->
			</li>
			<li>
				<form class="seach-form" action="${pageContext.request.contextPath}/seach" method="post">
					<input class="seach-box" type="text" name="name" placeholder="名前" >
					<button class="img-btn" type="submit">
						<img class="seach-img" src="${pageContext.request.contextPath}${find_png}" alt="検索">
					</button>
				</form>
			</li>
		</ul>
		
	</div>
	
</aside>