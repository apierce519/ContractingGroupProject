/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 19, 2021
 */

package dmacc.beans;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cmboe
 *
 */
@Embeddable
@Data
@NoArgsConstructor
public class EquipmentStatus {
	//variables
	String status;
	String location;
	String duration;
	
	public String statusInfo() {
		return "[status= " + status + " location= " + location + " duration of borrow= " + duration + "]";
	}
}
