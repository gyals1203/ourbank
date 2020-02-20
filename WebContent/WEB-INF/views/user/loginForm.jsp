<%@ page language="java" import="java.util.*,java.sql.*,javax.servlet.http.*" 
contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
<script language="javaScript" src="resources/js/script.js" charset="EUC-KR"></script>
</head>
<body>
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">로그인</a></h4>
	</div>
	
<!-- *********************** 내용 ****************************  -->


<div align="center" style="padding: 50px;">
<h1 style="padding: 10px;">로그인</h1>
<form name="form" method="post" onSubmit="return blankCheck();" action="loginPro.do">
<table border="1" cellpadding="10" width="30%">
	<tr>
	<td><input name="id" size="40" maxlength="50" placeholder="아이디를 입력해주세요" ></input></td>
	<td colspan="2" align="center" rowspan="2">
	<input type="submit" value="로그인"  width="30px"/></td>
	</tr>
	<tr>
	<td><input type="password" name="passwd" size="40" maxlength="50" placeholder="비밀번호를 입력해주세요"></input></td>
	</tr>
</table>
</form>
<c:if test="${noinfo==true}">
	<p > 아이디/비밀번호를 확인해 주세요 </p>
</c:if>
<a href="findId.do">아이디</a> / <a href="findPasswd.do" style="padding-right: 10px"> 비밀번호 찾기</a>| 
<a  href="signUp.do" style="padding-left: 10px">회원가입</a>
</div>
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>

</html>