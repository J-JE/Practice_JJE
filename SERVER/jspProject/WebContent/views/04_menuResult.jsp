<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String menu = (String)request.getAttribute("menu");
	int price = (int)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>감사합니다</h2>
	<p>주문하신 <%=menu %>, 결재금액은 <%= price %> 원 입니다.</p>

</body>
</html>