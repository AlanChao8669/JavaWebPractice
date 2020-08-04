<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1><%=request.getServletContext().getInitParameter("errorMsg")%> 
	</h1>
	<form action="return_login">
		<input name="button" type="submit" id="button" value="返回">
	</form>
</body>
</html>