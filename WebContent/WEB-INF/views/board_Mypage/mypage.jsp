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
<title>My Page</title>
<script type="text/javascript">
function goToMyInfo(){
	location.href='myInfo.do';
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
	
	<table align="center" style="padding: 30px;">
		<tr>
			<td><input type="button" value="개인정보관리"
				 style="width:200px;height:160px;"
				 onclick="goToMyInfo()"></td>
				 <!-- 커뮤니티 게시판이 모두 완성되면 만들기 -->
			<td><input type="button" value="내가 작성한 글"
				 style="width:200px;height:160px;"></td>
		</tr>
		<tr>
			<!-- 상품 게시판이 완성되면 만들기 -->
			<td><input type="button" value="가입한 상품 조회"
				 style="width:200px;height:160px;"></td>
			<td><input type="button" value="관심상품"
				 style="width:200px;height:160px;"></td>
		</tr>
	</table>
	<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>