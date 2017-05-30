package bean;

import java.io.Serializable;
import java.time.LocalDate;

public class GoalBean implements Serializable {
	private int orderId;
	private String userId;
	private int historyId;
	private String goal;
	private LocalDate start;
	private LocalDate goalDate;
	private LocalDate endDate;

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public LocalDate getStart() {
		return start;
	}
	public void setStart(LocalDate start) {
		this.start = start;
	}
	public LocalDate getGoalDate() {
		return goalDate;
	}
	public void setGoalDate(LocalDate goalDate) {
		this.goalDate = goalDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
}