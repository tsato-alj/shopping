package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import bean.ReviewBean;

/**
 * Servlet implementation class ReviewDao
 */
@WebServlet("/ReviewDao")
public class ReviewDao extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private Connection connection;

	public ReviewDao() throws ClassNotFoundException, SQLException{

		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "root";
		String msg = "";
        try {
        	connection = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            msg = "ドライバのロードに失敗しました";
            System.out.println(msg);
        }
	}

	public void close(){
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}


	public void reviewInsert(String id, String item_id, String nickname, LocalDateTime time, String coment, int evaluation, String title) throws SQLException {
		System.out.println(title);
		PreparedStatement ps = null;

		Timestamp sqltime = Timestamp.valueOf(time);

		try{
			String sql ="insert into review (id, item_id, nickname, contribution_time, coment, evaluation, title) values (?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, item_id);
			ps.setString(3, nickname);
			ps.setTimestamp(4, sqltime);
			ps.setString(5, coment);
			ps.setInt(6, evaluation);
			ps.setString(7, title);
			ps.executeUpdate();

		}finally{
			ps.close();
		}
	}


	public ArrayList<ReviewBean> reviewSelect(String item_id) throws SQLException {


		ArrayList<ReviewBean> reviews = new ArrayList<ReviewBean>();
		ReviewBean reviewBean = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try{
			String sql ="SELECT * FROM review where item_id =?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, item_id);
			rs = ps.executeQuery();

			while(rs.next()){
				reviewBean = new ReviewBean();
				reviewBean.setItem_id(rs.getString("item_id"));
				reviewBean.setNickname(rs.getString("nickname"));
				reviewBean.setContribution_time(rs.getDate("contribution_time"));
				reviewBean.setComent(rs.getString("coment"));
				reviewBean.setEvaluation(rs.getInt("evaluation"));
				reviewBean.setTitle(rs.getString("title"));
				reviews.add(reviewBean);
			}
			rs.close();

		}finally{
			ps.close();
		}
		if(reviews.size() <= 0){
			reviews = null;
		}
		return reviews;
	}


}