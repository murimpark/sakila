<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script>
	$(document).ready(function(){
		$("#login").click(function() {
			$("form").submit();
		});
	});
</script>
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<div>
		오늘 접속자 수 : ${stats.count} 총 접속자 수 : ${totalCount}
	</div>
	<form>
	<div>
		<input class="form-group" type="text" placeholder="ID" id="id">
	</div>
	<div>
		<input class="form-group" type="password" placeholder="PW" id="pw">
	</div>
	<div>
		<button class="form-group btn btn-primary" type="button" id="login">Log-in</button>
	</div>
	</form>
</div>
</body>
</html>