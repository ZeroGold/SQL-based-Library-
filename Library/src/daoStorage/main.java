package daoStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import ProjectPackage.Util;
import lib.pack.Book;
import lib.pack.Copies;
import lib.pack.Library;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Util util = new Util();
		Connection conn = util.getConnection();
		Scanner update = new Scanner(System.in);
		CopiesDAO c = new CopiesDAO(conn);
		Copies co = new Copies();
		String reader = update.nextLine();
		int reader2 = Integer.parseInt(update.nextLine());
		int reader3 = Integer.parseInt(update.nextLine());
		co.setBooks(reader);
		co.setNoOfCopies(reader3);
		c.addCopies(co);
		
	}
		
}
