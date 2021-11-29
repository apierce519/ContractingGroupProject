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
	private User a = new User();
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
	 * Test method for set set new user info is incorrect match
	 */
	
	@Test
	void setUserTestGetAndSetNotEquals() {
		User newUser = new User();
		
		int id1 = 13;
		String username1 = "user124";
		String password1= "pass";
		String firstName1 = "Fail";
		String lastName1 = "Test";
		String userType1 = "Customer";
		
		newUser.setId(id1);
		newUser.setUsername(username1);
		newUser.setPassword(password1);
		newUser.setFirstName(firstName1);
		newUser.setLastName(lastName1);
		newUser.setUserType(userType1);
		
		assertNotEquals(newUser.getId(), id);
		assertNotEquals(newUser.getUsername(), username);
		assertNotEquals(newUser.getPassword(),password);
		assertNotEquals(newUser.getFirstName(), firstName);
		assertNotEquals(newUser.getLastName(), lastName);
		assertNotEquals(newUser.getUserType(), userType);
	}
	/**
	 * Test method for set id
	 */
	
	@Test
	void testGetAndSetIdEquals() {
		int userId = 4;
		
		a.setId(id);
		
		assertEquals(a.getId(), userId);
	}
	/**
	 * Test method for set id doesn't match
	 */
	@Test
	void testGetAndSetIdNotEquals() {
		int userId = 5;
		
		a.setId(id);
		
		assertNotEquals(a.getId(), userId);
	}

	/**
	 * Test method for setting user name
	 */
	@Test
	void testGetAndSetUsernameEquals() {
		String userN = "user123";
		
		a.setUsername(username);
		
		assertEquals(a.getUsername(), userN);
	}
	/**
	 * Test method for setting user name
	 */
	
	/**
	 * Test method for setting user name doesn't match
	 */
	@Test
	void testGetAndSetUsernameNotEquals() {
		String userN = "fail";
		
		a.setUsername(username);
		
		assertNotEquals(a.getUsername(), userN);
	}

	/**
	 * Test method for setting password
	 */
	@Test
	void testGetAndSetPasswordEquals() {
		String userP = "password";
		
		a.setPassword(password);
		
		assertEquals(a.getPassword(), userP);
	}
	/**
	 * Test method for setting password doesn't match
	 */
	@Test
	void testGetAndSetPasswordNotEquals() {
		String userP = "denied";
		
		a.setPassword(password);
		
		assertNotEquals(a.getPassword(), userP);
	}

	/**
	 * Test method for setting first name
	 */
	@Test
	void testGetAndSetFirstNameEquals() {
		String userF = "Test";
		
		a.setFirstName(firstName);
		
		assertEquals(a.getFirstName(),userF);
	}
	
	/**
	 * Test method for setting first name doesn't match
	 */
	@Test
	void testGetAndSetFirstNameNotEquals() {
		String userF = "First";
		
		a.setFirstName(firstName);
		
		assertNotEquals(a.getFirstName(),userF);
	}

	/**
	 * Test method for setting last name
	 */
	@Test
	void testGetAndSetLastNameEquals() {
		String userL = "Case";
		
		a.setLastName(lastName);
		
		assertEquals(a.getLastName(), userL);
	}
	/**
	 * Test method for setting last name not equals
	 */
	@Test
	void testGetAndSetLastNameNotEquals() {
		String userL = "Nope";
		
		a.setLastName(lastName);
		
		assertNotEquals(a.getLastName(), userL);
	}
	/**
	 * Test method for setting user type
	 */
	@Test
	void testGetAndSetUserTypeEquals() {
		String type = "Contractor";
		
		a.setUserType(userType);
		
		assertEquals(a.getUserType(), type);
	}
	/**
	 * Test method for setting user type not equals
	 */
	@Test
	void testGetAndSetUserTypeNotEquals() {
		String type = "Customer";
		
		a.setUserType(userType);
		
		assertNotEquals(a.getUserType(), type);
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
