<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세보기 페이지</title>
<style>
h2 {
	text-align: center;
}

.member {
	text-align: center;
	width: 100%;
	margin: 0 auto;
}

a {
	text-decoration: none;
}
</style>
</head>		
<body>
	<c:if test="${result == 0}">
		<script type="text/javascript">
				alert('사원이 삭제되지 않았습니다.');
		</script>
	</c:if>
	
	<c:if test="${result == 1}">
		<script type="text/javascript">
			alert('사원이 삭제되었습니다.')
			location.replace("/") //스크립트에서 redirect를 하는 방법이다.
		</script>
	</c:if>
	
	<h2> 사원 상세보기</h2>
	<table border="1" class="member">
	<tr><th>사번</th><td>${emp.empno }</td></tr>
	<tr><th>이름</th><td>${emp.ename }</td></tr>
	<tr><th>업무</th><td>${emp.job }</td></tr>
	<tr><th>급여</th><td>${emp.sal }</td></tr>
	<tr><th>입사일</th><td>${emp.hiredate }</td></tr>
	<tr><th>보너스</th><td>${emp.comm }</td></tr>
	<tr><th>관리자사번</th><td>${emp.mgr }</td></tr>
	<tr><th>부서코드</th><td>${emp.deptno }</td></tr>
	<tr><td colspan="2">
	    <input type="button" value="목록" 
			onclick="location.href='/'">
		<input type="button" value="수정" 
			onclick="location.href='updateForm?empno=${emp.empno}'">
		<input type="button" value="삭제" 
			onclick="location.href='delete?empno=${emp.empno}'"></td></tr>
	</table>
	
</body>
</html>