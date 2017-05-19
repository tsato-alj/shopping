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

import bean.ItemBean;
import common.Shopping;
import dao.ShoppingDao;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String itemId = (String)request.getParameter("item_id");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		try {
			ItemBean item = (ItemBean)Shopping.getItem(itemId);
			ShoppingDao shoppingDao = new ShoppingDao();
			shoppingDao.updateItem(item.getItemId(), quantity);
			HttpSession session = request.getSession(true);
			String userId = (String)session.getAttribute("userId");
			shoppingDao.updateHistory(userId, item.getItemId(), quantity);
			shoppingDao.close();
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
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