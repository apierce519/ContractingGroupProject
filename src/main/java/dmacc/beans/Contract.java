/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 13, 2021
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
public class Contract {
	//variables
	@Id
	@GeneratedValue
	int id;
	String title;
	String length;
	int manpower;
	
	//constructor
	public Contract(int id, String title, String length, int manpower) {
		this.id = id;
		this.title = title;
		this.length = length;
		this.manpower = manpower;
	}
}
