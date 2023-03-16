package ProjectPackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import daoStorage.BookDAO;
import daoStorage.CopiesDAO;
import daoStorage.LibraryDAO;
import lib.pack.Book;
import lib.pack.Copies;
import lib.pack.Library;

public class Librarian {
	static Scanner menuObject = new Scanner(System.in);
	static Util util = new Util();
	static ProjectPackage.main main = new main();
	
	
	
	public static void menu() throws SQLException, ClassNotFoundException {
		System.out.println("Select an option.");
		System.out.println("1. Select A Branch");
		System.out.println("2. Quit to Previous");
		int reader = Integer.parseInt(menuObject.nextLine());
		if(reader==1) {
			menu2();
		}else if(reader==2){
			ProjectPackage.main.menu();
		}else {
			System.out.println("You didn't select an option. Press 1 or 2");
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	public static void menu2() throws ClassNotFoundException, SQLException {
		System.out.println("Select a branch");
		Connection conn = util.getConnection();
		LibraryDAO l = new LibraryDAO(conn);
		l.readAllLibrary();
		System.out.println("Type -1 to Quit to Previous Menu");
		int reader = Integer.parseInt(menuObject.nextLine());
		if(reader==-1) {
		menu();
		}
		if(reader!=-1) {
		menu3(reader,conn);
		}
	}
	public static void menu3(int libChoice,Connection conn) throws ClassNotFoundException, SQLException {
		Library lib = new Library();
		LibraryDAO l = new LibraryDAO(conn);
		lib.setBranchId(libChoice);
		System.out.println("Choose what to do at :");
		l.readLibrary(lib);
		System.out.println("1. Update the details of the Library");
		System.out.println("2. Add copies of Book to the Branch");
		System.out.println("3. Quit to previous");
		int reader = Integer.parseInt(menuObject.nextLine());
		if(reader==1) {
			libUpdateMenu(libChoice,conn);
		}
		if(reader==2) {
			bookUpdateMenu(libChoice, conn);
		}
		if(reader==3) {
		menu2();
		}
		}










	private static void bookUpdateMenu(int libChoice, Connection conn) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		BookDAO b = new BookDAO(conn);
		CopiesDAO c = new CopiesDAO(conn);
		Copies co =  new Copies();
		Book bo = new Book();
		c.readAllCopies(co);
		System.out.println("Select a book");
		String reader = menuObject.nextLine();
		co.setBooks(reader);
		c.readCopies(co);
		c.countCopies(co);
		System.out.println("Enter new number of copies");
		int reader2 = Integer.parseInt(menuObject.nextLine());
		co.setNoOfCopies(reader2);
		c.updateCopies(co);
		menu3(libChoice, conn);
		}
		
		
		
		
		
	










	private static void libUpdateMenu(int libChoice, Connection conn) throws ClassNotFoundException, SQLException {
		LibraryDAO lib = new LibraryDAO(conn);
		Library l = new Library();
		System.out.println("Please enter new branch name or type N/A for no change");
		String reader = menuObject.nextLine();
		if(reader.equals("N/A")){
			System.out.println("No change made");
			}
		System.out.println("Please enter the new branch address or type N/A for no change");
		String reader2 = menuObject.nextLine();
		
	if(!reader2.equals("N/A")){
		l.setBranchName(reader);
		l.setBranchAddress(reader2);
		l.setBranchId(libChoice);
		lib.updateLibrary(l);
		System.out.println("Successful Library Update");
		menu3(libChoice, conn);
	}
	else {
		System.out.println("No change made");
		menu3(libChoice,conn);
		}
	}
}		
	

