package dmacc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
		
}
