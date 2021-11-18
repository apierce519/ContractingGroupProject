/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 10, 2021
 */

package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cmboe
 *
 */

@Entity
@Data
@NoArgsConstructor
public class User {
	// variables
	@Id
	@GeneratedValue
	int id;
	String username;
	String password;
	String firstName;
	String lastName;
	String userType;
	
	//constructors
	public User(int id, String username, String password, String firstName, String lastName, String userType) {
		
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
	}
	
	//method
	public String userDetails() {
		return "[id= " + id + " username= " + username + " password= " + password + " name= " + firstName + " " + lastName + " userType= " + userType + "]" ;
	}
	
}
