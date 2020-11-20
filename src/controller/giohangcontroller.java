package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.bookbo;
import bo.giohangbo;
import bo.loaibo;

/**
 * Servlet implementation class giohangcontroller
 */
@WebServlet("/giohangcontroller")
public class giohangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    loaibo lbo=new loaibo();
    giohangbo gh=new giohangbo();
//	ArrayList<loaibean> dsloai=lbo.getloai();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
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
				gh = (giohangbo)request.getAttribute("gh"); //b1: lay session gan ra bien
				gh.Them(ms, ts, Long.parseLong(giatam), 1, ml); //b2: thay doi bien
				session2.setAttribute("gh", gh); //b3: luu bien vao session
				RequestDispatcher rd=request.getRequestDispatcher("htgio.jsp");
				//trang hien thi gio
			}
			
			request.setCharacterEncoding("utf-8"); // lay du lieu len unicode
			response.setCharacterEncoding("utf-8");// gui du lieu ve unicode
			request.setAttribute("dsloai", lbo.getloai());
			request.setAttribute("gh1", gh.ds);
			
			RequestDispatcher rd=request.getRequestDispatcher("htgio.jsp");
			rd.forward(request, response);
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
