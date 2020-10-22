<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<h1>기본 화면</h1>
	<div>
		<span>${loginStaff.eamil}</span>관리자님
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/logoutServlet">logout</a>
	</div>
</body>
</html>