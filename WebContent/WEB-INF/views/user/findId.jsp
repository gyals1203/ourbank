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
<title>아이디 찾기</title>
<script language="javaScript" src="resources/js/script.js" charset="EUC-KR"></script>
</head>
<body>

<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">아이디 찾기</a></h4>
	
		
	</div>
	
<!-- *********************** 내용 ****************************  -->
<c:set var="ck" value="${ck}"></c:set>
<c:if test="${user_id==null}">
<div align="center">
		<table width="35%">
		<tr>
		<td>
			<div style="float: left;">
				<h1>아이디 찾기</h1>
			</div>
			<div style="float: right; margin-top:25px">
				<a href="findPasswd.do">비밀번호찾기  </a>| <a href="signUp.do">회원가입</a>
			</div>
			</td>
			</tr>
		</table>
		<hr width="500px"/>
	<form style="width: 30%;" method="post" action="findIdCheck.do">
			<table >
				<tr>
					<td>이름</td>
					<td><input type="text"  size="17" name="user_name"
						placeholder="이름" /></td>
					<td rowspan="3">
					<input type="submit" value="아이디 찾기" style="width:90px; height:75px;" >
					</td>	
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
</c:if>
<hr width="500px"/>
<c:if test="${ck}">
<div align="center">
	<c:if test="${user_id!=null}">
	<p>아이디는 ${user_id} 입니다.</p>
	<input type="button" value="로그인으로" onclick="goLoginForm()">
	<hr width="500px"/>
	</c:if>
	<c:if test="${user_id==null}">
	일치하는 정보가 없습니다.
	</c:if>
</div>
</c:if>


<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>