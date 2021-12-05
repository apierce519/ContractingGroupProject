/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 13, 2021
 */

package dmacc.model;

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
	// variables
	@Id
	@GeneratedValue
	int id;
	String approvalStatus;
	String title;
	String length;
	int manpower;
	String author;
	String notes;

	// constructor
	public Contract(int id, String title, String length, int manpower, String notes) {
		this.id = id;
		this.title = title;
		this.length = length;
		this.manpower = manpower;
		this.notes = notes;
	}

	// method
	public String contractInfo() {

		return "[id= " + id + " title= " + title + " length= " + length + " manpower= " + manpower + " workers]";
	}
}
