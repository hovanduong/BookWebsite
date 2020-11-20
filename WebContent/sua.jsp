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
	String ms=request.getParameter("ms");
	String sltam=request.getParameter("txtsl");

	gh.Them(ms, "", (long)0, Long.parseLong(sltam), "");
	session.setAttribute("gh", gh);
	//response.sendRedirect("htgio.jsp");
	response.sendRedirect("giohangcontroller");
%>
</body>
</html>