<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String ms = request.getParameter("ms");
	String ts = request.getParameter("ts");
	String giatam = request.getParameter("gia");
	String ml = request.getParameter("ml");
	//
	HttpSession session2=request.getSession();
	if(ms != null) {
		giohangbo gh;
		//Neu mua dau tien
		if(session.getAttribute("gh") == null) {
			gh = new giohangbo(); //tao gio hang
			session.setAttribute("gh", gh); //khoi tao session
		}
		gh = (giohangbo)session.getAttribute("gh"); //b1: lay session gan ra bien
		gh.Them(ms, ts, Long.parseLong(giatam), 1, ml); //b2: thay doi bien
		session.setAttribute("gh", gh); //b3: luu bien vao session
		
		response.sendRedirect("htgio.jsp"); //trang hien thi gio
	}
	%>

</body>
</html>