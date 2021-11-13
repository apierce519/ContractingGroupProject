/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 10, 2021
 */

package dmacc.beans;

import javax.persistence.Entity;

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
	//variables
	int id;
	String username;
	String password;
	String firstName;
	String lastName;
	String userType;
	
}
