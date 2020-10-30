<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<script type="text/javascript">
	function formCheck() {
		var f = document.frm;
		if(f.id.value == "") {
			alert ("사용자 아이디를 입력하세요");
			f.id.focus();
			return false;
		}
		if(f.pw.value == "") {
			alert ("비밀번호를 입력하세요");
			f.pw.focus();
			return false;
		}
	return true;
	}
</script>

</head>
<body>
<jsp:include page="../menu/mainMenu.jsp"></jsp:include>
<hr>
<div align="center">
	<div><h1>로 그 인</h1></div>
	<div>
		<form id="frm" name="frm" action="login.do" method="post">
			<table border="1" style="border-collapse: collapse; text-align: center;">
				<tr>
					<th width="200" style="background-color: lightblue;">아 이 디</th>
					<td width="300"><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th width="200" style="background-color: lightblue;">패스워드</th>
					<td width="300"><input type="password" id="pw" name="pw"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" onclick="return formCheck()">로그인</button>&nbsp;&nbsp;
						<button type="reset">취소</button>&nbsp;&nbsp;
						<button type="button" onclick="location.href='memberForm.do'">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>