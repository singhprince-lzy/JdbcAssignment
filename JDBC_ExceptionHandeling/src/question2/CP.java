package question2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * this class is static part of code that only used
 * to create the connection to database, so it's better to
 * have it in separate class for better reusability.
 * */

public class CP {
	
	public static Connection con;
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/publishingdata?useSSL=false";
			String username="root";
			String password="Iam110@coder";
			con=DriverManager.getConnection(url,username,password);	
		}catch(Exception c) {
			c.printStackTrace();
		}
		return con;
	}
}
