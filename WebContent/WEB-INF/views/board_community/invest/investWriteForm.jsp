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

<title>invest</title>
<script type="text/javascript">
// 작성 취소
function boardlist(){
	location.href='investList.do?current_page=1';
}
</script>

</head>


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
<c:url var="insertUrl" value="/invest_write_form.do" />	
<sf:form modelAttribute="boardBean" commandName="boardBean" enctype="multipart/form-data" method="POST" action="${insertUrl}" >
	<sf:hidden path="idx" value="${id_x}"/>

	<table width="400" border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td><b>제목</b></td>
			<td><sf:input path="subject" size="50" maxlength="50"  value="[재테크]"/><br /> 
			<sf:errors path="subject" cssClass="error" /></td>
		</tr>
		<tr>
			<td><b>카테고리</b></td>
			<td><sf:select path="category">
				<sf:option value="signup" label="성공사례"/>
				<sf:option value="savings" label="실패사례"/>
				<sf:option value="etc" label="기타"/>
			</sf:select></td>
		</tr>
		<tr>
			<td><b>내용</b></td>
			<td><sf:textarea path="content" size="200"
					cssStyle="width:350px;height:100px;" maxlength="200" /><br /> 
				<sf:errors path="content" cssClass="error" /></td>
		</tr>
		<!-- 엔코딩 깨짐 -->
		<tr>
			<td><b>파일</b></td>
			<td><input type="file" name="file"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="등록" />
				<input type="button" value="취소" onclick="javascript:boardlist()"></td>
		</tr>
	</table>
</sf:form>
	
	
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
	
</html>