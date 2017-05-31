package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ReviewBean;
import dao.ReviewDao;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);

		String nickname = request.getParameter("nickname");
		String evaluation = request.getParameter("evaluation");
		String title = request.getParameter("title");
		String contenttext = request.getParameter("contenttext");
		String item_id = request.getParameter("itemId");
		request.setAttribute("itemId", item_id);

		//sessionでuseridの取得
		String id = (String)session.getAttribute("userId");


		//型変換
			int eva = Integer.parseInt(evaluation);

		//時間の取得 && Date型に変換
			LocalDateTime time = LocalDateTime.now();



			//DBの作成
			//beanの作成
			//Daoの作成
			//メソッド呼び出し、表示
			ReviewDao review;
			ReviewBean reviewbean = null;
			try {
				review = new ReviewDao();
				review.reviewInsert(id, item_id, nickname, time, contenttext, eva, title);

				//review表示

				//addtocartへ表示するレビューの仕分けはaddtocartで
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/iteminfo");
				rd.forward(request, response);


			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}



	}

}
