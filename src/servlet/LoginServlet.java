package servlet;

import java.io.IOException;
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
import bean.LoginUserBean;
import common.Login;
import common.Shopping;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		HttpSession session = null;

		request.setCharacterEncoding("UTF-8");
		String choice = request.getParameter("choice");
		try{
			if(choice != null){
				if(choice.equals("login")){
					//ログインボタンが押された場合
					String id = request.getParameter("id");
					String pass = request.getParameter("pass");
					//ログインチェック実施
					LoginUserBean userBean = Login.loginCheck(id, pass);
					//ログインチェック判定
					if(userBean != null){
						//OKの場合
						session = request.getSession(true);
						String userName = userBean.getName();
						session.setAttribute("userName", userName);
						session.setAttribute("userId", id);
						ServletContext context = getServletContext();
						RequestDispatcher rd = context.getRequestDispatcher("/shopping");
						rd.forward(request, response);
					} else {
						//NGの場合
						ServletContext context = getServletContext();
						RequestDispatcher rd = context.getRequestDispatcher("/loginNG.jsp");
						rd.forward(request, response);
					}
				}else if(choice.equals("logout")){
					session = request.getSession();
					session.invalidate();
					ServletContext context = getServletContext();
					RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);
				}else if(choice.equals("history")){
					session = request.getSession();
					String userId = (String)session.getAttribute("userId");
					System.out.println(userId);
					ArrayList<HistoryBean> historyList = Shopping.getHistory(userId);
					request.setAttribute("historyList", historyList);
					ServletContext context = getServletContext();
					RequestDispatcher rd = context.getRequestDispatcher("/history.jsp");
					rd.forward(request, response);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}