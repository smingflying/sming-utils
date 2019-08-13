<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="update">
		<input type="hidden" value="${nl.id }" name="id">
		标题：<input type="text" name="title" value="${nl.title }">
		权重：<input type="text" name="score" value="${nl.score }">
		<input type="submit">
	</form>
</body>
</html>