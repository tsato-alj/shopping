package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.HistoryBean;
import bean.ItemBean;

public class ShoppingDao {
	private Connection connection;

	public ShoppingDao() throws ClassNotFoundException, SQLException{
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

	public ArrayList<ItemBean> selectItem() throws SQLException {

		ArrayList<ItemBean> beans = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "select b.item_id, b.item_name ,b.price,a.quantity from stock a, item b where a.item_id = b.item_id";
			pstatement = connection.prepareStatement(sql);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			beans = new ArrayList<ItemBean>();
			while(rs.next()){
				ItemBean bean = new ItemBean();
				bean.setItemId(rs.getString("item_id"));
				bean.setItemName(rs.getString("item_name"));
				bean.setItemPrice(rs.getInt("price"));
				bean.setItemQuantity(rs.getInt("quantity"));
				beans.add(bean);
			}
			// ResultSetオブジェクトの解放
			rs.close();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}

		return beans;
	}

	public ItemBean selectItem(String itemId) throws SQLException {

		ItemBean bean = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "select b.item_id, b.item_name, b.price ,a.quantity from stock a, item b where a.item_id = b.item_id and a.item_id = ?";
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, itemId);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			if(rs.next()){
				bean = new ItemBean();
				bean.setItemId(rs.getString("item_id"));
				bean.setItemName(rs.getString("item_name"));
				bean.setItemPrice(rs.getInt("price"));
				bean.setItemQuantity(rs.getInt("quantity"));
			}
			// ResultSetオブジェクトの解放
			rs.close();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}

		return bean;
	}

	public ArrayList<HistoryBean> getHistory(String userId) throws SQLException {

		ArrayList<HistoryBean> beans = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "select a.item_id, b.item_name, a.quantity from history a , item b where a.id = ? and a.item_id = b.item_id";
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, userId);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			beans = new ArrayList<HistoryBean>();
			while(rs.next()){
				HistoryBean bean = new HistoryBean();
				bean.setItemId(rs.getString("item_id"));
				bean.setItemName(rs.getString("item_name"));
				bean.setItemByQuantity(rs.getInt("quantity"));
				beans.add(bean);
			}
			// ResultSetオブジェクトの解放
			rs.close();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}

		return beans;

	}

	public void updateItem(String itemId, int quantity) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "update stock set quantity = quantity - ? where item_id = ?";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setInt(1, quantity);
			pstatement.setString(2, itemId);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}

	public void updateHistory(String userId, String itemId, int quantity) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "insert into history (id, item_id, quantity) values (?, ?, ?)";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, userId);
			pstatement.setString(2, itemId);
			pstatement.setInt(3, quantity);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}
}