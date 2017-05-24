package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Selling;

/**
 * Servlet implementation class ResultRecorditemServlet
 */
@WebServlet("/resultrecorditem")
public class ResultRecorditemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultRecorditemServlet() {
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
		request.setCharacterEncoding("UTF-8");String itemId = request.getParameter("itemId");
		String itemName = request.getParameter("itemName");
		HttpSession session = request.getSession(true);
		int price = Integer.parseInt(request.getParameter("price"));
		String producerId = (String)session.getAttribute("userId");
		String category = request.getParameter("category");
		try {
			Selling.recordItem(itemId, itemName, price, producerId, category);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		request.setAttribute("itemId", itemId);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/addItemImage.jsp");
		rd.forward(request, response);

	}

}