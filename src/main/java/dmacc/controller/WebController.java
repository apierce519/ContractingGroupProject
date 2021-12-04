/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 13, 2021
 */
package dmacc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrew Pierce - ajpierce1
 */

@Controller
@RequestMapping("/")
public class WebController {

	//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	@SuppressWarnings("unlikely-arg-type")
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping({ "/mainMenu" })
	public String mainMenu(Authentication auth) {
		UserDetails user = (UserDetails) auth.getPrincipal();
		System.out.println("CREDS:" + auth.getCredentials());
		System.out.println("DETAILS: " + auth.getDetails());
		System.out.println("NAME: " + auth.getName());
		System.out.println("PRINCIPAL: " + auth.getPrincipal());
		System.out.println("AUTH: " + user.getAuthorities());
		System.out.println("CLASS: " + auth.getClass());
		if (user.getAuthorities().equals("[ROLE_ADMIN]")) {
			return "mainMenu";
		} else {
			return "customerMenu";
		}
	}

	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping({ "/customerMenu", "/user/customerMenu" })
	public String customerMenu() {
		return "customerMenu";
	}

}
