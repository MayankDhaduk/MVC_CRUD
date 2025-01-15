<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="reg" method="post">
		<input type="hidden" name="id" value="${udata.getId()}"> <label>Name</label>
		<input type="text" name="name" value="${udata.getName()}"> <label>Email</label>
		<input type="email" name="email" value="${udata.getEmail()}">
		<input type="submit"> <span><a href="display">View
				User</a></span>
	</form>

</body>
</html>