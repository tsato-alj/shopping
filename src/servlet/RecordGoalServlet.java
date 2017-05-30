package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
 * Servlet implementation class RecordGoalServlet
 */
@WebServlet("/recordgoal")
public class RecordGoalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordGoalServlet() {
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
		HttpSession session = request.getSession(true);
		String userId = (String)session.getAttribute("userId");
		String goal = request.getParameter("goal");
		LocalDate start = LocalDate.parse(request.getParameter("startDate"));
		LocalDate goalDate = LocalDate.parse(request.getParameter("goalDate"));
		int historyId = Integer.parseInt(request.getParameter("historyId"));
		try {
			Shopping.recordGoal(userId, historyId, goal, start, goalDate);
			String messageAboutGoal = null;
			ArrayList<GoalBean> goals = null;
			if(Shopping.getGoal(userId) != null){
				goals = Shopping.getGoal(userId);
			}
			if(goals != null){
				GoalBean newestGoal = null;
	            for(GoalBean oneOfGoal: goals){
	                newestGoal = oneOfGoal;
	            }
	            LocalDate EndDate = null;
	            if(newestGoal != null){
	                EndDate = newestGoal.getEndDate();
	            }
	            if(EndDate != null){
	                messageAboutGoal = "現在新しい目標は設定されていません";
	            }else{
	                LocalDate goalD = newestGoal.getGoalDate();
	                LocalDate today = LocalDate.now();
	                Long dayDiff = ChronoUnit.DAYS.between(today, goalD);
	                if(dayDiff > 0){
	                    messageAboutGoal = "目標達成予定日まで後<strong>" + dayDiff + "</storong>日";
	                }else if(dayDiff == 0){
	                    messageAboutGoal = "目標達成予定日は<strong>本日</strong>";
	                }else if(dayDiff < 0){
	                	LocalDate endDate = LocalDate.now();
	                	Shopping.achieveGoal(userId, endDate);
	                	messageAboutGoal = "目標達成予定日を越えました";
	                }
	            }
			}else{
				messageAboutGoal = "目標があるお買い物をはじめましょう";
			}
			session.setAttribute("messageAboutGoal", messageAboutGoal);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/ForVegetalian.jsp");
		rd.forward(request, response);
	}

}