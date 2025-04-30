<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Validation</title>
</head>
<script type="text/javascript">
	function checkLogin() {
		var form = document.loginForm1;
		var form_name = "loginForm1";
		
// 		var id = document.loginForm.id.value;
// 		var id = form.id.value;
// 		var id = document.forms['loginForm'].elements["id"].value;
 		var id = document.forms[form_name].elements["id"].value;
		
// 		var pw = document.loginForm.passwd.value;
		var pw = document.forms[form_name].passwd.value;
		
		if (id == "") {
			alert("아이디를 입력해 주세요.");
// 			document.forms["loginForm"].elements["id"].focus();
			document.forms[form_name].elements["id"].focus();
			return false;
		} else if (pw == "") {
			alert("비밀번호를 입력해 주세요");
// 			document.loginForm.passwd.focus();
			document.forms[form_name].passwd.focus();
			return false;
		}
		form.submit();
	}
</script>
<body>
	<form name="loginForm1" action="validation02_process.jsp" method="post">
		<p>	아 이 디 : <input type="text" name="id">
		<p>	비밀번호 : <input type="password" name="passwd">
		<p>	<input type="button" value="전송" onclick="checkLogin()">
	</form>
</body>
</html>