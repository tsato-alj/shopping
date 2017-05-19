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
 * Servlet implementation class SellingServlet
 */
@WebServlet("/selling")
public class SellingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		request.setCharacterEncoding("UTF-8");
		String choice = request.getParameter("choice");
		if(session.getAttribute("userId") != null){
			if(choice != null){
				if(choice.equals("recordItem")){
					ServletContext context = getServletContext();
					RequestDispatcher rd = context.getRequestDispatcher("/recordItem.jsp");
					rd.forward(request, response);
				}
			}
		}else {
			request.setAttribute("sellingChoice", choice);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/needLogin.jsp");
			rd.forward(request, response);
		}
	}

}
