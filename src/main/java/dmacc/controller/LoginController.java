/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
package dmacc.controller;

import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Andrew Pierce - ajpierce1
 */
@Controller
public class LoginController {

	@PostMapping("/validateUser")
	public void checkUserCredentials() {
		/*
		 * try { String queryString =
		 * "SELECT * FROM user WHERE username=? AND password=?"; ResultSet rs =
		 * Statement.executeQuery(queryString);
		 * 
		 * 
		 * }
		 */
	}
		
}
