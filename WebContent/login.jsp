<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<div>
			<table>
				<tr>
					<td>
						<h1>User Name:</h1> <input type="text" name="userId" />
					</td>
				</tr>
				<tr>
					<td>
						<h1>Password:</h1> 
						<input type="password" name="password">
						<br>
						<input type="submit" value="submit">
					</td>
			</table>
		</div>
	</form>

</body>
</html>