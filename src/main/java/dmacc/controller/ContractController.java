/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.controller;

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

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class ContractController {

	@Autowired
	ContractRepository contractRepo;

	// Contracts
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
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
	public String editContract(Contract c, Model model, Authentication auth) {
		c.setAuthor(auth.getName());
		contractRepo.save(c);
		return viewContracts(model);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/submitJobRequest")
	public String requestContract(Model model) {
		Contract c = new Contract();
		model.addAttribute("newContract", c);
		return "requestContract";
	}
}