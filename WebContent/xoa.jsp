<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	giohangbo gh=(giohangbo) session.getAttribute("gh");
	gh.xoa(request.getParameter("ms"));
	session.setAttribute("gh", gh);
	response.sendRedirect("htgio.jsp");
%>
</body>
</html>