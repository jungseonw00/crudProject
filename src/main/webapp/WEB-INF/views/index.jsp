<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
<style>
	.member{
		text-align: center;
		width:100%;
		margin:0 auto;
	}
	a{
		text-decoration: none;
	}
</style>
</head>		
<body>
	
	<table border="1" class="member">
	<tr>
		<td>사원번호</td>
		<td>사원직책</td>
		<td>사원이름</td>
		<td>사원연봉</td>
		<td>입사날짜</td>
		<td>상사번호</td>
	</tr>
	<c:forEach var="list" items="${empList }">
	<tr>
		<td><a href="detail?empno=${list.empno}">${list.empno }</a></td>
		<td>${list.job }</td>
		<td>${list.ename }</td>
		<td>${list.sal }</td>
		<td><fmt:formatDate value="${list.hiredate }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
		<td>${list.mgr }</td>
	</tr>  
	</c:forEach>
	</table>
</body>
</html>