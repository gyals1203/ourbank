<%@ page language="java" import="java.util.*,java.sql.*,javax.servlet.http.*" 
contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>비밀번호 변경</title>
<script language="javaScript" src="resources/js/script.js" charset="ECU-KR"></script>
</head>
<body>
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">비밀번호 찾기</a></h4>
	</div>
	
<!-- *********************** 내용 ****************************  -->

<c:set var="ck" value="${ck}"></c:set>

<c:if test="${ck==1||ck==0}">
<div align="center">
		<table width="35%">
		<tr>
		<td>
			<div style="float: left;">
				<h1>비밀번호 찾기</h1>
			</div>
			<div style="float: right; margin-top:25px">
				<a href="findId.do">아이디 찾기  </a>| <a href="signUp.do">회원가입</a>
			</div>
			</td>
			</tr>
		</table>
		<hr width="500px"/>
	<form style="width: 30%;" method="post" action="findPasswdCheck.do">
			<table >
				<tr>
					<td>아이디</td>
					<td><input type="text"  size="17" name="id"
						placeholder="아이디" /></td>
					<td rowspan="4">
					<input type="submit" value="비밀번호 찾기" style="width:100px; height:90px;" >
					</td>	
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text"  size="17" name="user_name"
						placeholder="이름" /></td>	
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date"   name="user_birth"/></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text"  size="17"  name="user_phone" 
					placeholder="전화번호" /></td>
				</tr>
			</table>
		</form>
</div>

<hr width="500px"/>
<c:if test="${ck==1}">
<div align="center">
	일치하는 정보가 없습니다.
</div>
<hr width="500px"/>
</c:if>
</c:if>
<c:if test="${ck==2}">
<div align="center">
		<table width="35%">
		<tr>
		<td>
			<div style="float: left;">
				<h1>비밀번호 재설정</h1>
			</div>
			<div style="float: right; margin-top:25px">
				<a href="findId.do">아이디 찾기  </a>| <a href="signUp.do">회원가입</a>
			</div>
			</td>
			</tr>
		</table>
		<hr width="700px"/>
	<form name="regForm" style="width: 30%;" method="post" 
	action="changePasswdCheck.do" onsubmit="return equalPasswd();">
	<c:set var="id" value="${id}"></c:set>
			<table >
				<tr>
					<td>새로운 비밀번호</td>
					<td><input type="password"  size="17" name="passwd"
						placeholder="새로운 비밀번호 확인" /></td>
					<td rowspan="4">
					<input type="submit" value="비밀번호 변경" style="width:100px; height:60px;" >
					</td>	
				</tr>
				<tr>
					<td>새로운 비밀번호 확인</td>
					<td><input type="password"  size="17" name="ck_passwd"
						placeholder="새로운 비밀번호 확인" /></td>	
				</tr>
			</table>
		</form>
</div>
</c:if>

<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>