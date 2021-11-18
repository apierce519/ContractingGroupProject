/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 13, 2021
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
public class Contract {
	//variables
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
	
	//method
	public String contractInfo() {
		
		return "[id= " + id + " title= " + title + " length= " + length + " manpower= " + manpower + " workers]";
	}
}
