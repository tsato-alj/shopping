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

import bean.ItemBean;
import bean.LoginUserBean;
import common.Shopping;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/shopping")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
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
				if(mode.equals("itemList")){
					try {
						ArrayList<ItemBean> itemBeanList = Shopping.getItem();
						request.setAttribute("itemBeanList", itemBeanList);
						ServletContext context = getServletContext();
						RequestDispatcher rd = context.getRequestDispatcher("/itemList.jsp");
						rd.forward(request, response);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}else if(mode.equals("/shopping?mode=viewCart")){
					try {
						ArrayList<ItemBean> cart = Shopping.getCart(userId);
						session.setAttribute("cart", cart);
						ArrayList<LoginUserBean> producers  = new ArrayList<LoginUserBean>();
						for(int i = 0; i < cart.size(); i++){
							LoginUserBean producer = Shopping.getProducer(cart.get(i).getItemProducerId());
							producers.add(producer);
						}
						session.setAttribute("producers", producers);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					ServletContext context = getServletContext();
					RequestDispatcher rd = context.getRequestDispatcher("/cart.jsp");
					rd.forward(request, response);
				}
			}
		}else if(mode != null){
			session.setAttribute("mode", mode);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/needLogin.jsp");
			rd.forward(request, response);
		}
	}
}