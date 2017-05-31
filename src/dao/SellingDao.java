package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ItemBean;

public class SellingDao {
	private Connection connection;

	public SellingDao() throws ClassNotFoundException, SQLException{
		// java_web_systemデータベースとの接続
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);
	}

	public void close(){
		try{
			// java_web_systemデータベースとの切断
			if(connection != null){
				connection.close();
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void recordItem(String itemId, String itemName, int price, String producerId, String category) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "insert into item (item_id, item_name, price, producer_Id,category) values (?, ?, ?, ?, ?)";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, itemId);
			pstatement.setString(2, itemName);
			pstatement.setInt(3, price);
			pstatement.setString(4, producerId);
			pstatement.setString(5, category);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}

	public void recordItemIntoStock(String itemId) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "insert into stock (item_id, quantity) values (?, 0)";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, itemId);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}

	public void addItemImage(String itemUrl, String itemId) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "update item set image = ? where item_id = ?";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, itemUrl);
			pstatement.setString(2, itemId);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}

	public void addDescription(String description, String itemId) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "update item set item_description = ? where item_id = ?";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, description);
			pstatement.setString(2, itemId);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}

	public ArrayList<ItemBean> getProducersItem(String producerId) throws SQLException{
		ArrayList<ItemBean> producersItem = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "select b.item_id, b.item_name, b.price, a.quantity, b.producer_id, b.image from stock a , item b where b.producer_id = ? and a.item_id = b.item_id";
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, producerId);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			producersItem = new ArrayList<ItemBean>();
			while(rs.next()){
				ItemBean item = new ItemBean();
				item.setItemId(rs.getString("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemPrice(rs.getInt("price"));
				item.setItemQuantity(rs.getInt("quantity"));
				item.setItemProducerId(rs.getString("producer_id"));
				item.setImage(rs.getString("image"));
				producersItem.add(item);
			}
			// ResultSetオブジェクトの解放
			rs.close();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
		if(producersItem.size() <= 0){
			producersItem = null;
		}
		return producersItem;
	}

	public void changeStock(String itemId, int quantity) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "update stock set quantity = ? where item_id = ?";
			pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1, quantity);
			pstatement.setString(2, itemId);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}
}