/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.User;
import dmacc.repository.ContractRepository;
import dmacc.repository.EquipmentRepository;
import dmacc.repository.UserRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */

/*
 * Things to do:
 * 
 * User - -update -edit Equipment -view -input -delete -update -edit Contract
 * -view -input -delete -update -edit
 * 
 */

@Controller
public class WebController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	EquipmentRepository equipmentRepo;

	@Autowired
	ContractRepository contractRepo;

	@GetMapping("/viewUsers")
	public String viewUsers(Model model) {
		if (userRepo.findAll().isEmpty()) {
			return addNewUser(model);
		}
		return "user-results";
	}

	@GetMapping("/inputUser")
	private String addNewUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "user-input";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		User u = userRepo.findById(id).orElse(null);
		userRepo.delete(u);
		return viewUsers(model);
	}

	@GetMapping("/editUser/{id}")
	public String findUserToUpdate(@PathVariable("id") int id, Model model) {
		User u = userRepo.findById(id).orElse(null);
		model.addAttribute("newUser", u);
		return "user-input";
	}

	@PostMapping("/updateUser/{id}")
	public String editUser(User u, Model model) {
		userRepo.save(u);
		return viewUsers(model);
	}
}
