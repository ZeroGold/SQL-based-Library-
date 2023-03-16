package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ProjectPackage.Borrow;
import lib.pack.Borrower;

public class BorrowerDAO extends SomeDAO<Borrower>{
	
	public BorrowerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void addBorrow(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("insert into tbl_borrower (cardNo, name, address, phone), (?,?)", new Object[] {borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone()});
		
	}
	public void updateBorrow(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("update tbl_borrower (cardNo, name,address,phone), (?,?)", new Object[] {borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone()});
	}
	public void deleteBorrow(Borrower borrower) throws ClassNotFoundException, SQLException{
		save("delete from tbl_borrower (cardNo, name, address, phone), (?,?)", new Object[] {borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone()});
	}
	public List<Borrower> readAllBorrow() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_borrower", new Object [] {});
	}
	
	public List<Borrower> readBorrow(Borrower borrower) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_borrower WHERE name = ?", new Object[] {borrower.getName()});
	}
	public List<Borrower> checkCardNo(Borrower borrower) throws ClassNotFoundException, SQLException {
		return read2("SELECT * FROM tbl_borrower WHERE cardNo = ?", new Object[] {borrower.getCardNo()});
	}
	
	

	@Override
	public List<Borrower> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
		List<Borrower> borrower =  new ArrayList<>();
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" "+rs.getInt("authorId"));
			sb.append(" "+ rs.getString("authorName"));
			Borrower a = new Borrower();
			a.setCardNo(rs.getInt("cardNo"));
			a.setAddress(rs.getString("address"));
			borrower.add(a);
			System.out.println(sb.toString());
		}
		
		return borrower;
	}

	@Override
	public List<Borrower> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
		Borrower a = new Borrower();
		List<Borrower> borrow = new ArrayList<>();
		while(rs.next()) {
			a.setCardNo(rs.getInt("cardNo"));
			borrow.add(a);

	}
		return borrow;
	}	
	}


