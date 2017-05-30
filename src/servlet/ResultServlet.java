package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.HistoryBean;
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
		HttpSession session = request.getSession(true);
		ArrayList<ItemBean> cart =(ArrayList<ItemBean>)session.getAttribute("cart");
		String userId = (String)session.getAttribute("userId");
		ItemBean item = null;
		String itemId = null;
		Integer quantity = 0;
		for(int i = 0; i < cart.size(); i++){
			item = cart.get(i);
			itemId = item.getItemId();
			quantity = item.getItemQuantity();
			try {
				ShoppingDao Dao = new ShoppingDao();
				Dao.updateItem(itemId, quantity);
				Dao.updateHistory(userId, itemId, quantity);
				Dao.deleteCart(userId);
				Dao.close();
				session.removeAttribute("cart");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		HistoryBean newestHistory = null;
		try {
			ArrayList<HistoryBean> histories = Shopping.getHistory(userId);
			for(HistoryBean history: histories){
				newestHistory = history;
			}
			Integer historyId = newestHistory.getOrderId();
			request.setAttribute("historyId", historyId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/result.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}