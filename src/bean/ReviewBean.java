package bean;

import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class ReviewBean
 */
@WebServlet("/ReviewBean")
public class ReviewBean extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String id;
	private String item_id;
	private String nickname;
	private Date contribution_time;
	private String coment;
	private int evaluation;
	private String title;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getContribution_time() {
		return contribution_time;
	}
	public void setContribution_time(Date contribution_time) {
		this.contribution_time = contribution_time;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
