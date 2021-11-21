/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
package login.controller;

import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.User;
import login.beans.Operations;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Controller
public class LoginController {

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
			System.out.println("Something broke.");
		}
		
		return "loginOrRegister";
		
	}

}