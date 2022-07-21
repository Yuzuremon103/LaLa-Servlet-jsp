<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Siritori" %>
<%@ page import="java.util.List" %>
<%
// リクエストスコープから回数を表すcountを取得
int count = (Integer) request.getAttribute("count");
%>
<%
// リクエストスコープから最後の文字を取得
String lastChar = (String) request.getAttribute("lastChar");
%>
<%
// リクエストスコープから残り秒数を表すiを取得
int i = (Integer) request.getAttribute("i");
%>
<% // アプリケーションスコープに保存されたしりとりリストを取得
List<Siritori> siritori = (List<Siritori>) application.getAttribute("siritoriList");
%>
<% // リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>トランプしりとり</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
	
</head>
<body>
	
	
	<h1>みんなでトランプしりとり</h1>
	
	<div id="flex">
		<% int num = new java.util.Random().nextInt(13) + 1; %>
		<!-- <p><a href="<%= request.getContextPath() %>/main">更新</a></p> -->
		
		<div id="top">
			<p id="exp">ルール説明</p>
			<p>ランダムで抽選されたトランプの数字に文字数が制限される！</p>
			<p>・A,2,3 は 1~3文字の範囲で</p>
			<p>・4,5,6 は 4~6文字の範囲で</p>
			<p>・7,8,9 は 7~9文字の範囲で</p>
			<p>・10,J,Q,K は 10~13文字の範囲で答えられるぞ。</p>
			<p>ただし、範囲外の文字数で答えてしまうと即時ゲームオーバーだ。</p>
			<p>また、最後の文字が小文字(ぁ、ょ)の場合は、大文字(あ、よ)から始められるぞ。</p>
			<p>最後に、最後の文字が「ん、ー」の場合は、最後から2番目の文字から次のしりとりか始まるぞ！</p>
			<p>ゲームオーバーにならずに君のハイスコアを目指そう！</p>
		</div>

			<img src="<%= request.getContextPath() %>/img/card<%= num %>.png" alt="ランダムトランプ">
		
		
		<div id="central">
			<c:if test="${not empty lastChar}">
				<div id="frame">
					<p>${lastChar}</p>
				</div>
			</c:if>
			<c:if test="${not empty errorMsg}">
				<p style="color: red;">${errorMsg}</p>
			</c:if>
			
			<c:forEach var="siritori" items="${siritoriList}">
				<p><c:out value="${siritori.text}"/></p>
			</c:forEach>
		</div>
	</div>
	
	<form action="<%= request.getContextPath() %>/main" method="post" id="disappear">
		<input type="text" name="text" class="huge">
		<input type="hidden" name="lastChar" value="${lastChar}">
		<input type="hidden" name="count" value="${count}">
		<input type="hidden" name="num" value="<%= num %>">
		<input type="submit" value="しりとる ! " id="submit">
	</form>
	
	<div id="count">${i}</div>
	
	
	<script>
		'use strict';
	
		// カウントダウンタイマー。300秒経過で'fin'が出る
		let i = ${i};
		function count() {
			setInterval(function () {
				document.getElementById('count').textContent = i;
				i -= 1;
				
				if (i <= -1) {
					document.getElementById('count').textContent = 'fin';
					document.getElementById('disappear').style.display = 'none';
				}
			}, 1000);
		}

/* 		// タイマー開始ボタンをクリックで実行
		document.getElementById("btn").onclick = function () {
			count();
		};
 */
 		// onloadで実行
 		onload = function () {
	 		count();
 		}
 
		// submitボタンをクリックで実行
		document.getElementById("submit").onclick = function () {
			document.getElementById("submit").insertAdjacentHTML("beforebegin", '<input type="hidden" name="i" value="' + i + '">')
		};

		</script>
	
</body>
</html>