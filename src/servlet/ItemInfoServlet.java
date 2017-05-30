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

import bean.ItemBean;
import bean.LoginUserBean;
import common.Shopping;

/**
 * Servlet implementation class ItemInfo
 */
@WebServlet("/iteminfo")
public class ItemInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemInfoServlet() {
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
		String itemId = null;
		if(request.getParameter("itemId") != null){
			itemId = request.getParameter("itemId");
		}else if(request.getAttribute("itemId") != null){
			itemId = (String)request.getAttribute("itemId");
		}

		String producerId = null;
		LoginUserBean producer = null;
		ItemBean item = null;
		try {
			item = Shopping.getItem(itemId);
			request.setAttribute("item", item);
			producerId = item.getItemProducerId();
			producer = Shopping.getProducer(producerId);
			request.setAttribute("producer", producer);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//review disp
		ReviewDao review;
		ReviewBean reviewbean = null;
		try{
			review = new ReviewDao();
			reviewbean = review.reviewSelect(itemId);
			request.setAttribute("review", reviewbean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}




		//
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/itemInfo.jsp");
		rd.forward(request, response);
	}
}