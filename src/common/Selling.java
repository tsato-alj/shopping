package common;

import java.sql.SQLException;

import dao.SellingDao;

public class Selling {
	public static void recordItem(String itemId, String itemName, int price, String producerId,String category) throws ClassNotFoundException, SQLException{
		SellingDao sellingdao = new SellingDao();
		sellingdao.recordItem(itemId, itemName, price, producerId, category);
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
}
