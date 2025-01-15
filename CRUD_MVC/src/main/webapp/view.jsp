<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th colspan="2">Action</th>
		</tr>

		<c:forEach var="dt" items="${data}">
			<tr>
				<td>${dt.getName()}</td>
				<td>${dt.getEmail()}</td>
				<td><a href="update?action=edit&id=${dt.getId()}">Edit</a></td>
				<td><a href="update?action=delete&id=${dt.getId()}">Delete</a></td>

			</tr>


		</c:forEach>



	</table>

</body>
</html>