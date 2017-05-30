package common;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import bean.GoalBean;
import bean.HistoryBean;
import bean.ItemBean;
import bean.LoginUserBean;
import dao.ShoppingDao;

public class Shopping {

	public static ArrayList<ItemBean> getItem() throws ClassNotFoundException, SQLException{
		ShoppingDao shopping = new ShoppingDao();
		ArrayList<ItemBean> itemList = shopping.selectItem();
		shopping.close();
		return itemList;
	}

	public static ItemBean getItem(String itemId) throws ClassNotFoundException, SQLException{
		ShoppingDao shopping = new ShoppingDao();
		ItemBean item = shopping.selectItem(itemId);
		shopping.close();
		return item;
	}

	public static ArrayList<HistoryBean> getHistory(String userId) throws ClassNotFoundException, SQLException{
		ShoppingDao shopping = new ShoppingDao();
		ArrayList<HistoryBean> historyList = shopping.getHistory(userId);
		shopping.close();
		return historyList;
	}

	public static ArrayList<ItemBean> getCart(String userId) throws ClassNotFoundException, SQLException{
		ShoppingDao shopping = new ShoppingDao();
		ArrayList<ItemBean> cart = shopping.getCart(userId);
		shopping.close();
		return cart;
	}

	public static LoginUserBean getProducer(String producerId) throws ClassNotFoundException, SQLException{
		ShoppingDao dao = new ShoppingDao();
		LoginUserBean producer = dao.getProducer(producerId);
		dao.close();
		return producer;
	}

	public static void addToCart(String userId, String itemId, int quantity) throws ClassNotFoundException, SQLException{
		ShoppingDao dao = new ShoppingDao();
		dao.addToCart(userId, itemId, quantity);
		dao.close();
	}

	public static void recordGoal(String userId, int historyId, String goal, LocalDate start, LocalDate goalDate) throws ClassNotFoundException, SQLException{
		ShoppingDao dao = new ShoppingDao();
		dao.recordGoal(userId, historyId, goal, start, goalDate);
		dao.close();
	}

	public static ArrayList<GoalBean> getGoal(String userId) throws ClassNotFoundException, SQLException{
		ShoppingDao dao = new ShoppingDao();
		ArrayList<GoalBean> goal = dao.getGoal(userId);
		dao.close();
		return goal;
	}

	public static void achieveGoal(String userId, int historyId, LocalDate endDate) throws ClassNotFoundException, SQLException{
		ShoppingDao dao = new ShoppingDao();
		dao.achieveGoal(userId, historyId, endDate);
		dao.close();
	}
}
