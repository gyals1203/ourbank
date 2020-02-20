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
<title>예금 데이터 입력</title>
<script type="text/javascript">
function input_saving(){
 location.href="savingProduct.do";

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
				<li>- <a href="manageDeposit.do"> 예금 상품 데이터 관리 </a></li>
				<li>- <a href="manageSaving.do"> 적금 상품 데이터 관리 </a></li>
			</ul>
		</div>
	</div>
	
	
<!-- *********************** 내용 ****************************  -->
<div align="center">
<p>은행정보와 적금상품 정보를 금융정보 사이트 데이트 베이스에서 받아옵니다.</p>
<p>3~4초 간 기다려 주세요</p>
<input type="button" onclick="input_saving()" value="적금 데이터를 받아오기" width="500px" height="400px">
</input>
</div>

<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>