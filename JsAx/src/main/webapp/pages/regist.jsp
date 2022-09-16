<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Regist</title>
		<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script>
			$(document).ready(function(){
				alert("jquery ready");
				$("#idChecker").on("click", function(){
					let value = $("#userId").val();
					alert(value);
					
					$.ajax({
						type: "get",
						dataType: "text",
						async: false,
						url: "../Controller?command=checkId",
						data: {userId : value},
						success: function(data, status){
							console.log("success data: " + data);
						},
						error: function(data, status){
							console.log("fail status: " + status);
						},
						complete: function(data, status){
							console.log("ajax completed");
						}
					});
				});
			});
		</script>
	</head>
	<body>
		<form action="./Controller?command=create" method="post">
			<table>
				<tr>
					<td>id</td>
					<td><input type="text" name="userId" id="userId" value=""><input type="button" id="idChecker" value="check"></td>
				</tr>
				<tr>
					<td>pwd</td>
					<td><input type="password" name="pwd" id="pwd"></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
				
			</table>
		</form>
	</body>
</html>