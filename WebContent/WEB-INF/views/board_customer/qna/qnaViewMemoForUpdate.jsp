<%@ page language="java" import="java.util.*,java.sql.*,javax.servlet.http.*" 
contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script language="javascript">
	function writeCheck(){
		var form=document.modifyform;
		if(!form.dbsubject.value){
			alert("제목을 적어주세요.")
			form.dbsubject.focus();
			return;
		}
		if(!form.dbmemo.value){
			alert("내용을 적어주세요.")
			form.dbmemo.focus();
			return;
		}
		form.submit();
	}
	function boardlist(){
		location.href='qnaList.do?current_page=${current_page}';
		
	}
</script>
<title>QnA</title>
</head>
<body>
<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">고객센터</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="faqList.do?current_page=1"> 자주하는 질문 </a></li>
				<li>- <a href="qnaList.do?current_page=1"> QnA </a></li>
				<li>- <a href="#"> Contact </a></li>
			</ul>
		</div>
	</div>
	
<!-- *********************** 내용 ****************************  -->
<c:url var="updateUrl" value="/qna_update.do"/>
<sf:form modelAttribute="boardData" method="POST" action="${updateUrl}" enctype="multipart/form-data">
	<table width="400" border="1" cellspacing="0" cellpadding="5">
		<input type="hidden" name="idx" value="${idx}">
		<input type="hidden" name="current_page" value="${current_page}">
		<tr>
			<td><b>제목</b></td>
			<td><sf:input path="subject" size="50" maxlength="50" /><br /> 
			<sf:errors path="subject" cssClass="error" /></td>
		</tr>
		<tr>
			<td><b>카테고리</b></td>
			<td><sf:select path="category">
				<sf:option value="signup" label="회원가입"/>
				<sf:option value="savings" label="예적금"/>
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
	</table>
	<table cellspacing="0" cellpadding="0" border="0" width="500">
		<tr>
			<td><input type="submit" value="재등록" />
				<input type="button" value="목록" onclick="javascript:boardlist()"/>
			</td>
		</tr>
	</table>
</sf:form>

<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
	
</body>
</html>
