<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<form action="custregi" method="post">
		<tr>
			<td> 이름 </td>
			<td> <input type="text" name="name" size = "100"> </td>
			
		</tr>
		<tr>
			<td> 비밀번호 </td>
			<td> <input type="text" name="password" size = "100" ></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="입력">
		</tr>
	</form>
</table>
</body>
</html>