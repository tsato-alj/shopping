package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.Selling;

/**
 * Servlet implementation class AddDescriptionServlet
 */
@WebServlet("/additemimage")
@MultipartConfig(location="C:/pleiades/workspace/shopping/WebContent/item-image")
public class AddItemImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemImageServlet() {
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
		Part image = request.getPart("image");
		String fileName = itemId + image.getSubmittedFileName();
		image.write(fileName);
		String imageUrl = "C:/pleiades/workspace/shopping/WebContent/item-image/" + fileName;
		try {
			Selling.addItemImage(imageUrl, itemId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		request.setAttribute("itemId", itemId);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/addDescription.jsp");
		rd.forward(request, response);
	}

}