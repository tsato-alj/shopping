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

import bean.ItemBean;
import common.Shopping;

/**
 * Servlet implementation class itemListServlet
 */
@WebServlet("/itemlist")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemListServlet() {
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
		try{
			try {
				ArrayList<ItemBean> itemBeanList = Shopping.getItem();

				String category = null;
				if(request.getParameter("category") != null){
						category = request.getParameter("category");
				}
				if(category != null && !category.equals("All")){
					ArrayList<ItemBean> cateList = new ArrayList<ItemBean>();
					for(ItemBean cateItem : itemBeanList){
						if(category.equals(cateItem.getCategory())){
							cateList.add(cateItem);
						}
					}
					itemBeanList = cateList;
				}
				request.setAttribute("itemBeanList", itemBeanList);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/itemList.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}catch(ServletException e){
			System.out.println("ServletException");
			e.getRootCause().printStackTrace();
		}catch(IOException e){
			System.out.println("IOEException");
			e.printStackTrace();
		}
	}

}