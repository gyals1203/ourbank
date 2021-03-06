<%@ page language="java"
	import="java.util.*,java.sql.*,javax.servlet.http.*"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.text.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- model에 저장해 둔거 불러옴 -->

<c:set var="str_aid" value="${idx }" />
<c:set var="str_c_page" value="${current_page}" />
<c:set var="searchString" value="${searchStr}" />
<c:set var="filename" value="${filename}"/>
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<title>free</title>
<%
	String searchString=(String) (pageContext.getAttribute("searchString"));
	String filename=(String) (pageContext.getAttribute("filename"));
%>
<script  language="javascript">
function boardlist(){
	var s="<%=searchString%>";
	if(s=="None")
		location.href='freeList.do?current_page=${current_page}';
	else
		location.href='listSearchedSpecificPageWork.do?pageForView=${current_page}&searchStr=${searchStr}';	
}

function boardmodify(){
	location.href='free_show_update_form.do?idx=${idx}&current_page=${current_page}';
}

function boarddelete(){
	location.href='freeDeleteSpecificRow.do?idx=${idx}&current_page=${current_page}';	
}

function download(){
	var param="<%=filename%>";
	en_filename=encodeURI(param);
	location.href='free_download.do?filename='+en_filename;
}

</script>
</head>
<body>
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">커뮤니티</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="reviewList.do?current_page=1"> 리뷰게시판 </a></li>
				<li>- <a href="freeList.do?current_page=1"> 자유게시판 </a></li>
				<li>- <a href="meetList.do?current_page=1"> 모임방 </a></li>
				<li>- <a href="debateList.do?current_page=1"> 토론방 </a></li>
				<li>- <a href="investList.do?current_page=1"> 재테크 노하우 </a></li>
				<li>- <a href="#"> BEST 게시물 </a></li>
			</ul>
		</div>
	</div>
	
<!-- *********************** 내용 ****************************  -->	
	
<table cellspacing="0" cellpadding="5" border="1" width="600"  >
		<tr>
			<td><b>제목</b></td>
			<td><c:out value="${boardData.getSubject()}" /></td>
			<td><b>조회수</b></td>
			<td><c:out value="${boardData.getHits()}" /></td>
		</tr>
		<tr>
			<td><b>이름</b></td>
			<td><c:out value="${boardData.getId()}" /></td>
			<td><b>작성일</b></td>
			<td><c:out value="${boardData.getCreated_date()}"></c:out></td>
		</tr>
		<tr>
			<td><b>내용</b></td>
			<td  colspan="3" height="400" ><c:out value="${boardData.getContent()}" /></td>
		</tr>
		<tr>
			<td><b>파일첨부</b></td>
			<td colspan="3">
			<input type="button" onclick="download()"
			value="${boardData.getFilename()}">
			</td>
		</tr>
	</table>

<table cellspacing="0" cellpadding="0" border="0" width="500">
	<tr>
	<td>
		<input type="button" value="수정" onclick="javascript:boardmodify()">
		<input type="button" value="목록" onclick="javascript:boardlist()">
		<!-- 관리자만 작성할 수 있음 -->
		<input type="button" value="답글" onclick="javascript:boardanswer()">
		<input type="button" value="삭제" onclick="javascript:boarddelete()">
	</td>
	</tr>

</table>
</html>
	

<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
	
</body>
</html>