<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>
<jsp:include page="../menu/mainMenu.jsp"></jsp:include>
<hr>
<div align="center">
	<div><h1>회원목록 정보</h1></div>
	<div>
		<table border="1" style="border-collapse: collapse; text-align: center;">
		<!-- 칼럼명 적어주고 -->
			<tr style="background-color: lightblue;">
				<th width="100">아이디</th>
				<th width="100">이   름</th>
				<th width="200">주   소</th>
				<th width="150">전화번호</th>
				<th width="150">가입일자</th>
				<th width="100">권한</th>
			</tr>
		<!-- 데이터가 몇개일지 모르니까 forEach 돌려서 행 만들어준다 -->	
			<c:forEach var="member" items="${ members }">
				<tr>
					<td>${ member.id }</td>
					<td>${ member.name }</td>
					<td>${ member.address }</td>
					<td>${ member.tel }</td>
					<td>${ member.enterdate }</td>
					<td>${ member.author }</td>
				</tr>			
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>