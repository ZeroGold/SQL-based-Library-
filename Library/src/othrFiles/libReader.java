package othrFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class libReader {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String  url = "jdbc:mysql://127.0.0.1:3306/library";
	private static final String  user = "root";
	private static final String  pass = "shadow12";
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// REIGSTER THE DRIVER
		Class.forName(driver);
		//Create connection
		try {
		Connection conn = DriverManager.getConnection(url,user,pass);
		PreparedStatement pstmt = conn.prepareStatement("select * from tbl_author where bookId = ?");
		
		//Statement
		Scanner scan =  new Scanner(System.in);
		System.out.println("Enter what to search.");
		String search =  scan.nextLine();
		pstmt.setString(1, search);
		// Then add the code you want to add to enhance the search
		//Statement stmt = conn.createStatement();
		//String sql = "select * from tbl_author where bookId = '"+search+"'";
		//ResultSet rs = stmt.executeQuery(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("bookId"));
		}
		
		}
		finally {}
	}

}
