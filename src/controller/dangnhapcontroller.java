package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import bean.bookbean;
import bean.dangnhapbean;
import bo.dangnhapbo;
import bo.giohangbo;
import dao.dangnhapdao;

/**
 * Servlet implementation class dangnhapcontroller
 */
@WebServlet("/dangnhapcontroller")
public class dangnhapcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    dangnhapbo dn=new dangnhapbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			String txtDangNhap = request.getParameter("txtDangNhap");
			String txtPassDangNhap = request.getParameter("txtPassDangNhap");
			
			//dangnhapbean dn=new dangnhapbean(txtDangNhap, txtPassDangNhap);
			request.setCharacterEncoding("utf-8"); // lay du lieu len unicode
			response.setCharacterEncoding("utf-8");// gui du lieu ve unicode
			
			ArrayList<dangnhapbean> ds=dn.getDangNhap(); 
			int n=ds.size();
			HttpSession session2=request.getSession();
			for(int i=0;i<n;i++) {
				dangnhapbean dnbean=ds.get(i);
				
				if(txtDangNhap.equals(dnbean.getTendangnhap()) && txtPassDangNhap.equals(dnbean.getMatkhau())) {
					dangnhapbean user;
					
					if(session2.getAttribute("user") == null) {
						user = new dangnhapbean(txtDangNhap, txtPassDangNhap); //tao gio hang
						session2.setAttribute("user", user); //khoi tao session
						response.sendRedirect("BookController"); // di chuyeenr dden bookcontroller
					}
					break;
				}
			}
			
			
				
			
			//RequestDispatcher rd=request.getRequestDispatcher("BookController");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
