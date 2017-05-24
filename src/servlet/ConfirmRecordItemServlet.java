package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmRecordItemServlet
 */
@WebServlet("/confirmrecorditem")
public class ConfirmRecordItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmRecordItemServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String itemId = request.getParameter("itemId");
		request.setAttribute("itemId", itemId);
		String itemName = request.getParameter("itemName");
		request.setAttribute("itemName", itemName);
		String category = request.getParameter("category");
		request.setAttribute("category", category);
		Integer price = Integer.valueOf(request.getParameter("price"));
		request.setAttribute("price", price);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/confirmRecordItem.jsp");
		rd.forward(request, response);
	}
}