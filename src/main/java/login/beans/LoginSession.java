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

	public static int userId;
	public static String userType;
	public static String userName;
	public static boolean isLoggedIn = false;
	
}
