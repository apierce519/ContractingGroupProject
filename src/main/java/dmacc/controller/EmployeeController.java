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
import org.springframework.web.bind.annotation.RequestMapping;
import dmacc.model.Employee;
import dmacc.repository.EmployeeRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;

	@GetMapping("/inputEmployee")
	public String addNewEmployee(Model model) {
		Employee e = new Employee();
		model.addAttribute("newEmployee", e);
		return "inputEmployee";
	}

	@GetMapping("/editEmployee/{id}")
	public String findEmployeeToUpdate(@PathVariable("id") int id, Model model) {
		Employee e = employeeRepo.findById(id).orElse(null);
		model.addAttribute("newEmployee", e);
		return "inputEmployee";
	}

	@GetMapping("/viewEmployees")
	public String viewEmployee(Model model) {
		if (employeeRepo.findAll().isEmpty()) {
			return addNewEmployee(model);
		}
		model.addAttribute("newEmployee", employeeRepo.findAll());
		return "viewEmployees";
	}

	@PostMapping("/updateEmployee/{id}")
	public String editEmployee(Employee e, Model model) {
		employeeRepo.save(e);
		return viewEmployee(model);
	}

}
