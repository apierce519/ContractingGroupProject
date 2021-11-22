/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 19, 2021
 */

package beansTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dmacc.beans.EquipmentStatus;

/**
 * @author cmboe
 *
 */
class EquipmentStatusTests {
	private String eStatus = "Checked out";
	private String location = "Downtown Remodel";
	private String duration = "1 month";

	//test getters and setters
	@Test
	void equipmentStatusGetSetTest() {
		EquipmentStatus status = new EquipmentStatus();
		
		status.setStatus(eStatus);
		status.setLocation(location);
		status.setDuration(duration);
		
		assertEquals(status.getStatus(), eStatus);
		assertEquals(status.getLocation(), location);
		assertEquals(status.getDuration(), duration);
		
	}
	//not equals test
	@Test
	void equipmentStatusGetSetTestNotEquals() {
		EquipmentStatus status = new EquipmentStatus();
		
		status.setStatus("Available");
		status.setLocation("Office");
		status.setDuration(null);
		
		assertNotEquals(status.getStatus(), eStatus);
		assertNotEquals(status.getLocation(), location);
		assertNotEquals(status.getDuration(), duration);
		
	}
	
	//test information string
	@Test
	void equipmentStatusInfoTest() {
		
		String info = "[status= Checked out location= Downtown Remodel duration of borrow= 1 month]";
	    
	    String actual = "[status= " + eStatus + " location= " + location + " duration of borrow= " + duration + "]";
	    
	    assertEquals(actual, info);
		
	}
	
	//test information string not equals
		@Test
		void equipmentStatusInfoTestNotEquals() {
			
			String info = "[status = Checked Out location= Bathroom tile redo duration of borrow= 1 month]";
		    
		    String actual = "[status= " + eStatus + " location= " + location + " duration of borrow= " + duration + "]";
		    
		    assertNotEquals(actual, info);
			
		}

}