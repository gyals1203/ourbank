<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">  
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css" >
<script src="https://kit.fontawesome.com/9bbe6ae1b4.js" crossorigin="anonymous"></script>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="EUC-KR">
<title>예금상품 리스트</title>
<script type="text/javascript">
function go_to_site(){
	alert(site);
	location.href=site;
}
function paging(page){
	location.href="depositList.do?current_page="+page;
}
function pre_paging(page){
	var pre_page=page-1;
	location.href="depositList.do?current_page="+pre_page;
}
function after_paging(page){
	var after_page=page+1;
	location.href="depositList.do?current_page="+after_page;
}


</script>
</head>
<body>

<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	
	<jsp:include page="../../header.jsp"></jsp:include>
	
<!-- *********************** 사이드 메뉴 ****************************  -->	
	
	<div id="side_menu">
		<h4><a href="#">상품소개</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="depositList.do?current_page=1">예 금</a></li>
				<li>- <a href="savingList.do?current_page=1"> 적 금</a></li>
			</ul>
		</div>
	</div>
	
<!-- *********************** 내용 ****************************  -->
<table id="product_search" >
	<tr>
	<td align="right">
	<select name="bank">
	<c:forEach var="all_bank" items="${all_bank}">
		<option label="${all_bank.getKor_co_nm()}" value="${all_bank.getKor_co_nm()}"></option>
	</c:forEach>
	</select>
	<input type="text" >
	<input type="button" value="찾기" width="100px"></td>
	</tr>
</table>
<hr width="65%">
	<table align="center" id="product_table" width="60%" >
		<c:forEach var="boardList" items="${boardList}">
		
			<tr >
			
				<td><p id="product_name">${boardList.getFin_prdt_nm()}</p></td>
				<td>${boardList.getKor_co_nm()}</td>
				<td>금리 ${boardList.getIntr_rate()}%</td>
				<td>우대금리 ${boardList.getIntr_rate2()}%</td>
				<td>${boardList.getIntr_rate_type_nm()}</td>
				<td>( ${boardList.getSave_trm()} 개월)</td>
				
				<td><a href="#"><i class="fas fa-cart-plus"></i></a></td>
				<td><button><a href="${boardList.getHomp_url()}" target="blank">가입하기</a></button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr width="65%">
	<table align="center">
		<tr>
		<td>
			<input type="button" value="<<" onclick="paging(1)"/>
		</td>
		<td>
			<c:if test="${current_page>1}">
			<input type="button" value="<" onclick="pre_paging(${current_page})"/>
			</c:if>
		</td>
		<td>
		<c:forEach var="i" begin="${current_page}" end="${last_page}">
			<c:if test="${i<total_page}">
				<input type="button" value="${i}" onclick="paging(${i})"/>
			</c:if>
		</c:forEach>
		</td>
		<td>
			<c:if test="${current_page<total_page-1}">
			<input type="button" value=">" onclick="after_paging(${current_page})"/>
		
			</c:if>
		</td>
		<td>
			<input type="button" value=">>" onclick="paging(${total_page-1})"/>
		</td>
		</tr>
	</table>
	<hr width="65%">
	<!-- *********************** 게시판 글쓰기 폼 ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
	
</body>
</html>