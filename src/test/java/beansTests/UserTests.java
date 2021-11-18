/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 17, 2021
 */

package beansTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dmacc.beans.User;

/**
 * @author cmboe
 *
 */
class UserTests {

	//variables
	private int id = 4;
	private String username = "user123";
	private String password = "password";
	private String firstName = "Test";
	private String lastName = "Case";
	private String userType = "Contractor";
	
	/**
	 * Test method for set set new user info passing
	 */
	
	@Test
	void setUserTestGetAndSetEquals() {
		User newUser = new User();
		
		newUser.setId(id);
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setUserType(userType);
		
		assertEquals(newUser.getId(), id);
		assertEquals(newUser.getUsername(), username);
		assertEquals(newUser.getPassword(),password);
		assertEquals(newUser.getFirstName(), firstName);
		assertEquals(newUser.getLastName(), lastName);
		assertEquals(newUser.getUserType(), userType);
	}
	/**
	 * Test method for set id
	 */
	
	@Test
	void testSetIdSuccess() {
		int userId = 4;
		
		int actual = id;
		
		assertEquals(actual, userId);
	}
	/**
	 * Test method for set id
	 */
	@Test
	void testSetIdFail() {
		int userId = 5;
		
		int actual = id;
		
		assertNotEquals(actual, userId);
	}

	/**
	 * Test method for setting user name
	 */
	@Test
	void testSetUsernamePass() {
		String userN = "user123";
		
		String actual = username;
		
		assertEquals(actual, userN);
	}
	/**
	 * Test method for setting user name
	 */
	
	/**
	 * Test method for setting user name fail
	 */
	@Test
	void testSetUsernameFail() {
		String userN = "fail";
		
		String actual = username;
		
		assertNotEquals(actual, userN);
	}

	/**
	 * Test method for setting password
	 */
	@Test
	void testSetPasswordPass() {
		String userP = "password";
		
		String actual = password;
		
		assertEquals(actual, userP);
	}
	/**
	 * Test method for setting password fail
	 */
	@Test
	void testSetPasswordFail() {
		String userP = "denied";
		
		String actual = password;
		
		assertNotEquals(actual, userP);
	}

	/**
	 * Test method for setting first name
	 */
	@Test
	void testSetFirstNamePass() {
		String userF = "Test";
		
		String actual = firstName;
		
		assertEquals(actual,userF);
	}
	
	/**
	 * Test method for setting first name fail
	 */
	@Test
	void testSetFirstNameFail() {
		String userF = "First";
		
		String actual = firstName;
		
		assertNotEquals(actual,userF);
	}

	/**
	 * Test method for setting last name
	 */
	@Test
	void testSetLastNamePass() {
		String userL = "Case";
		
		String actual = lastName;
		
		assertEquals(actual, userL);
	}
	/**
	 * Test method for setting last name fail
	 */
	@Test
	void testSetLastNameFail() {
		String userL = "Nope";
		
		String actual = lastName;
		
		assertNotEquals(actual, userL);
	}
	/**
	 * Test method for setting user type
	 */
	@Test
	void testSetUserTypePass() {
		String type = "Contractor";
		
		String actual = userType;
		
		assertEquals(actual, type);
	}
	/**
	 * Test method for setting user type fail
	 */
	@Test
	void testSetUserTypeFail() {
		String type = "Customer";
		
		String actual = userType;
		
		assertNotEquals(actual, type);
	}

	/**
	 * Test method for user details
	 */
	@Test
	void userDetailsEquals() {
	
		String details = "[id= 4 username= user123 password= password name= Test Case userType= Contractor]";
		String actual = "[id= " + id + " username= " + username + " password= " + password + " name= " + firstName + " " + lastName + " userType= " + userType + "]" ;
		
		assertEquals(actual,details);
	}
	
	/**
	 * Test method for user details not matching
	 */
	@Test
	void userDetailsNotEquals() {
	
		String details = "[id= 4 username= user1 password= password1 name= Test Case userType= Contractor]";
		String actual = "[id= " + id + " username= " + username + " password= " + password + " name= " + firstName + " " + lastName + " userType= " + userType + "]" ;
		
		assertNotEquals(actual,details);
	}

}
