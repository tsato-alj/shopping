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

import bean.GoalBean;
import common.Shopping;

/**
 * Servlet implementation class ViewGoalServlet
 */
@WebServlet("/viewgoal")
public class ViewGoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewGoalServlet() {
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
			session.removeAttribute("mode");
			try {
				ArrayList<GoalBean> goals = Shopping.getGoal(userId);
				Integer goalsMaxIndex = 0;
				if(goals != null){
						goalsMaxIndex = goals.size() - 1;
				}
				request.setAttribute("goals", goals);
				request.setAttribute("goalsMaxIndex", goalsMaxIndex);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/viewGoal.jsp");
			rd.forward(request, response);
		}else if(mode != null){
			session.setAttribute("mode", mode);
			ServletContext context = getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/needLogin.jsp");
			rd.forward(request, response);
		}
	}

}