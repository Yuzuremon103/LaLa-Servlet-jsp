<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
// 運勢をランダムで決定
String[] luckArray = {"超スッキリ", "スッキリ", "最悪"};
int index = (int)(Math.random() * 3);
String luck = luckArray[index];

// 実行日を取得
Date date = new Date();
SimpleDateFormat sfd = new SimpleDateFormat("MM月dd日");
String today = sfd.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ占い</title>
</head>
<body>

<p><%= today %>の運勢は「<%= luck %>」です</p>

</body>
</html>