package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ModeChange
 */
@WebServlet("/modechange")
public class ModeChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModeChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("trymodechange");
		HttpSession session = null;
		if(request.getParameter("mode") != null){
			if(request.getParameter("mode").equals("vegetalian")){
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ForVegetalian.jsp");
				rd.forward(request, response);
			}else if(request.getParameter("mode").equals("producer")){
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ForProducer.jsp");
				rd.forward(request, response);
			}
		}
	}

}