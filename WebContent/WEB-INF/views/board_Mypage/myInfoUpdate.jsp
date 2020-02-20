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
<title>회원정보수정</title>
<script language="javaScript" src="resources/js/script.js" charset="ECU-KR"></script>
</head>

<body>
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
		<div id="side_menu">
		<h4><a href="#">My Page</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="#"> 개인정보관리 </a></li>
				<li>- <a href="#"> 내가 작성한 글 </a></li>
				<li>- <a href="#"> 가입한 상품 조회 </a></li>
				<li>- <a href="#"> 관심상품 </a></li>
			</ul>
		</div>
	</div>
	
	
<!-- *********************** 내용 ****************************  -->
<sf:form  commandName="userBean"  name="regForm" method="POST" 
action="myInfoUpdate.do" onsubmit="return inputCheck()">
	<table cellspacing="0" cellpadding="5" border="1" width="600">
		<tr>
			<td>
				<ul>
					<li>아이디</li>
					<li>비밀번호</li>
					<li>비밀번호 확인</li>
				</ul>
			</td>
			
			<td>
				<ul>
					<li>
					<!-- 중복확인 처리 필요함!!!!!!!!!!!!!!!!!!!!!! -->
					<c:out value="${id}"></c:out>
					<sf:hidden path="id" value="${id}"/>
					</li>
					<!-- 비밀번호 유효성 검사 해야함!!!!!!!!!!!!!!! -->
					<li><sf:input type="password" path="passwd" size="50" maxlength="50"></sf:input></li>
					<li><input type="password" name="ck_passwd" size="50" maxlength="50"></li>
				</ul>
			</td>
		</tr>
		<tr>
			<td>
				<ul>
					<li>이름</li>
					<li>생년월일</li>
					<li>휴대폰 번호</li>
					<li>주소(선택)</li>
					<li>이메일</li>
				</ul>
			</td>
				<td>
				<ul>
					<li><sf:input path="user_name" size="50" maxlength="50"></sf:input></li>
					<li><sf:input type="date" path="user_birth" size="50" maxlength="50"></sf:input></li>
					<li><sf:input path="user_phone" size="50" maxlength="50"></sf:input></li>
					<li><sf:input path="user_address" id="user_address" size="50" maxlength="50" readonly="true"></sf:input>
						<input type="button" value="주소찾기" onclick="findAdress()"></li>
					
					<li><sf:input path="user_email" size="50" maxlength="50"></sf:input></li>
				</ul>
			</td>
		</tr>
		<c:if test="${uid=='admin'}">
		<!--관리자인 경우에만--> 
		
		<tr><td colspan="2" align="right">관리자일 경우 체크<input type="checkbox"></td></tr>
		</c:if>
		<tr> 
		<td colspan="2" align="center">
		<input type="submit" value="수정하기" >
		<input type="button" onclick="history.back()" value="취소">
		</td>
		</tr>
	</table>
</sf:form>

	<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>