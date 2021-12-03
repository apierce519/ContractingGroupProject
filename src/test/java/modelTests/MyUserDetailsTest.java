/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Dec 1, 2021
 */

package modelTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import dmacc.model.MyUserDetails;
import dmacc.model.User;

/**
 * @author cmboe
 *
 */
class MyUserDetailsTest {
	//variables
	private MyUserDetails a = new MyUserDetails();
	private User b = new User();
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
		
}
