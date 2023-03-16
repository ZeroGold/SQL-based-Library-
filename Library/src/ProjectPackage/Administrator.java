package ProjectPackage;

import java.sql.Connection;
import java.sql.SQLException;

import daoStorage.AuthorDAO;
import daoStorage.BookDAO;

public class Administrator {

	static Util util = new Util();
	public static void menu() throws SQLException, ClassNotFoundException {
		Connection conn = util.getConnection();
		BookDAO bk = new BookDAO(conn);
	}
}
