/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */
package login.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Data
@NoArgsConstructor
public class LoginSession {

	private int userId;
	private String userType;
	private String userName;
	private boolean isLoggedIn = false;

	public void logoutSession() {
		this.userId = 0;
		this.userType = null;
		this.userName = null;
		this.isLoggedIn = false;
		System.out.println("Session Logged Out");
		System.out.println(printSession());
	}
	
	public String printSession() {
		return(
				"============\n" +
					"Session Info: " + 
					"\nUSER ID: " + this.userId + 
					"\nUSERNAME: " + this.userName + 
					"\nUSERTYPE: " + this.userType + 
					"\nLOGIN STATUS: " + this.isLoggedIn +
					"\n============"
				);
	}
}
