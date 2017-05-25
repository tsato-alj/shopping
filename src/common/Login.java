package common;

import java.sql.SQLException;

import bean.LoginUserBean;
import dao.LoginDao;

public class Login {
	public static LoginUserBean loginCheck(String id, String pass) throws ClassNotFoundException, SQLException{
		LoginDao dao = new LoginDao();
		LoginUserBean user = dao.selectUser(id, pass);
		dao.close();
		return user;
	}

	public static void createAnAccount(String userId, String pass, String name, String email) throws ClassNotFoundException, SQLException{
		LoginDao dao = new LoginDao();
		dao.createAnAccount(userId, pass, name, email);
		dao.close();
		return;
	}
}
