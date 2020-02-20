<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<meta charset="EUC-KR">
<title>글 작성하기</title>
</head>
<body>

<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">커뮤니티</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="#"> 리 뷰</a></li>
				<li>- <a href="#"> 자유게시판</a></li>
				<li>- <a href="#"> 모임방</a></li>
				<li>- <a href="#"> 토론방</a></li>
				<li>- <a href="#"> 제태크노하우</a></li>
				<li>- <a href="#"> BEST게시물</a></li>
			</ul>
		</div>
	</div>
	
<!-- *********************** 내용 ****************************  -->	
	
	<div id="board">
		내용
	</div>
	
	
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>