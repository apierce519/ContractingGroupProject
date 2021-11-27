/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */
package login.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import login.connection.SQLConnection;

/**
 * @author Andrew Pierce - ajpierce1
 */
public class Operations {

	public static LoginSession loginSession = new LoginSession();

	public static boolean isLogin(String username, String password, String userType) {

		try {
			Connection myCon = SQLConnection.getLocalConnection();

			String mySqlQuery = "SELECT id, user_type, username FROM user WHERE username = '" + username
					+ "' AND password = '" + password + "' AND user_type = '" + userType + "'";

			PreparedStatement ps = myCon.prepareStatement(mySqlQuery);
			ResultSet resultSet = ps.executeQuery();

			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();

			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
					System.out.print(",  ");
					String columnValue = resultSet.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
					System.out.println();
				}

				System.out.println("Result Set Data printed.");

				loginSession.setUserId(resultSet.getInt("id"));
				loginSession.setUserName(resultSet.getString("username"));
				loginSession.setUserType(resultSet.getString("user_type"));
				loginSession.setLoggedIn(true);

				System.out.println("Login Session set.");
				System.out.println(loginSession.printSession());

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something bad happened.");
		}
		return false;

	}
}