<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<div>
		오늘 접속자 수 : ${stats.count} 총 접속자 수 : ${totalCount}
	</div>
	<form action="">
	<div>
		<input type="text" placeholder="ID">
	</div>
	<div>
		<input type="password" placeholder="PW">
	</div>
	<div>
		<button type="button">Log-in</button>
	</div>
	</form>
</body>
</html>