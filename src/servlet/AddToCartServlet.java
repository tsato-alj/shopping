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

import common.Shopping;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addtocart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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
		String mode = null;
		String itemId = null;
		Integer quantity = null;
		HttpSession session = request.getSession(true);
		String userId = (String)session.getAttribute("userId");
		if(session.getAttribute("mode") != null){
			mode = (String)session.getAttribute("mode");
		}else{
			mode = request.getParameter("mode");
		}
		if(userId != null){
			if(mode != null){
				session.removeAttribute("mode");
				if(request.getParameter("itemId") != null){
					itemId = request.getParameter("itemId");
				}else if(session.getAttribute("itemId") != null){
					itemId = (String)session.getAttribute("itemId");
				}
				session.removeAttribute("itemId");
				if(request.getParameter("quantity") != null){
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}else if(session.getAttribute("quantity") != null){
					quantity = (Integer)session.getAttribute("quantity");
				}
				session.removeAttribute("quantity");
				try {
					Shopping.addToCart(userId, itemId, quantity);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				session.setAttribute("mode", "/shopping?mode=itemList");
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/shopping");
				rd.forward(request, response);

			}
		}else if(mode != null){
			session.setAttribute("mode", mode);
			session.setAttribute("itemId", itemId);
			session.setAttribute("quantity", quantity);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/needLogin.jsp");
			rd.forward(request, response);
		}
	}

}
