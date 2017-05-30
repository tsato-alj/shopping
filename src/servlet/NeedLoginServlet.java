package servlet;

import java.io.IOException;
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
import bean.LoginUserBean;
import common.Login;
import common.Shopping;

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
							String messageAboutGoal = null;
							ArrayList<GoalBean> goals = null;
							if(Shopping.getGoal(id) != null){
								goals = Shopping.getGoal(id);
							}
							if(goals != null){
								GoalBean newestGoal = null;
					            for(GoalBean goal: goals){
					                newestGoal = goal;
					            }
					            LocalDate EndDate = null;
					            if(newestGoal != null){
					                EndDate = newestGoal.getEndDate();
					            }
					            if(EndDate != null){
					                messageAboutGoal = "現在新しい目標は設定されていません";
					            }else{
					                LocalDate goalDate = newestGoal.getGoalDate();
					                LocalDate today = LocalDate.now();
					                Long dayDiff = ChronoUnit.DAYS.between(today, goalDate);
					                if(dayDiff > 0){
					                    messageAboutGoal = "目標達成予定日まで後<strong>" + dayDiff + "</storong>日";
					                }else if(dayDiff == 0){
					                    messageAboutGoal = "目標達成予定日は<strong>本日</strong>";
					                }else if(dayDiff < 0){
					                	LocalDate endDate = LocalDate.now();
					                	Shopping.achieveGoal(id, endDate);
					                	messageAboutGoal = "目標達成予定日を越えました";
					                }
					            }
							}else{
								messageAboutGoal = "目標があるお買い物をはじめましょう";
							}
							session.setAttribute("messageAboutGoal", messageAboutGoal);
							ServletContext context = getServletContext();
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