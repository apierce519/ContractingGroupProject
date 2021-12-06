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
		return "/admin/viewEquipment";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/inputEquipment")
	public String addNewEquipment(Model model) {
		Equipment e = new Equipment();
		model.addAttribute("newEquipment", e);
		return "/admin/inputEquipment";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteEquipment/{id}")
	public String deleteEquipment(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		equipmentRepo.delete(e);
		return viewEquipment(model);
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/editEquipment/{id}")
	public String findEquipmentToUpdate(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		model.addAttribute("newEquipment", e);
		return "/admin/inputEquipment";
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/updateEquipment/{id}")
	public String editEquipment(Equipment e, Model model) {
		equipmentRepo.save(e);
		return viewEquipment(model);
	}

	// Status
	@Secured("ROLE_ADMIN")
	@GetMapping("/inputStatus")
	public String addNewEquipmentStatus(Model model) {
		Equipment e = new Equipment();
		model.addAttribute("newEquipment", e);
		return "/admin/inputStatus";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/editEquipmentStatus/{id}")
	public String findStatusToUpdate(@PathVariable("id") int id, Model model) {
		Equipment e = equipmentRepo.findById(id).orElse(null);
		model.addAttribute("newEquipment", e);
		return "/admin/inputStatus";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/viewEquipmentStatus")
	public String viewEquipmentStatus(Model model) {
		if (equipmentRepo.findAll().isEmpty()) {
			return addNewEquipment(model);
		}
		model.addAttribute("newEquipment", equipmentRepo.findAll());
		return "/admin/viewEquipmentStatus";
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/updateEquipmentStatus/{id}")
	public String editEquipmentStatus(Equipment e, Model model) {
		equipmentRepo.save(e);
		return viewEquipmentStatus(model);
	}
}