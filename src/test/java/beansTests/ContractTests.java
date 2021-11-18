package beansTests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dmacc.beans.Contract;

/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 17, 2021
 */

/**
 * @author cmboe
 *
 */
class ContractTests {
	//variables
		private int id = 1;
		private String title = "Bathroom Remodel";
		private String length = "2 days";
		private int manpower = 2;
		/**
		 * Test method for getters and setters
		 */
	@Test
	void setContractGetAndSetTestEquals() {
		Contract newC = new Contract();
		
		newC.setId(id);
		newC.setTitle(title);
		newC.setLength(length);
		newC.setManpower(manpower);
		
		assertEquals(newC.getId(),id);
		assertEquals(newC.getTitle(),title);
		assertEquals(newC.getLength(),length);
		assertEquals(newC.getManpower(),manpower);
	}
	
	/**
	 * Test method for getters and setters where info doesn't match
	 */
@Test
void setContractGetAndSetTestNotEquals() {
	Contract newC = new Contract();
	
	int id1 = 14;
	String title1 = "Windows Replacement";
	String length1 = "5 days";
	int manpower1 = 4;
	
	newC.setId(id1);
	newC.setTitle(title1);
	newC.setLength(length1);
	newC.setManpower(manpower1);
	
	assertNotEquals(newC.getId(),id);
	assertNotEquals(newC.getTitle(),title);
	assertNotEquals(newC.getLength(),length);
	assertNotEquals(newC.getManpower(),manpower);
}
	/**
	 * Test method for id equals
	 */
	@Test
	void testSetIdEquals() {
		int cId = 1;
		
		int actual = id;
		
		assertEquals(actual, cId);
		
	}
	
	/**
	 * Test method for id doesn't equal
	 */
	@Test
	void testSetIdNotEquals() {
		int cId = 5;
		
		int actual = id;
		
		assertNotEquals(actual, cId);
		
	}

	/**
	 * Test method for title
	 */
	@Test
	void testSetTitleEquals() {
		String cT = "Bathroom Remodel";
		
	    String actual = title;
	    
	    assertEquals(actual,cT);
	}
	
	/**
	 * Test method for title doesn't equal
	 */
	@Test
	void testSetTitleNotEquals() {
		String cT = "Back Porch Construction";
		
	    String actual = title;
	    
	    assertNotEquals(actual,cT);
	}

	/**
	 * Test method for length
	 */
	@Test
	void testSetLengthEquals() {
		String cL = "2 days";
		
		String actual = length;
		
		assertEquals(actual, cL);
	}
	
	/**
	 * Test method for length not equal
	 */
	@Test
	void testSetLengthNotEquals() {
		String cL = "15 days";
		
		String actual = length;
		
		assertNotEquals(actual, cL);
	}


	/**
	 * Test method for set manpower
	 */
	@Test
	void testSetManpowerEquals() {
		int mP = 2;
		
		int actual = manpower;
		
		assertEquals(actual, mP);
	}
	
	/**
	 * Test method for set manpower not equal
	 */
	@Test
	void testSetManpowerNotEquals() {
		int mP = 8;
		
		int actual = manpower;
		
		assertNotEquals(actual, mP);
	}
	
	
	/**
	 * Test method for contract info
	 */
   @Test
   void contractInfoTestEquals() {
	   int id = 1;
		String title = "Bathroom Remodel";
		String length = "2 days";
		int manpower = 2;
	   String info = "[id= 1 title= Bathroom Remodel length= 2 days manpower= 2 workers]";
	   
	   String actual = "[id= " + id + " title= " + title + " length= " + length + " manpower= " + manpower + " workers]";
	   
	   assertEquals(actual, info);
   }
   
   @Test
   void contractInfoTestDoesntEqual() {
	   String info = "[id= 15 title= Windows Replacement length= 5 days manpower= 4 workers]";
	   
	   String actual = "[id= " + id + " title= " + title + " length= " + length + " manpower= " + manpower + " workers]";
	   
	   assertNotEquals(actual, info);
   }
   
}
