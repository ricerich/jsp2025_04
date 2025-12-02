<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시어 - errorPage, isErrorPage 속성</title>
</head>
<body>
<%
// String str1 = request.getParameter("age")==null ? "20" : request.getParameter("age").trim();

String str1 = request.getParameter("age");

// if(str1 == null)
// 	str1 = "0";

int myAge = Integer.parseInt(str1) + 10;  // 에러 발생
out.println("10년 후 당신의 나이는 " + myAge + "입니다.");  // 실행되지 않음
%>
</body> 
</html> 