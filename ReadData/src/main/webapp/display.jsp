<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Display Page</h1>
	<h3>Name : ${userName}</h3>
	<h3>Id : ${userId}</h3>

	<hr>
	<h1>Person Details</h1>
	<h3>Name :${person.name}</h3>
	<h3>Age :${person.age}</h3>
	<h3>Phone :${person.phone}</h3>
</body>
</html>