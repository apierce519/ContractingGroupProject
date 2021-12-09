/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 13, 2021
 */

package dmacc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	String userNotes;
	String adminNotes = "";
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	List<Employee> employeeList;
	// constructor
	
	public Contract(int id, String title, String length, int manpower, String notes, String adminNotes) {
		this.id = id;
		this.title = title;
		this.length = length;
		this.manpower = manpower;
		this.userNotes = notes;
		this.adminNotes = adminNotes;
	}

	// method
	public String contractInfo() {

		return "[id= " + id + " title= " + title + " length= " + length + " manpower= " + manpower + " workers]";
	}
}
