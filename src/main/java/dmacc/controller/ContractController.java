/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import dmacc.model.Contract;
import dmacc.repository.ContractRepository;
import dmacc.repository.EmployeeRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class ContractController {

	@Autowired
	ContractRepository contractRepo;
	@Autowired
	EmployeeRepository employRepo;

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/viewContracts")
	public String viewContracts(Model model) {
		if (contractRepo.findAll().isEmpty()) {
			return openAddNewContractPage(model);
		}
		model.addAttribute("newContract", contractRepo.findAll());
		return "/shared/viewContracts";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/inputContract")
	private String openAddNewContractPage(Model model) {
		Contract c = new Contract();
		model.addAttribute("employees",employRepo.findAll());
		model.addAttribute("newContract", c);
		return "/user/requestContract";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteContract/{id}")
	public String deleteContract(@PathVariable("id") int id, Model model) {
		Contract c = contractRepo.findById(id).orElse(null);
		contractRepo.delete(c);
		return viewContracts(model);
	}


	@Secured("ROLE_ADMIN")
	@GetMapping("/editContract/{id}")
	public String findContractToUpdate(@PathVariable("id") int id, Model model) {
		Contract c = contractRepo.findById(id).orElse(null);
		model.addAttribute("employees",employRepo.findAll());
		model.addAttribute("newContract", c);
		return "admin/editContract";
	}

	@PostMapping("/updateContract/{id}")
	public String submitContractEdits(Contract c, Model model) {
		contractRepo.save(c);
		return viewContracts(model);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@PostMapping("/addCustomerContract/{id}")
	public String addCustomerContract(Contract c, Model model, Authentication auth) {
		c.setAuthor(auth.getName());
		c.setApprovalStatus("PENDING");
		contractRepo.save(c);
		return "/user/customerMenu";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/submitJobRequest")
	public String requestContract(Model model) {
		Contract c = new Contract();
		model.addAttribute("newContract", c);
		return "/user/requestContract";
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/viewSubmittedJobs")
	public String viewSubmittedJobs(Model model, Authentication auth) {

		if (contractRepo.findAll().isEmpty()) {
			return openAddNewContractPage(model);
		} else {
			List<Contract> contractList = contractRepo.findAll();
			List<Contract> foundContracts = new ArrayList<Contract>();
			for (Contract c : contractList) {
				if (c.getAuthor() != null) {
					if (c.getAuthor().equals(auth.getName())) {
						foundContracts.add(c);
					}
				}
			}
			model.addAttribute("newContract", foundContracts);
			return "/shared/viewContracts";
		}
	}
}