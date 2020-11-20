package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.dangkybean;
import bo.dangkybo;
import dao.dangkydao;

/**
 * Servlet implementation class dangkycontroller
 */
@WebServlet("/dangkycontroller")
public class dangkycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkycontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    dangkybo dkbo=new dangkybo();
    dangkydao dkdao=new dangkydao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8"); // lay du lieu len unicode
			response.setCharacterEncoding("utf-8");// gui du lieu ve unicode
			//request.setAttribute("dsDkdo", dkbo.ds);
			String txtHoten=request.getParameter("txtHoTen");
			String txtUser=request.getParameter("txtusername");
			String txtDiaChi=request.getParameter("txtdiachi");
			String txtPhone=request.getParameter("txtPhone");
			String txtMail=request.getParameter("txtMail");
			String txtPassWord=request.getParameter("txtPassword") ;
			String txtRePeatPassWord=request.getParameter("txtRepeatPassword");
			
			String btnDangky=request.getParameter("btndangky");
			ArrayList<dangkybean> dsdk;
		//	dsdk=dkbo.DangKy(txtHoten, txtDiaChi, txtPhone, txtMail, txtUser, txtPassWord);
		//	request.setAttribute("dsSingUp", dkdao.signUp(txtHoten, txtDiaChi, txtPhone, txtMail, txtUser, txtPassWord));
			//request.setAttribute("ds", dkdao.auth(txtUser, txtPassWord));
			//request.setAttribute("dsCheck", dkdao.checkUserExist(txtUser));
		
			dkdao.signUp(txtHoten, txtDiaChi, txtPhone, txtMail, txtUser, txtPassWord) ;
				
			RequestDispatcher rd=request.getRequestDispatcher("BookController");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
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
