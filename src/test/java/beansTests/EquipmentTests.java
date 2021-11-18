/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 17, 2021
 */

package beansTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dmacc.beans.Equipment;

/**
 * @author cmboe
 *
 */
class EquipmentTests {
	//variables
	private int id = 1;
	private String name = "bobcat";
	private String type = "heavy machinery";
	
	/**
	 * Test method for getters and setters
	 */
	@Test
	void setEquipmentTestGetAndSetEquals() {
		Equipment newE = new Equipment();
		
		newE.setId(id);
		newE.setName(name);
		newE.setType(type);
		
		assertEquals(newE.getId(), id);
		assertEquals(newE.getName(), name);
		assertEquals(newE.getType(), type);
		
	}
	/**
	 * Test method for getters and setters where one variable doesn't match
	 */
	@Test
	void setEquipmentTestGetAndSetNotEquals1() {
		Equipment newE = new Equipment();
		
		String name1 = "bob";
		
		newE.setId(id);
		newE.setName(name1);
		newE.setType(type);
		
		assertEquals(newE.getId(), id);
		assertNotEquals(newE.getName(), name);
		assertEquals(newE.getType(), type);
		
	}
	/**
	 * Test method for getters and setters where two variable don't match
	 */
	@Test
	void setEquipmentTestGetAndSetNotEquals2() {
		Equipment newE = new Equipment();
		int id1 = 4;
		String name1 = "bob";
		
		newE.setId(id1);
		newE.setName(name1);
		newE.setType(type);
		
		assertNotEquals(newE.getId(), id);
		assertNotEquals(newE.getName(), name);
		assertEquals(newE.getType(), type);
		
	}
	/**
	 * Test method for getters and setters where three variable don't match
	 */
	@Test
	void setEquipmentTestGetAndSetNotEquals3() {
		Equipment newE = new Equipment();
		int id1 = 4;
		String name1 = "laptop";
		String type1 ="electronic";
		
		newE.setId(id1);
		newE.setName(name1);
		newE.setType(type1);
		
		assertNotEquals(newE.getId(), id);
		assertNotEquals(newE.getName(), name);
		assertNotEquals(newE.getType(), type);
		
	}



	/**
	 * Test method for set id equals
	 */
	@Test
	void testSetIdEquals() {
		int equipId = 1;
		int actual = id;
		
		assertEquals(actual, equipId);
	}
	
	/**
	 * Test method for set id doesnt equal
	 */
	@Test
	void testSetIdNotEquals() {
		int equipId = 2;
		int actual = id;
		
		assertNotEquals(actual, equipId);
	}

	/**
	 * Test method for name equals
	 */
	@Test
	void testSetNameEquals() {
		String eName = "bobcat";
		
		String actual = name;
		
		assertEquals(actual,eName);
	}
	
	/**
	 * Test method for name doesn't equal
	 */
	@Test
	void testSetNameNotEquals() {
		String eName = "hammer";
		
		String actual = name;
		
		assertNotEquals(actual,eName);
	}

	/**
	 * Test method for type
	 */
	@Test
	void testSetTypeEquals() {
		String eType = "heavy machinery";
		
		String actual = type;
		
		assertEquals(actual,eType);
	}
	
	/**
	 * Test method for type
	 */
	@Test
	void testSetTypeNotEquals() {
		String eType = "electronic";
		
		String actual = type;
		
		assertNotEquals(actual,eType);
	}
	
	/**
	 * Test method for equipment info
	 */
	@Test
	void EquipmentInfoTestEquals() {
		
		String info = "[id= 1 name= bobcat type= heavy machinery]";
		
		String actual = "[id= " + id +" name= " + name +" type= " + type + "]";
		
		assertEquals(actual,info);
	}
	
	/**
	 * Test method for equipment info not equals
	 */
	@Test
	void EquipmentInfoTestNotEquals() {
		
		String info = "[id= 2 name= Ipad type= electronic]";
		
		String actual = "[id= " + id +" name= " + name +" type= " + type + "]";
		
		assertNotEquals(actual,info);
	}

}
