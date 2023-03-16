package ProjectPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	private final String driver = "com.mysql.jdbc.Driver";
	private final String  url = "jdbc:mysql://127.0.0.1:3306/library";
	private final String  user = "root";
	private final String  pass = "shadow12";
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,pass);
		return conn;
		
	}
	
	
	
}