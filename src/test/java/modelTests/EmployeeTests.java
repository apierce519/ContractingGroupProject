/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Dec 3, 2021
 */

package modelTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dmacc.model.Employee;

/**
 * @author cmboe
 *
 */
class EmployeeTests {
	//variables
	private static Employee a = new Employee();
	private static int id = 1;
	private static String firstName = "Test";
	private static String lastName = "Case";
	private static String role = "Worker";
		

	/**
	 * test getters and setters of the Employee class
	 */
	@Test
	public void testGetAndSetEmployee() {
		a.setId(1);
		a.setFirstName("Test");
		a.setLastName("Case");
		a.setRole("Worker");
		
		assertEquals(a.getId(),id);
		assertEquals(a.getFirstName(),firstName);
		assertEquals(a.getLastName(),lastName);
		assertEquals(a.getRole(),role);
	}
	
	/**
	 * test getters and setters of the Employee class not equal
	 */
	@Test
	public void testGetAndSetEmployeeNotEqual() {
		a.setId(2);
		a.setFirstName("Case");
		a.setLastName("Test");
		a.setRole("Laborer");
		
		assertNotEquals(a.getId(),id);
		assertNotEquals(a.getFirstName(),firstName);
		assertNotEquals(a.getLastName(),lastName);
		assertNotEquals(a.getRole(),role);
	}
	
	@Test
	public void testGetAndSetId() {
		Integer expected = 1;
		a.setId(id);
		
		assertEquals(a.getId(),expected);
	}
	@Test
	public void testGetAndSetIdNotEqual() {
		Integer expected = 5;
		a.setId(id);
		
		assertNotEquals(a.getId(),expected);
	}
	@Test
	public void testVariableIdIsNotNull() {
		a.setId(id);
		
		assertNotNull(a.getId());
	}
	
	@Test
	public void testGetAndSetFirstName() {
		String expected = "Test";
		a.setFirstName(firstName);
		
		assertEquals(a.getFirstName(),expected);
	}
	@Test
	public void testGetAndSetFirstNameNotEqual() {
		String expected = "Case";
		a.setFirstName(firstName);
		
		assertNotEquals(a.getFirstName(),expected);
	}
	
	@Test
	public void testGetAndSetLastName() {
		String expected = "Case";
		a.setLastName(lastName);
		
		assertEquals(a.getLastName(),expected);
	}
	@Test
	public void testGetAndSetLastNameNotEqual() {
		String expected = "Test";
		a.setLastName(lastName);
		
		assertNotEquals(a.getLastName(),expected);
	}
	
	@Test
	public void testGetAndSetRole() {
		String expected = "Worker";
		a.setRole(role);
		
		assertEquals(a.getRole(),expected);
	}
	@Test
	public void testGetAndSetRoleNotEqual() {
		String expected = "Laborer";
		a.setRole(role);
		
		assertNotEquals(a.getRole(),expected);
	}
	
	@Test
	public void testEmployeeInfo() {
		String expected = "[Id= 1 FirstName= Test LastName= Case Role= Worker]";
		
		String actual =  "[Id= " + id + " FirstName= " + firstName + " LastName= " + lastName + " Role= " + role + "]";
		
		assertEquals(actual,expected);
	}
	
	@Test
	public void testEmployeeInfoNotEqual() {
		String expected = "[Id= 4 FirstName= New LastName= Name + Role= Laborer]";
		
		String actual =  "[Id= " + id + " FirstName= " + firstName + " LastName= " + lastName + " Role= " + role + "]";
		
		assertNotEquals(actual,expected);
	}
}
