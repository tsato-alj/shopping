package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import bean.GoalBean;
import bean.HistoryBean;
import bean.ItemBean;
import bean.LoginUserBean;

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
			String sql = "select b.item_id, b.item_name, b.price, a.quantity, b.producer_id, b.item_description, b.image, b.category from stock a, item b where a.item_id = b.item_id";
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
				bean.setItemProducerId(rs.getString("producer_id"));
				bean.setDescription(rs.getString("item_description"));
				bean.setImage(rs.getString("image"));
				bean.setCategory(rs.getString("category"));
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
			String sql = "select b.item_id, b.item_name, b.price, a.quantity, b.producer_id, b.item_description, b.image, b.category from stock a, item b where a.item_id = b.item_id and a.item_id = ?";
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
				bean.setItemProducerId(rs.getString("producer_id"));
				bean.setDescription(rs.getString("item_description"));
				bean.setImage(rs.getString("image"));
				bean.setCategory(rs.getString("category"));
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
			String sql = "select a.order_id, a.item_id, b.item_name, a.quantity from history a , item b where a.id = ? and a.item_id = b.item_id";
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, userId);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			beans = new ArrayList<HistoryBean>();
			while(rs.next()){
				HistoryBean bean = new HistoryBean();
				bean.setOrderId(rs.getInt("order_id"));
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

	public ArrayList<ItemBean> getCart(String userId) throws SQLException{
		ArrayList<ItemBean> cart = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "select a.order_id, a.item_id, b.item_name, b.price, a.quantity, b.producer_id, b.image from cart a , item b where a.user_id = ? and a.item_id = b.item_id";
			pstatement = connection.prepareStatement(sql);
			pstatement.setString(1, userId);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			cart = new ArrayList<ItemBean>();
			while(rs.next()){
				ItemBean item = new ItemBean();
				item.setOrderId(rs.getInt("order_id"));
				item.setItemId(rs.getString("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemPrice(rs.getInt("price"));
				item.setItemQuantity(rs.getInt("quantity"));
				item.setItemProducerId(rs.getString("producer_id"));
				item.setImage(rs.getString("image"));
				cart.add(item);
			}
			// ResultSetオブジェクトの解放
			rs.close();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}

		return cart;
	}

	public LoginUserBean getProducer(String producerId) throws SQLException{
		LoginUserBean producer = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "SELECT * FROM user WHERE id= ?";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, producerId);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			if(rs.next()){
				producer = new LoginUserBean();
				producer.setId(rs.getString("id"));
				producer.setName(rs.getString("name"));
				producer.setAddress(rs.getString("address"));
				producer.setEmail(rs.getString("email"));
			}
			// ResultSetオブジェクトの解放
			rs.close();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}

		return producer;
	}

	public void addToCart(String userId, String itemId, int quantity) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "insert into cart (user_id, item_id, quantity) values (?, ?, ?)";
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

	public void deleteCart(String userId) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "delete from cart where user_id = ?";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, userId);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}

	public void recordGoal(String userId, int historyId, String goal, LocalDate startDate, LocalDate goalDate) throws SQLException{
		PreparedStatement pstatement = null;
		Date SQLStartDate = Date.valueOf(startDate);
		Date SQLGoalDate = Date.valueOf(goalDate);
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "insert into goal (user_id, history_id, goal, start, goalDate) values (?, ?, ?, ?, ?)";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, userId);
			pstatement.setInt(2, historyId);
			pstatement.setString(3, goal);
			pstatement.setDate(4, SQLStartDate);
			pstatement.setDate(5, SQLGoalDate);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}

	public ArrayList<GoalBean> getGoal(String userId) throws SQLException{
		ArrayList<GoalBean> goals = new ArrayList<GoalBean>();
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "SELECT * FROM goal WHERE user_id= ?";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, userId);
			//SQLの発行
			//抽出結果が格納されたResultSetオブジェクトを取得
			rs = pstatement.executeQuery();
			// 列名を指定してResultSetオブジェクトから値を取得
			while(rs.next()){
				GoalBean goal = new GoalBean();
				goal.setOrderId(rs.getInt("order_id"));
				goal.setUserId(rs.getString("user_id"));
				goal.setHistoryId(rs.getInt("history_id"));
				goal.setGoal(rs.getString("goal"));
				goal.setStart(rs.getDate("start").toLocalDate());
				goal.setGoalDate(rs.getDate("goalDate").toLocalDate());
				if(rs.getDate("EndDate") != null){
					goal.setEndDate(rs.getDate("EndDate").toLocalDate());
				}
				goals.add(goal);
			}
			if(goals.size() <= 0){
				goals = null;
			}
			// ResultSetオブジェクトの解放
			rs.close();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}

		return goals;
	}

	public void achieveGoal(int orderId,LocalDate endDate) throws SQLException{
		PreparedStatement pstatement = null;
		Date SQLEndDate = Date.valueOf(endDate);
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "update goal set EndDate = ? where order_id = ?";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setDate(1, SQLEndDate);
			pstatement.setInt(2, orderId);
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}
}