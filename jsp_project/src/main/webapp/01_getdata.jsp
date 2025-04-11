<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String strName=request.getParameter("name");
	String strMajor=request.getParameter("major");
	out.println("이름 :" + strName + "<br/>");
	out.println("학과 :" + strMajor + "<hr/>");
	%>
	웹 브라우저 URL 주소 입력 부분을 살펴보세요.
</body>
</html>