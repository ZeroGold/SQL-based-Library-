package ProjectPackage;

import java.sql.SQLException;
import java.util.Scanner;

public class main {

	public static void menu() throws ClassNotFoundException, SQLException {
		Administrator a = new Administrator();
		Borrow b = new Borrow();
		Librarian c = new Librarian ();
		Scanner d = new Scanner(System.in);
		System.out.println("Who are you?\n1.Administrator\n2.Borrower\n3.Librarian");
		int reader = Integer.parseInt(d.nextLine());
		if(reader==1){
			Administrator.menu();
		}
		if(reader==2) {
			Borrow.menu();
		}
		if(reader==3) {
			Librarian.menu();
		}
	}
}
