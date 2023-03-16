package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.Copies;


public class CopiesDAO extends SomeDAO<Copies>{
	
	public CopiesDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void addCopies(Copies copies) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book_copies (books, noOfCopies, branchId) VALUES (?,?);", new Object[] {copies.getBooks(), copies.getNoOfCopies()});
		
	}
	public void updateCopies(Copies copies) throws ClassNotFoundException, SQLException{
		save("update tbl_book_copies set noOfCopies = ? where books = ?", new Object[] {copies.getNoOfCopies(), copies.getBooks()});
	}
	public void deleteCopies(Copies copies) throws ClassNotFoundException, SQLException{
		save("delete from tbl_book_copies (books, noOfCopies), (?,?)", new Object[] {copies.getBooks(), copies.getNoOfCopies()});
	}
	public List<Copies> readAllCopies(Copies copies) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_book_copies", new Object [] {});
	}
	
	public List<Copies> readCopies(Copies copies) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_book_copies WHERE books = ?", new Object[] {copies.getBooks()});
	}
	public List<Copies> countCopies(Copies copies) throws ClassNotFoundException, SQLException {
		return read2("SELECT * FROM tbl_book_copies WHERE books = ?", new Object[] {copies.getBooks()});
	}
	
	

	@Override
	public List<Copies> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
		List<Copies> copies =  new ArrayList<>();
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" "+rs.getInt("noOfCopies"));
			sb.append(" "+ rs.getString("books"));
			Copies a = new Copies();
			a.setNoOfCopies(rs.getInt("noOfCopies"));
			a.setBooks(rs.getString("books"));
			copies.add(a);
			System.out.println(sb.toString());
		}
		
		return copies;
	}

	@Override
	public List<Copies> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Copies> copies =  new ArrayList<>();
		while(rs.next()) {
			Copies a = new Copies();
			System.out.println("It went here");
			a.setNoOfCopies(rs.getInt("noOfCopies"));
			System.out.println(a.getNoOfCopies());
			int b = a.getNoOfCopies();
			if(b==0);{
			System.out.println("There are no copies of this book");
			}
			if(b>0) {
			System.out.println("There are this many copies: "+b);
			
			}
			}
		if(copies.isEmpty()) {
			System.out.println("There are no copies of this book.");
		}
		return copies;

	}
	}

