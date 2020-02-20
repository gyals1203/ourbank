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
<title>�� �ۼ��ϱ�</title>
</head>
<body>

<!-- *********************** �Խ��� �۾��� �� ****************************  -->	
	<jsp:include page="../../header.jsp"></jsp:include>
	
<!-- *********************** ���̵� �޴� ****************************  -->	
	
		
	<div id="side_menu">
		<h4><a href="#">��ǰ�Ұ�</a></h4>
		<div id="side_div">
			<ul id="side_submenu">
				<li>- <a href="depositList.do?current_page=1">�� ��</a></li>
				<li>- <a href="savingList.do?current_page=1"> �� ��</a></li>
			</ul>
		</div>
	</div>
<!-- *********************** ���� ****************************  -->	
	
	<div id="board">
		����
	</div>
	
	
<!-- *********************** �Խ��� �۾��� �� ****************************  -->	

	<jsp:include page="../../footer.jsp"></jsp:include>
	
</body>
</html>