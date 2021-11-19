/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */
package login.beans;

/**
 * @author Andrew Pierce - ajpierce1
 */
public class Operations {

	public static boolean isLogin(String username, String password, String userType) {
		String mySqlQuery = "SELECT id, userType FROM user WHERE userName = '" + username + "' and password = '" + password + "' AND userType = '" + "'" ;
		return false;
	}
	
}
