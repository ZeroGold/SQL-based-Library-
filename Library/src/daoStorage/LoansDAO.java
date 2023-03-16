package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.Loans;

public class LoansDAO extends SomeDAO<Loans> {

		public LoansDAO(Connection conn) {
			super(conn);
			// TODO Auto-generated constructor stub
		}
		public void addLibrary(Loans loan) throws ClassNotFoundException, SQLException {
			save("insert into tbl_book_loans (dateOut, dateDue, dateIn) VALUES (?,?,?);", new Object[] {loan.getDateOut(), loan.getDateDue(), loan.getDateIn()});
			
		}
		public void updateLibrary(Loans loan) throws ClassNotFoundException, SQLException{
			save("update tbl_book_loans (dateOut, dateDue, dateIn) VALUES (?,?,?)", new Object[] {loan.getDateOut(), loan.getDateDue(), loan.getDateIn()});
		}
		public void deleteLibrary(Loans loan) throws ClassNotFoundException, SQLException{
			save("delete from tbl_book_loans (dateOut, dateDue, dateIn) VALUES (?,?,?)", new Object[] {loan.getDateOut(), loan.getDateDue(), loan.getDateIn()});
		}
		public List<Loans> readAllLoans() throws ClassNotFoundException, SQLException {
			return read("SELECT * FROM tbl_book_loans", new Object [] {});
		}
		
		public List<Loans> readLoans(Loans loan) throws ClassNotFoundException, SQLException {
			return read("SELECT * FROM tbl_book_loans WHERE bookId = ?", new Object[] {loan.getBookId()});
		}

		
		

		@Override
		public List<Loans> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
			List<Loans> l =  new ArrayList<>();
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
					sb.append(rs.getInt("bookId"));
					sb.append(rs.getString("branchId"));
				Loans a = new Loans();
				a.setBookId(rs.getInt("bookId"));
				a.setCardNo(rs.getInt("cardNo"));
				l.add(a);
				System.out.println(sb.toString());
			}
			
			return l;
		}
		@Override
		public List<Loans> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		}


