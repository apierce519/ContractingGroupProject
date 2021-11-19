/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */
package login.beans;

import java.sql.PreparedStatement;

/**
 * @author Andrew Pierce - ajpierce1
 */
public class Operations {

	public static boolean isLogin(String username, String password, String userType) {
		String mySqlQuery = "SELECT id, user_type FROM user WHERE userName = '" + username + "' AND password = '" + password + "' AND user_type = '" + userType + "'" ;
		return false;
		
		PreparedStatement ps = myCon.prepareStatment(mySqlQuery);
	}
	
}
