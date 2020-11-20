<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="bean.bookbean" %>
    <%@page import="bo.bookbo" %>
    <%@page import="bo.loaibo" %>
    <%@page import="bean.loaibean" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
  <style type="text/css">
  	td {
  		padding: 10px;
  	}
  </style>
</head>
<body>
<%
	int dem=0;
	if(session.getAttribute("gh") != null){
		giohangbo gh4=(giohangbo)session.getAttribute("gh");
		dem=gh4.ds.size();
	}
%>
<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="BookController">Trang chủ</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="giohangcontroller">Giỏ hàng <%=dem %> </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Thanh toán</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="#">Lịch sử mua hàng</a>
    </li>
  </ul>
  
  <form class="form-inline">
    <input class="form-control mr-sm-2" type="text" placeholder="Search" name="txttk">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
  
</nav>

<% // lay loại
	loaibo lbo=new loaibo();
	ArrayList<loaibean> dsloai=lbo.getloai();
	
%>		
<div class="container-fluid">
  
  <div class="container-fluid">
    <div class="row">
   
      <div class="col-sm-3">
      		<table width="100%" align="center">
				<td width="200" valign="top">
		<%for(loaibean s: dsloai){ %>
			<tr>
				<td>
					<a href="BookController?ml=<%=s.getMaloai() %>">
					<%=s.getTenloai() %>
						</a>
				</td>
			</tr>
		<% }%>
				</td>	
				<td width="600" valign="top">
			</table>
      </div>
      <div class="col-sm-9 ">
      		<h1> Gio hang </h1>	
	<table class="table-bordered" >
		<%
			giohangbo gh =(giohangbo) session.getAttribute("gh");
		
			if(gh != null ){
				for(giohangbean g: gh.ds){%>
					<tr>
					<td><%=g.getMasach()%> <td><%=g.getTensach() %></td>
					<td><%=g.getGia()%> <td><%=g.getSoluong() %></td>
					<td>
					<form method="post" action="sua.jsp?ms=<%=g.getMasach()%>">
						<input type="number" name="txtsl">
						<input type="submit" name="but2" value="Update">	
					</form>
					</td>
					<td><%=g.getThanhtien()%></td>
					<td><a href="xoa.jsp?ms=<%=g.getMasach()%>">Xoa</a> </td>
					</tr>
				<%}	}%>
				
	</table>
      </div>
    </div>  
</div>	
	
	
		
	
	
	
</body>
</html>