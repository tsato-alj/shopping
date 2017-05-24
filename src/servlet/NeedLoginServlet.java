package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginUserBean;
import common.Login;

/**
 * Servlet implementation class NeedLoginServlet
 */
@WebServlet("/needlogin")
public class NeedLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NeedLoginServlet() {
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
		//リクエスト処理
				HttpSession session = request.getSession(true);
				request.setCharacterEncoding("UTF-8");
				String mode = (String)session.getAttribute("mode");
				try{
					if(mode != null){
						//ログインボタンが押された場合
						String id = request.getParameter("id");
						String pass = request.getParameter("pass");
						//ログインチェック実施
						LoginUserBean userBean = Login.loginCheck(id, pass);
						//ログインチェック判定
						if(userBean != null){
							//OKの場合
							String userName = userBean.getName();
							session.setAttribute("userName", userName);
							session.setAttribute("userId", id);
							ServletContext context = getServletContext();;
							RequestDispatcher rd = context.getRequestDispatcher(mode);
							rd.forward(request, response);
						} else {
							//NGの場合
							ServletContext context = getServletContext();
							RequestDispatcher rd = context.getRequestDispatcher("/loginNG.jsp");
							rd.forward(request, response);
						}
					}
				} catch(Exception e){
					e.printStackTrace();
				}
	}

}