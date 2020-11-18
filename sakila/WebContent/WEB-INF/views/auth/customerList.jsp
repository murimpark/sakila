<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$.ajax({
			type:'GET',
			url:'/frontend-backend-sakila/CustomerServlet',
			success:function(result){
				$(result).each(function(index, item){
					$('#customerList').append('<tr>');
					$('#customerList').append('<td>'+item.customerId+'</td>');
					$('#customerList').append('<td>'+item.storeId+'</td>');
					$('#customerList').append('<td>'+item.firstName+'</td>');
					$('#customerList').append('<td>'+item.lastName+'</td>');
					$('#customerList').append('<td>'+item.email+'</td>');
					$('#customerList').append('</tr>');
				});
			}
		});
	});
</script>
</head>
<body>
	<h1>고객 리스트</h1>
	<table border="1">
		<thead>
			<tr>
				<th>customer id</th>
				<th>store id</th>
				<th>first name</th>
				<th>last name</th>
				<th>email</th>
			</tr>
		</thead>
		<tbody id="customerList">
		</tbody>
	</table>
</body>
</html>
