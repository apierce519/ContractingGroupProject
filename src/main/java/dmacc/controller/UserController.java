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
import dmacc.model.User;
import dmacc.repository.UserRepository;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	UserRepository userRepo;

	// Users
	@Secured({ "ROLE_ADMIN"})
	@GetMapping({ "/viewUsers", "/admin/viewUsers" })
	public String viewUsers(Model model) {
		if (userRepo.findAll().isEmpty()) {
			return inputUser(model);
		}
		model.addAttribute("newUser", userRepo.findAll());
		return "/admin/viewUsers";
	}

	@Secured({ "ROLE_ADMIN"})
	@GetMapping({"/inputUser", "/admin/inputUser" })
	private String inputUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "/admin/inputUser";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		User u = userRepo.findById(id).orElse(null);
		userRepo.delete(u);
		return viewUsers(model);
	}

	@Secured("ROLE_ADMIN")
	@GetMapping("/editUser/{id}")
	public String findUserToUpdate(@PathVariable("id") int id, Model model) {
		User u = userRepo.findById(id).orElse(null);
		model.addAttribute("newUser", u);
		return "/admin/inputUser";
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/updateUser/{id}")
	public String editUser(User u, Model model) {
		userRepo.save(u);
		return viewUsers(model);
	}
	
	@GetMapping("/registerUser")
	public String registerNewUser(Model model) {
		User u = new User();
		model.addAttribute("newUser",u);
		return "registerUser";
	}
}