<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*,java.text.*"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ID 중복체크</title>
<script type="text/javascript">
function reject(){
	window.opener.returnID();
}
</script>
</head>
<body>
<c:set var="check" value="${check}" />
<c:set var="id" value="${id}"/>

	<div align="center" >
	<b>${id}</b>
	<c:choose>
		<c:when test="${check}">
		는 사용 가능 합니다.
		</c:when>
		<c:otherwise >
		
		는 이미 존재하는 ID 입니다.
		
		</c:otherwise>
	</c:choose>
	<p>
	<a href="#" onclick="self.close();">닫기</a>
</div>
</body>
</html>