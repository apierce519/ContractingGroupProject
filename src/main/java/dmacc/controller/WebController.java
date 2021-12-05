/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dmacc.model.MyUserDetails;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class WebController {

	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping({ "/mainMenu" })
	public String mainMenu(Authentication auth) {
		MyUserDetails user = (MyUserDetails) auth.getPrincipal();
		System.out.println(auth.getName());
		if (user.getRoles().equals("ROLE_ADMIN")) {
			return "/admin/mainMenu";
		} else {
			return "/user/customerMenu";
		}
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping({ "/customerMenu", "/user/customerMenu" })
	public String customerMenu() {
		return "customerMenu";
	}

}
