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

import dmacc.beans.Contract;
import dmacc.beans.Equipment;
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
 * Contract -view -input -delete -update -edit
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

	//Users
	@GetMapping("/viewUsers")
	public String viewUsers(Model model) {
		if (userRepo.findAll().isEmpty()) {
			return addNewUser(model);
		}
		return "user-results";
	}

	@PostMapping("/inputUser")
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

	//Contracts
	@GetMapping("/viewContracts")
	public String viewContracts(Model model) {
		if (contractRepo.findAll().isEmpty()) {
			return addNewContract(model);
		}
		return "contract-results";
	}

	@PostMapping("/inputContract")
	private String addNewContract(Model model) {
		Contract c = new Contract();
		model.addAttribute("newContact", c);
		return "contract-input";
	}

	@GetMapping("/deleteContract/{id}")
	public String deleteContract(@PathVariable("id") int id, Model model) {
		Contract c = contractRepo.findById(id).orElse(null);
		contractRepo.delete(c);
		return viewContracts(model);
	}

	@GetMapping("/editContract/{id}")
	public String findContractToUpdate(@PathVariable("id") int id, Model model) {
		Contract c = contractRepo.findById(id).orElse(null);
		model.addAttribute("newContract", c);
		return "contract-input";
	}

	@PostMapping("/updateContract/{id}")
	public String editContract(Contract c, Model model) {
		contractRepo.save(c);
		return viewContracts(model);
	}

	
	//Equipment
	@GetMapping("/viewEquipment")
	public String viewEquipment(Model model) {
		if (equipmentRepo.findAll().isEmpty()) {
			return addNewEquipment(model);
		}
		return "equipment-results";
	}

	@PostMapping("/inputEquipment")
	public String addNewEquipment(Model model) {
		Equipment e = new Equipment();
		model.addAttribute("newEquipment", e);
		return "equipment-input";
	}

	@GetMapping("/deleteEquipment/{id}")
	public String deleteEquipment(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		return viewEquipment(model);
	}
	
	@GetMapping("/editEquipment/{id}")
	public String findEquipmentToUpdate(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		model.addAttribute("newEquipment", e);
		return "equipment-input";
	}
	
	@PostMapping("/updateEquipment/{id}")
	public String editEquipment(Equipment e, Model model) {
		equipmentRepo.save(e);
		return viewEquipment(model);
	}
}

