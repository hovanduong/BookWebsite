package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.bookbean;
import bo.bookbo;
import bo.loaibo;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**	
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    loaibo lbo=new loaibo();
    bookbo bbo=new bookbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8"); // lay du lieu len unicode
			response.setCharacterEncoding("utf-8");// gui du lieu ve unicode
			request.setAttribute("dsloai", lbo.getloai());
			request.setAttribute("dssach", bbo.getsach());	
			String ml=request.getParameter("ml");
			String key=request.getParameter("txttk");
			ArrayList<bookbean> dssach;
			if(ml != null ) 
				dssach=bbo.TimSachTheoMa(ml);
			else
					if(key != null)
							dssach=bbo.TimSach(key);
					else
						dssach=bbo.getsach();
			request.setAttribute("dssach", dssach);
			RequestDispatcher rd=request.getRequestDispatcher("Book.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
