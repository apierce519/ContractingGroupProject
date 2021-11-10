/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 10, 2021
 */

package dmacc.beans;

/**
 * @author cmboe
 *
 */
public class Customer {
	//variables
	int id;
	String firstName;
	String lastName;
	
	//constructors
	public Customer() {
		super();
	}
	
	//getters and setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
  //methods
}
