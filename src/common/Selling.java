package common;

import java.sql.SQLException;

import javax.servlet.http.Part;

import dao.SellingDao;

public class Selling {
	public static void recordItem(String itemId, String itemName, int price, String producerId, String itemDescription, Part image, String category) throws ClassNotFoundException, SQLException{
		SellingDao sellingdao = new SellingDao();
		sellingdao.recordItem(itemId, itemName, price, producerId, itemDescription, image, category);
		sellingdao.close();
	}
}
