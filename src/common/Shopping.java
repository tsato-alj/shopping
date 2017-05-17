package common;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.HistoryBean;
import bean.ItemBean;
import dao.ShoppingDao;

public class Shopping {

	public static ArrayList<ItemBean> getItem() throws ClassNotFoundException, SQLException{
		return new ShoppingDao().selectItem();
	}

	public static ItemBean getItem(String itemId) throws ClassNotFoundException, SQLException{
		return new ShoppingDao().selectItem(itemId);
	}

	public static ArrayList<HistoryBean> getHistory(String userId) throws ClassNotFoundException, SQLException{
		return new ShoppingDao().getHistory(userId);
	}
}
