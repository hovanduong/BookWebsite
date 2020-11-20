package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class datmuacontroller
 */
@WebServlet("/datmuacontroller")
public class datmuacontroller extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datmuacontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ms = request.getParameter("ms");
		String ts = request.getParameter("ts");
		String giatam = request.getParameter("gia");
		String ml = request.getParameter("ml");
		//
		HttpSession session2=request.getSession();
		if(ms != null) {
			giohangbo gh;
			//Neu mua dau tien
			if(session2.getAttribute("gh") == null) {	
				gh = new giohangbo(); //tao gio hang
				session2.setAttribute("gh", gh); //khoi tao session
			}
			gh = (giohangbo)session2.getAttribute("gh"); //b1: lay session gan ra bien
			gh.Them(ms, ts, Long.parseLong(giatam), 1, ml); //b2: thay doi bien
			session2.setAttribute("gh", gh); //b3: luu bien vao session
			
			RequestDispatcher rd=request.getRequestDispatcher("BookController");
			rd.forward(request, response);
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
