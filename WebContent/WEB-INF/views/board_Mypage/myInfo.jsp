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
<title>Insert title here</title>
<script>
function goToMyInfoUpdate(){
	location.href='myInfoUpdateForm.do?id=${userBean.getId()}';
}
function goToMyPge(){
	location.href='myPage.do';
}
function deleteId(){
	location.href='deleteId.do?id=${userBean.getId()}';
}
</script>
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
<div style="padding: 10px;">
	<table border="1" cellpadding="10px" >
		<tr>
		<td>
			<ul>
				<li>아이디</li>
				<li>비밀번호</li>
			</ul>
		</td>
		<td>
			<ul>
				<li><c:out value="${userBean.getId()}"></c:out></li>
				<li>************</li>
			</ul>
		</td>
		</tr>
		<tr>
		<td>
			<ul>
				<li>이름</li>
				<li>생년월일</li>
				<li>휴대폰 번호</li>
				<li>주소</li>
				<li>이메일</li>
			</ul>
		</td>
		<td>
			<ul>
				<li><c:out value="${userBean.getUser_name()}"></c:out></li>
				<li><c:out value="${userBean.getUser_birth()}"></c:out></li>
				<li><c:out value="${userBean.getUser_phone()}"></c:out></li>
				<li><c:out value="${userBean.getUser_address()}"></c:out></li>
				<li><c:out value="${userBean.getUser_email()}"></c:out></li>
				
			</ul>
		</td>
		</tr>
		<tr>
		<td colspan="2" align="center" >
		<!-- 메인 만든뒤에 바꿔주기 -->
		<input type="button" value="메인으로" onclick="goToMyPge()">
		<input type="submit" value="회원정보수정" onclick="goToMyInfoUpdate()">
		<input type="button" value="회원삭제" onclick="deleteId()">
		</td>
		</tr>
	</table>
</div>

	<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>