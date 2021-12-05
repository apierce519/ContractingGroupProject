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
import dmacc.model.Employee;
import dmacc.repository.EmployeeRepository;
import dmacc.repository.EquipmentRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	EquipmentRepository equipRepo;
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/inputEmployee")
	public String addNewEmployee(Model model) {
		model.addAttribute("equipments",equipRepo.findAll());
		Employee e = new Employee();
		model.addAttribute("newEmployee", e);
		return "/admin/inputEmployee";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/editEmployee/{id}")
	public String findEmployeeToUpdate(@PathVariable("id") int id, Model model) {
		Employee e = employeeRepo.findById(id).orElse(null);
		model.addAttribute("equipments",equipRepo.findAll());
		model.addAttribute("newEmployee", e);
		return "/admin/inputEmployee";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/viewEmployees")
	public String viewEmployee(Model model) {
		if (employeeRepo.findAll().isEmpty()) {
			return addNewEmployee(model);
		}
		model.addAttribute("newEmployee", employeeRepo.findAll());
		return "admin/viewEmployees";
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/updateEmployee/{id}")
	public String editEmployee(Employee e, Model model) {
		employeeRepo.save(e);
		return viewEmployee(model);
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id, Model model) {
		Employee e = employeeRepo.findById(id).orElse(null);
		employeeRepo.delete(e);
		return viewEmployee(model);
	}

}
