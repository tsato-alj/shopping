package shopservlet;

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

import BeanDao.ReviewDao;

/**
 * Servlet implementation class reviewServlet
 */
@WebServlet("/reviewServlet")
public class reviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		HttpSession session = request.getSession(false);

		String nickname = request.getParameter("nickname");
		String evaluation = request.getParameter("evaluation");
		String title = request.getParameter("title");
		String contenttext = request.getParameter("contenttext");

		//sessionでuseridの取得
		String[] buyitem = (String[])session.getAttribute("buyitem");
			String id = buyitem[4];
			String item_id = buyitem[0];

		//型変換
			int eva = Integer.parseInt(evaluation);

		//時間の取得 && Date型に変換
			LocalDateTime time = LocalDateTime.now();
			System.out.println(time);



		//DBの作成
		//beanの作成
		//Daoの作成
		//メソッド呼び出し、表示
		ReviewDao review;
		try {
			review = new ReviewDao();
			review.reviewInsert(id, item_id, nickname, time, contenttext, eva, title);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/review.jsp");
			rd.forward(request, response);


		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}





	}

}
