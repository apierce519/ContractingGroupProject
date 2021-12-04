/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Dec 3, 2021
 */

package modelTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dmacc.model.User;

/**
 * @author cmboe
 *
 */
class UserTest {
	//variables
	private static User a = new User();
	private static int id =1;
	private static String username="Test";
    private static String password="Case";
	private static String lastName="Unit";
	private static String firstName="J";
	private static boolean active;
	private static String roles="Worker";
	
	/**
	 * test getters and setters
	 */
	@Test
	public void testGetAndSetUser() {
		a.setId(1);
		a.setUsername("Test");
		a.setPassword("Case");
		a.setLastName("Unit");
		a.setFirstName("J");
		active = false;
		a.setRoles("Worker");
		
		assertEquals(a.getId(), id);
		assertEquals(a.getUsername(), username);
		assertEquals(a.getPassword(), password);
		assertEquals(a.getLastName(), lastName);
		assertEquals(a.getFirstName(), firstName);
		assertFalse(active);
		assertEquals(a.getRoles(), roles);
	}
	
	@Test
	public void testGetAndSetUserNotEqual() {
		a.setId(3);
		a.setUsername("Case");
		a.setPassword("Test");
		a.setLastName("J");
		a.setFirstName("Unit");
		active = true;
		a.setRoles("None");

		assertNotEquals(a.getId(), id);
		assertNotEquals(a.getUsername(), username);
		assertNotEquals(a.getPassword(), password);
		assertNotEquals(a.getLastName(), lastName);
		assertNotEquals(a.getFirstName(), firstName);
		assertTrue(active);
		assertNotEquals(a.getRoles(), roles);
	}
	
	@Test
	public void testGetAndSetId() {
		int expected = 1;
		a.setId(id);
		
		assertEquals(a.getId(),expected);
	}
	@Test
	public void testGetAndSetIdNotEqual() {
		int expected = 7;
		a.setId(id);
		
		assertNotEquals(a.getId(),expected);
	}
	
	@Test
	public void testGetAndSetUsername() {
		String expected = "Test";
		a.setUsername(username);
		
		assertEquals(a.getUsername(),expected);
	}
	@Test
	public void testGetAndSetUsernameNotEqual() {
		String expected = "Test123";
		a.setUsername(username);
		
		assertNotEquals(a.getUsername(),expected);
	}
	
	@Test
	public void testGetAndSetPassword() {
		String expected = "Case";
		a.setPassword(password);
		
		assertEquals(a.getPassword(),expected);
	}
	@Test
	public void testGetAndSetPasswordNotEqual() {
		String expected = "Caseddd";
		a.setPassword(password);
		
		assertNotEquals(a.getPassword(),expected);
	}
	
	@Test
	public void testGetAndSetLastName() {
		String expected = "Unit";
		a.setLastName(lastName);
		
		assertEquals(a.getLastName(),expected);
	}
	@Test
	public void testGetAndSetLastNameNotEqual() {
		String expected = "Unity";
		a.setLastName(lastName);
		
		assertNotEquals(a.getLastName(),expected);
	}
	
	@Test
	public void testGetAndSetFirstName() {
		String expected = "J";
		a.setFirstName(firstName);
		
		assertEquals(a.getFirstName(),expected);
	}
	@Test
	public void testGetAndSetFirstNameNotEqual() {
		String expected = "Jay";
		a.setFirstName(firstName);
		
		assertNotEquals(a.getFirstName(),expected);
	}
	
	
	@Test
	public void testActiveIsFalse() {
		active = false;
		assertFalse(active);
		
		//equals false
		boolean expected = false;
		assertEquals(active,expected);
		
		//not equal
		boolean notEqual = true;
		assertNotEquals(active,notEqual);
	}
	@Test
	public void testActiveIsTrue() {
		active = true;
		assertTrue(active);
		
		//equals true
		boolean expected= true;
		assertEquals(active,expected);
		
		boolean notEqual = false;
		assertNotEquals(active,notEqual);
	}
	
	@Test
	public void testGetAndSetRoles() {
		String expected = "Worker";
		a.setRoles(roles);
		
		assertEquals(a.getRoles(),expected);
	}
	@Test
	public void testGetAndSetRolesNotEqual() {
		String expected = "Security";
		a.setRoles(roles);
		
		assertNotEquals(a.getRoles(),expected);
	}
	

}
