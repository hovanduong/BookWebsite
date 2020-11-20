<%@page import="bean.dangnhapbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="bean.bookbean" %>
    <%@page import="bo.bookbo" %>
    <%@page import="bo.loaibo" %>
    <%@page import="bean.loaibean" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>NhaSachMinhKhai</title>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="style.css">
  
  <style>
  .modal-header, h4, .close {
    background-color: #5cb85c;
    color:white !important;
    text-align: center;
    font-size: 30px;
  }
  .modal-footer {
    background-color: #f9f9f9;
  }
  
  <%@include file="style.css"%>	
  
  
  
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
      <a class="nav-link" href="#">Lịch sử mua hàng</a>    </li>
      
  </ul>
  
  <form class="form-inline" method="post" action="BookController">
    <input class="form-control mr-sm-2" type="text" placeholder="Search" name="txttk">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
  <ul class="nav navbar-nav ml-auto">
  		<%
  		dangnhapbean dnbean=(dangnhapbean)session.getAttribute("user");
  		// Ở đây  kiểm tra xem đã đăng nhập hay chưa(bằng session)...lấy ra
  		// Nếu chưa đăng nhập thì add hai thẻ đăng ký đăng nhập ở phía dưới, nếu rồi thì add hai thẻ xin chào {} với đăng xuất
  		if(session.getAttribute("user") != null){ 
  		%>
  		
  		
  		
  		<li>	
  				<a href="#" class="nav-link">Xin chào <%=dnbean.getTendangnhap() %></a>
  		</li>
	  		<li class="nav-item">
	  			<a href="dangxuatcontroller"  class="nav-link">Đăng Xuất</a>	
	  			
			</li>
			
  		<%	
  		}else{ %>
  		<li class="nav-item">
  			<a href="#" onclick="document.getElementById('id02').style.display='block'" class="nav-link">Đăng Ký</a>		
		</li>
	
		<li class="nav-item">
  			<a href="#" onclick="document.getElementById('id01').style.display='block'" class="nav-link">Đăng nhập</a>
		</li>
  		
  		<%} 
  		%>
	
		
		

  </ul>
  
</nav>

<div id="id02" class="modal">
 
	  <form class="modal-content animate" action="dangkycontroller" method="post">
	    <div class="imgcontainer">
	      <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
	      <img src="cak.png" alt="Avatar" class="avatar">
	    </div>
 
	    <div class="container">
	      <label for="txtusername"><b>Username</b></label>
	      <input type="text" placeholder="Enter Username" name="txtusername" required>
	      
	      <label for="txtHoTen"><b>Name</b></label>
	      <input type="text" placeholder="Enter Name" name="txtHoTen" required>
	      
	      <label for="txtdiachi"><b>Addres</b></label>
	      <input type="text" placeholder="EnTer Addres" name="txtdiachi" required>
	      
	      <label for="txtPhone"><b>Phone</b></label>
	      <input type="text" placeholder="Enter Phone" name="txtPhone" required>
	      
	      <label for="txtMail"><b>Mail</b></label>
	      <input type="email" placeholder="Enter Mail" name="txtMail" required>
 
	      <label for="txtPassword"><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="txtPassword" required>
	      
	     <label for="txtRepeatPassword"><b>Password</b></label>
	      <input type="password" placeholder="Enter Repeat Password" name="txtRepeatPassword" required>
	      
 
	      <button class="dangkybtn" type="submit" name="btndangky">Đăng Ký</button>
	      <label>
	        <input type="checkbox" checked="checked" name="remember"> Remember me
	      </label>
	    </div>
 
	    <div class="container" style="background-color:#f1f1f1">
	      <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
	      <span class="psw">Forgot <a href="#">password?</a></span>
	    </div>
	  </form>
	</div>
	<script>
	// Get the modal
	var modal = document.getElementById('id02');
 
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	</script>
	
	



<div id="id01" class="modal">
 
	  <form class="modal-content animate" action="dangnhapcontroller" method="post">
	    <div class="imgcontainer">
	      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
	      <img src="cak.png" alt="Avatar" class="avatar">
	    </div>
 
	    <div class="container">
	      <label for="txtDangNhap"><b>Username</b></label>
	      <input type="text" placeholder="Enter Username" name="txtDangNhap" required>
 
	      <label for="txtPassDangNhap"><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="txtPassDangNhap" required>
 
	      <button class="loginbtn" type="submit">Login</button>
	      <label>
	        <input type="checkbox" checked="checked" name="remember"> Remember me
	      </label>
	    </div>
 
	    <div class="container" style="background-color:#f1f1f1">
	      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
	      <span class="psw">Forgot <a href="#">password?</a></span>
	    </div>
	  </form>
	</div>
	<script>
	// Get the modal
	var modal = document.getElementById('id01');
 
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	</script>
	
	

	
	
	


<% // lay loại
	/*loaibo lbo=new loaibo();
	ArrayList<loaibean> dsloai=lbo.getloai();
	
//lay sách
	bookbo dbo=new bookbo();
	ArrayList<bookbean> ds= dbo.getsach();
	String ml=request.getParameter("ml");
	String key=request.getParameter("txttk");
	if(ml != null){
		ds=dbo.TimSachTheoMa(ml);
	}
	if(key != null) ds=dbo.TimSach(key);*/
	ArrayList<loaibean> dsloai=(ArrayList<loaibean>)request.getAttribute("dsloai");
	ArrayList<bookbean> ds=(ArrayList<bookbean>)request.getAttribute("dssach");
	int n=ds.size();
%>	
<div class="container-fluid">
  
  <div class="container-fluid">
    <div class="row">
   
      <div class="col-sm-3">
      			<table width="100%" align="center">
	<td width="200" valign="top">
		<%for(loaibean s:dsloai){ %>
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
      		<table>
		<%
			for(int i=0;i<n;i++){%>
			<tr>
				<td>
				<% bookbean s=ds.get(i); %>
					<img src="<%=ds.get(i).getAnh()%>"width="200" height="300"> <br>
					<%=ds.get(i).getTensach() %><br>
					<%=ds.get(i).getTacgia() %><br>
					<%=ds.get(i).getGia() %></br>
					<a href="datmuacontroller?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>&ml=<%=s.getMaloai()%>"> <img src="buynow.jpg" ></a>
				</td>
				<%i++; if(i<n){%>
				<td>
					<% s=ds.get(i); %>
					<img src="<%=ds.get(i).getAnh() %>"width="200" height="300"><br>
					<%=ds.get(i).getTensach() %><br>
					<%=ds.get(i).getTacgia() %><br>
					<%=ds.get(i).getGia() %><br>
					<a href="datmuacontroller?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>&ml=<%=s.getMaloai()%>"> <img src="buynow.jpg" ></a>
				</td>
				<%} %>	
				<%i++; if(i<n){%>
				<td>
				<% s=ds.get(i); %>
					<img src="<%=ds.get(i).getAnh() %>"width="200" height="300"><br>
					<%=ds.get(i).getTensach() %><br>
					<%=ds.get(i).getTacgia() %><br>
					<%=ds.get(i).getGia() %><br>
					<a href="datmuacontroller?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>&ml=<%=s.getMaloai()%>"> <img src="buynow.jpg" ></a>
				</td>
				<%} %>	
			</tr>
			<%}%>
	</table>
      
      </div>
    </div>  
</div>	
	
	
	
</body>
</html>