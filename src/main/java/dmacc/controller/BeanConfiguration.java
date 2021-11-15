/**
 *@author -Colby Boell -cmboell
 *CIS175 -Fall 2021
 *Nov 15, 2021
 */

package dmacc.controller;

import org.springframework.context.annotation.Bean;

import dmacc.beans.Contract;
import dmacc.beans.Equipment;
import dmacc.beans.User;

/**
 * @author cmboe
 *
 */
//set up bean configuration so if we need  to pre-populate some users, equipment, contracts, etc.
public class BeanConfiguration {
	@Bean
	public User user() {
		User bean = new User();
		return bean;
	}
	
	@Bean
	public Equipment equipment() {
		Equipment bean = new Equipment();
		return bean;
	}
	@Bean
	public Contract contract() {
		Contract bean = new Contract();
		return bean;
	}
}
