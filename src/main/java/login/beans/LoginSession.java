/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */
package login.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Data
@NoArgsConstructor
public class LoginSession {

	public static int userId;
	public static String userType;
	public static String userName;
	public static boolean isLoggedIn = false;

	public static void logoutSession() {
		userId = 0;
		userType = null;
		userName = null;
		isLoggedIn = false;
		System.out.println(printSession());
		System.out.println("Session Logged Out");
		System.out.println(printSession());
	}
	
	public static String printSession() {
		return(
				"============\n" +
					"Session Info: " + 
					"\nUSER ID: " + userId + 
					"\nUSERNAME: " + userName + 
					"\nUSERTYPE: " + userType + 
					"\nLOGIN STATUS: " + isLoggedIn +
					"\n============"
				);
	}
}
