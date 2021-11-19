/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */
package login.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import login.connection.SQLConnection;

import org.springframework.ui.Model;

/**
 * @author Andrew Pierce - ajpierce1
 */
public class Operations {

	public static boolean isLogin(String username, String password, String userType, Model model) {

		try {
			Connection myCon = SQLConnection.getConnection();

			String mySqlQuery = "SELECT id, user_type FROM user WHERE userName = '" + username + "' AND password = '"
					+ password + "' AND user_type = '" + userType + "'";

			PreparedStatement ps = myCon.prepareStatement(mySqlQuery);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				LoginSession.userId = resultSet.getInt("id");
				LoginSession.userName = resultSet.getString("username");
				LoginSession.userType = resultSet.getString("user_type");
			}
		} catch (Exception exception) {
			System.out.println("Something bad happened.");
		}
		return false;

	}
}