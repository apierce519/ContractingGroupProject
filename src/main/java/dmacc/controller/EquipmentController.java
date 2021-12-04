/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import dmacc.model.Equipment;
import dmacc.repository.EquipmentRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class EquipmentController {

	@Autowired
	EquipmentRepository equipmentRepo;

	// Equipment
	@Secured("ROLE_ADMIN")
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

	// Status
	@GetMapping("/inputStatus")
	public String addNewEquipmentStatus(Model model) {
		Equipment e = new Equipment();
		model.addAttribute("newEquipment", e);
		return "inputStatus";
	}

	@GetMapping("/editEquipmentStatus/{id}")
	public String findStatusToUpdate(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		model.addAttribute("newEquipment", e);
		return "inputStatus";
	}

	@GetMapping("/viewEquipmentStatus")
	public String viewEquipmentStatus(Model model) {
		if (equipmentRepo.findAll().isEmpty()) {
			return addNewEquipment(model);
		}
		model.addAttribute("newEquipment", equipmentRepo.findAll());
		return "viewEquipmentStatus";
	}

	@PostMapping("/updateEquipmentStatus/{id}")
	public String editEquipmentStatus(Equipment e, Model model) {
		equipmentRepo.save(e);
		return viewEquipmentStatus(model);
	}
}