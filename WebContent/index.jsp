<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Hello,
		<%=request.getAttribute("userId")%>.
	</h1>
	<h2>This is my first servlet.</h2>
	<h2>
		There are
		<%=request.getAttribute("userNum")%>
		users online.
	</h2>
</body>
</html>