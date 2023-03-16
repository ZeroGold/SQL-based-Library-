package ProjectPackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import daoStorage.BorrowerDAO;
import daoStorage.CopiesDAO;
import daoStorage.LibraryDAO;
import daoStorage.LoansDAO;
import lib.pack.Borrower;
import lib.pack.Copies;
import lib.pack.Loans;

public class Borrow {
	static Util util = new Util();
	static Scanner menuObject = new Scanner(System.in);
	public static void menu() throws SQLException, ClassNotFoundException {
		Connection conn = util.getConnection();
		Borrower b = new Borrower();
		BorrowerDAO bor = new BorrowerDAO(conn);
		System.out.println("Input your Library Card No");
		int reader =  Integer.parseInt(menuObject.nextLine());
		b.setCardNo(reader);
		bor.checkCardNo(b);
		menu2(conn);
		
	}
	public static void menu2(Connection conn) throws ClassNotFoundException, SQLException {
		System.out.println("Pick what you wanna do");
		System.out.println("1. Check Out Book");
		System.out.println("2. Return Book");
		System.out.println("3. Quit to Previous Menu");
		int reader =  Integer.parseInt(menuObject.nextLine());
		if(reader==1) {
			checkOutMenu(conn);
		}
		if(reader==2) {
		returnMenu(conn);	
		}
		if(reader==3) {
			menu();
		}
	}
	private static void returnMenu(Connection conn) throws ClassNotFoundException, SQLException {
		CopiesDAO l = new CopiesDAO(conn);
		Copies lo = new Copies();
		LibraryDAO lol = new LibraryDAO(conn);
		lol.readAllLibrary();
		System.out.println("Type -1 to Quit to Previous Menu");
		int reader = Integer.parseInt(menuObject.nextLine());
		if(reader==-1) {
		menu2(conn);
		}
		if(reader!=-1) {
		returnMenu(reader,conn);
		}
		
	}
	private static void checkOutMenu(Connection conn) throws ClassNotFoundException, SQLException {
		CopiesDAO l = new CopiesDAO(conn);
		Copies lo = new Copies();
		LibraryDAO lol = new LibraryDAO(conn);
		lol.readAllLibrary();
		System.out.println("Type -1 to Quit to Previous Menu");
		int reader = Integer.parseInt(menuObject.nextLine());
		if(reader==-1) {
		menu2(conn);
		}
		if(reader!=-1) {
		addMenu(reader,conn);
		}
	}
	
	private static void addMenu(int reader, Connection conn) throws ClassNotFoundException, SQLException {
		CopiesDAO l = new CopiesDAO(conn);
		Copies lo = new Copies();
		System.out.println("Pick a book, by name");
		l.readAllCopies(lo);
		String reader2 = menuObject.nextLine();
		
		
	}
	
	private static void returnMenu(int reader, Connection conn) throws ClassNotFoundException, SQLException {
		CopiesDAO l = new CopiesDAO(conn);
		Copies lo = new Copies();
		System.out.println("Pick a book");
		l.readAllCopies(lo);
		int count = lo.getNoOfCopies();
		count = count + 1;
		lo.setNoOfCopies(count);
		
	}
}
