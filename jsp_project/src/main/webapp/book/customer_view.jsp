<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8"%>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@localhost:1521:xe";
Connection dbconn = DriverManager.getConnection(url, "c##madang", "c##madang");
Statement stmt = dbconn.createStatement();
String publisher = request.getParameter("publisher");

String query = "";
query += "  ";
query += " select publisher, bookname, name ";
query += " from customer A, orders B, book C ";
query += " where A.custid = B.custid ";
query += "   and B.bookid = C.bookid ";
query += "   and publisher like '"+publisher+"' ";

ResultSet rs = stmt.executeQuery(query);
// if (rs != null) {
// 	while(rs.next())
// 	{
// 		String W_PUBLISHER = rs.getString("publisher");
// 		String W_BOOKNAME = rs.getString("bookname");
// 		String W_NAME = rs.getString("name");
	
%>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=EUC-KR">
<title>** BOOK VIEW **</title>
</head>

<body bgcolor="white" text="black" link="blue" vlink="purple"
	alink="red">
	
<%
if (rs != null) {
	while(rs.next())
	{
		String W_PUBLISHER = rs.getString("publisher");
		String W_BOOKNAME = rs.getString("bookname");
		String W_NAME = rs.getString("name");

%>
	<table border="1" cellspacing="0" width="400" bordercolor="#9AD2F7"
		bordercolordark="white" bordercolorlight="#B9E0FA">
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;"><b>출판사</b></span>
				</p>
			</td>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"> <%=W_PUBLISHER%></span>
				</p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;"><b>책이름</b></span>
				</p>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"> <%=W_BOOKNAME%></span>
				</p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;"><b>고객명</b></span>
				</p>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"> <%=W_NAME%></span>
				</p>
			</td>
		</tr>
	</table>
<%
		}
	}
	stmt.close();
	dbconn.close();
%>
	<table cellpadding="0" cellspacing="0" width="400" height="23">
		<tr>
			<td width="150">
				<p align="right">
					<span style="font-size: 9pt;"> <a href="booklist.jsp?">
							<font color="black">목록</font>
					</a></span>
				</p>
			</td>
		</tr>
	</table>

</body>
</html>