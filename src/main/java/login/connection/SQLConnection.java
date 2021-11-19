/**
 * @author Andrew Pierce - ajpierce1
 * CIS175 - Fall 2021
 * Nov 18, 2021
 */
package login.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Andrew Pierce - ajpierce1
 */
public class SQLConnection {
	
	public static Connection getConnection() throws Exception{
		
		String dbRoot = "jdbc:mysql://";
		String hostName = "cis175a.cbcyamc80yze.us-east-1.rds.amazonaws.com:3306/";
		String dbName = "contracting?useSSL=false";
		String dbUrl = dbRoot + hostName + dbName;
		
		String hostUsername = "admin";
		String hostPassword = "Shopping";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection)DriverManager.getConnection(dbUrl, hostUsername,hostPassword);
		
		return null;
		
	}

}
