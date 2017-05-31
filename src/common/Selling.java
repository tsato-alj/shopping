package common;

import java.sql.SQLException;
import java.util.ArrayList;

import bean.ItemBean;
import dao.SellingDao;

public class Selling {
	public static void recordItem(String itemId, String itemName, int price, String producerId,String category) throws ClassNotFoundException, SQLException{
		SellingDao sellingdao = new SellingDao();
		sellingdao.recordItem(itemId, itemName, price, producerId, category);
		sellingdao.recordItemIntoStock(itemId);
		sellingdao.close();
	}
	public static void addItemImage(String imageUrl, String itemId) throws ClassNotFoundException, SQLException{
		SellingDao sellingdao = new SellingDao();
		sellingdao.addItemImage(imageUrl, itemId);
		sellingdao.close();
	}
	public static void addDescription(String description, String itemId) throws SQLException, ClassNotFoundException{
		SellingDao sellingdao = new SellingDao();
		sellingdao.addDescription(description, itemId);
		sellingdao.close();
	}

	public static ArrayList<ItemBean> getProducersItem(String producerId) throws ClassNotFoundException, SQLException{
		SellingDao sellingdao = new SellingDao();
		ArrayList<ItemBean> producersItem = sellingdao.getProducersItem(producerId);
		sellingdao.close();
		return producersItem;
	}
	public static void changeStock(String itemId, int quantity) throws ClassNotFoundException, SQLException{
		SellingDao sellingdao = new SellingDao();
		sellingdao.changeStock(itemId, quantity);
		sellingdao.close();
	}
}
