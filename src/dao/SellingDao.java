package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.Part;

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

	public void recordItem(String itemId, String itemName, int price, String producerId, String itemDescription, Part image, String category) throws SQLException{
		PreparedStatement pstatement = null;
		try {
			// SQLを保持するPreparedStatementオブジェクトの生成
			String sql = "insert into item (item_id, item_name, price, producer_Id, item_description, image, category) values (?, ?, ?, ?, ?, ?, ?)";
			pstatement = connection.prepareStatement(sql);
			// INパラメータの設定
			pstatement.setString(1, itemId);
			pstatement.setString(2, itemName);
			pstatement.setInt(3, price);
			pstatement.setString(4, producerId);
			pstatement.setString(5, itemDescription);
			pstatement.setBlob();
			//SQLの発行
			pstatement.executeUpdate();
		} finally {
			// PreparedStatementオブジェクトの解放
			pstatement.close();
		}
	}
}