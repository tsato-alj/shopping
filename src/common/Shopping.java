package common;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.HistoryBean;
import bean.ItemBean;
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
}
