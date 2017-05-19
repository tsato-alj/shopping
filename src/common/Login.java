package common;

import java.sql.SQLException;

import bean.LoginUserBean;
import dao.LoginDao;

public class Login {
	public static LoginUserBean loginCheck(String id, String pass) throws ClassNotFoundException, SQLException{
		LoginDao login = new LoginDao();
		LoginUserBean user = login.selectUser(id, pass);
		return user;
	}
}
