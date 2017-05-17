package common;

import java.sql.SQLException;

import bean.LoginUserBean;
import dao.LoginDao;

public class Login {
	public static LoginUserBean loginCheck(String id, String pass) throws ClassNotFoundException, SQLException{
		return new LoginDao().selectUser(id, pass);
	}
}
