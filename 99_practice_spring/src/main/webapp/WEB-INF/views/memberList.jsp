<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>성별</th>
			<th>이메일</th>
			<th>주소</th>
		</tr>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.memberId }</td>
				<td>${member.memberName }</td>
				<td>${member.hp }</td>
				<td>${member.memberGender }</td>
				<td>${member.email }</td>
				<td>${member.residence }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>