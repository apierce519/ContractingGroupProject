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

		String dbUrl = "jdbc:mysql://cis175a.cbcyamc80yze.us-east-1.rds.amazonaws.com:3306/contracting?useSSL=false";
		
		String dbUsername = "admin";
		String dbPassword = "Shopping";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = (Connection)DriverManager.getConnection(dbUrl, dbUsername,dbPassword);
		
		return con;
		
	}
	
	public static Connection getLocalConnection() throws Exception{
		String dbUrl = "jdbc:mysql://localhost:3306/contractingproject?useSSL=false";
		
		String dbUsername = "root";
		String dbPassword = "HeavyoldBarn53*)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = (Connection)DriverManager.getConnection(dbUrl, dbUsername,dbPassword);
		
		return con;
	}

}
