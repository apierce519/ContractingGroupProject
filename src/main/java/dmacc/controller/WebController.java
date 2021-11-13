/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dmacc.repository.ContractRepository;
import dmacc.repository.EquipmentRepository;
import dmacc.repository.UserRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Controller
public class WebController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EquipmentRepository equipmentRepo;
	
	@Autowired
	ContractRepository contractRepo;
}
