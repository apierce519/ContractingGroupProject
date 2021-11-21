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
import login.beans.Operations;

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
		model.addAttribute("newUser", userRepo.findAll());
		return "viewUsers";
	}

	@GetMapping("/inputUser")
	private String addNewUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "inputUser";
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
		return "inputUser";
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
		model.addAttribute("newContract", contractRepo.findAll());
		return "viewContracts";
	}

	@GetMapping("/inputContract")
	private String addNewContract(Model model) {
		Contract c = new Contract();
		model.addAttribute("newContract", c);
		return "inputContract";
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
		return "inputContract";
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
		model.addAttribute("newEquipment", equipmentRepo.findAll());
		return "viewEquipment";
	}

	@GetMapping("/inputEquipment")
	public String addNewEquipment(Model model) {
		Equipment e = new Equipment();
		model.addAttribute("newEquipment", e);
		return "inputEquipment";
	}

	@GetMapping("/deleteEquipment/{id}")
	public String deleteEquipment(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		equipmentRepo.delete(e);
		return viewEquipment(model);
	}
	
	@GetMapping("/editEquipment/{id}")
	public String findEquipmentToUpdate(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		model.addAttribute("newEquipment", e);
		return "inputEquipment";
	}
	
	@PostMapping("/updateEquipment/{id}")
	public String editEquipment(Equipment e, Model model) {
		equipmentRepo.save(e);
		return viewEquipment(model);
	}
	
	@GetMapping("/loginOrRegister")
	public String viewLogin(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		return "loginOrRegister";
	}
	
	@PostMapping("/validateUser")
	public String checkUserCredentials(User u, Model model) {

		Operations operation = new Operations();
		
		try {
			String username = u.getUsername();
			String password = u.getPassword();
			String userType = u.getUserType();

			if(operation.isLogin(username, password, userType)) {
				
				return "index";
			}
		
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("Something broke.");
		}
		
		return "loginOrRegister";
		
	}
}

