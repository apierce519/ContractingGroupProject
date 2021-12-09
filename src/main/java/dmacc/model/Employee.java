package dmacc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cpobrien3
 */
@Entity
@Data
@NoArgsConstructor
public class Employee {
	//variables
	@Id
	@GeneratedValue
	int id;
	String firstName;
	String lastName;
	String role;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	List<Equipment> equipmentList;
	
	
	public String employeeInfo() {
		return "[Id= " + id + " FirstName= " + firstName + " LastName= " + lastName + " Role= " + role + "]";
	}
}
