<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="memberJoinOk" method="get">
		아이디 <input type="text" name="id"><br/>
		비밀번호 <input type="password" name="pw"><br/>
		비밀번호(확인) <input type="password" name="confirmPw"><br/>		
		이름 <input type="text" name="name"><br/>
		이메일 <input type="text" name="email"><br/>
		나이 <input type="text" name="age"><br/>
		<input type="submit" value="회원가입">
	</form>
	<hr/>
	<c:if test="${not empty signupError }">
		<span style="color: red;">${signupError }</span>
		<ul>
		<c:forEach items="${errorMsgs }" var="m">
			<li>${m }</li>
		</c:forEach>
		</ul>
	</c:if>
</body>
</html>