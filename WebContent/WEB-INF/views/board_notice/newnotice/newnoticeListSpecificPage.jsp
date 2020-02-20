<%@ page language="java"
	import="java.util.*,java.sql.*,javax.servlet.http.*"
	contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.text.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page session="false"%>
<%@page import="com.ourbank.app.bean.NewnoticeBoard_Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="com.ourbank.app.PageNumberingManager"%>

<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<meta http-equiv="Content-Type" content="text/html" ; charset="EUC-KR">
<title>newnotice</title>
<script>
function totallist(){
	location.href='newnoticeList.do?current_page=1';
}
function signuplist(){
	location.href='newnoticeSignUpList.do?current_page=1';
}
function savingslist(){
	location.href='newnoticeSavingsList.do?current_page=1';
}
function etclist(){
	location.href='newnoticeEtcList.do?current_page=1';
}
</script>
</head>
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	
	<jsp:include page="../../header.jsp"></jsp:include>
	
<!-- *********************** ���̵� �޴� ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="introductionList.do?current_page=1">��������</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="introductionList.do?current_page=1"> ����Ʈ�Ұ� </a></li>
				<li>- <a href="newnoticeList.do?current_page=1"> ���ҽ� </a></li>
				
			</ul>
		</div>
	</div>
	
<!-- *********************** ���� ****************************  -->
<div>
<c:set var="current_page" value="${current_page}" />
<c:set var="total_cnt" value="${totalCnt}" />
<%
	int c_page = Integer.parseInt((String) (pageContext.getAttribute("current_page")));
	pageContext.setAttribute("c_page", c_page);
%>
<table width="700">
	<tr>
		<td>
				<div style="float: left; width: 40%; padding:10px;" >
					<button type="button" onclick="javascript:totallist()">��ü</button>
					<button type="button" onclick="javascript:signuplist()">���ະ ����</button>
					<button type="button" onclick="javascript:savingslist()">��ǰ�� ����</button>
					<button type="button" onclick="javascript:etclist()">��Ÿ����</button>
				</div>
				<div style="float: right; width: 50%; vertical-align: center">
					<form name=searchf method=post action="newnoticeSearch.do">
						<input type="text" name="searchStr" size="30" maxlenght="50">
						<input type="submit" value="��ã��">
					</form>
				</div>
		
		</td>
	</tr>
</table>
<table cellspacing=1 width=700 border=0>
	<tr>
		<td>�� �Խù���: <c:out value="${totalCnt}" /></td>
		<td><p align="right">
				������:
				<c:out value="${current_page}" />
			</p></td>
	</tr>

</table>

<table cellspacing=1 width=700 border=1>
	<tr>
		<td width="50"><p align="center">��ȣ</td>
		<td width="100"><p align="center">���̵�</td>
		<td width="320"><p align="center">����</td>
		<td width="100"><p align="center">�����</td>
		<td width="100"><p align="center">��ȸ��</td>
	</tr>
	<c:forEach var="board" items="${boardList}">
		<tr>
			<td width="40"><p align="center">${board.getIdx()}</p></td>
			<td width="100"><p align="center">${board.getId()}</p></td>
			<td width="320">
				<p align="center">
					<a
						href="newnoticeView.do?idx=${board.getIdx()}
							&current_page=<c:out value="${current_page}"/>
							&searchStr=None"
						title="${board.getContent()}"> <c:out
							value="${board.getSubject()}" /></a>
				</p>
			</td>
			<td width="100"><p align="center">
					<c:out value="${board.getCreated_date()}" />
				</p></td>
			<td width="100"><p align="center">
					<c:out value="${board.getHits()}" />
				</p></td>
		</tr>
	</c:forEach>
	<%
		int rowsPerPage = 10;
		int total_cnt = ((Integer) (pageContext.getAttribute("total_cnt"))).intValue();

		int total_pages = PageNumberingManager.getInstance().getTotalPage(total_cnt, rowsPerPage);
		pageContext.setAttribute("t_pages", total_pages);
	%>
</table>
<table cellspacing="1" width="700" border="1">
	<tr>
		<td><c:forEach var="i" begin="1" end="${t_pages}">
				<a href="newnoticeList.do?current_page=${i}"> [ <c:if
						test="${i==c_page}">
						<b>
					</c:if> ${i} <c:if test="${i==c_page}">
						<b>
					</c:if> ]
				</a>
			</c:forEach></td>
	</tr>
</table>
<%-- <c:if test="sessionID�� admin�̸�"> --%> 
<table cellspacing="1" width="700">
	<tr>
		<td><input type="button" value="�۾���"
			onclick="window.location='newnotice_show_write_form.do'"></td>
	</tr>
</table>
<%-- </c:if> --%>
</div>	
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
</html>