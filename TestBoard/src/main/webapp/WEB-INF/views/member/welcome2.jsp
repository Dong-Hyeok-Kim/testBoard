<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
welcome : member

<hr>

<c:if test="${not empty pageContext.request.userPrincipal}">
<p> is Log-In</p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal}">
<p> is Log-Out</p>
</c:if>

USER ID : ${pageContext.request.userPrincipal.name}<br/>
<a href="/logout">Log out</a><br />


<hr>
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>작성자</td>
		<td>계좌번호</td>
		<td>잔액</td>
	</tr>
	<c:forEach items="${list}" var ="dto">
	<tr>
		<td>${dto.name}</td>
		<td>${dto.account}</td>
		<td>${dto.balance}</td>
	</td>
	</c:forEach>
</table>
<hr>
<form action="send" method="post">
송금액 <input type="text" name="amount" size ="100"><br>
보낼계좌 <input type="text" name="accountToSend" size ="100"><br>
내계좌 <input type="text" name="myAccount" size ="100"><br>
내계좌 잔액 <input type="text" name="balance" size ="100"><br>
<input type="submit" value="송금버튼">
</form>


</body>
</html>