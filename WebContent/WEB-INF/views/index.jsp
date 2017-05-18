<%@page import="java.util.List"%>
<%@ page import="com.jx372.guestbook.vo.GuestBookVo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="./gb?a=add" method="post">
	<table border="1" width="600">
	<!-- <input type="hidden" name="a" value="add"> -->
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan="4"><textarea name="message" cols="60" rows="5"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right"><input type="submit" VALUE="등록 "></td>
		</tr>
	</table>
	</form>
	<br>
	<%
	for(GuestBookVo vo : list)
	{
%>
	<table width="600" border="1">
		<tr>
			<td style="text-align: center;"><%=vo.getNo() %></td>
			<td style="text-align: center;"><%=vo.getName() %></td>
			<td style="text-align: center;"><%=vo.getDate() %></td>
			<td style="text-align: center;"><a href="gb?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4"><textarea rows="4" cols="60"><%=vo.getMessage() %></textarea></td>
		</tr>
	</table>
	<br>
	<%} %>
</body>
</html>