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
public class Equipment {
	//variables
	int id;
	String name;
	String type;
	
	public Equipment(int id, String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
}
