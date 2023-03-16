package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.Library;

public class LibraryDAO extends SomeDAO<Library>{

	public LibraryDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	public void addLibrary(Library lib) throws ClassNotFoundException, SQLException {
		save("insert into tbl_library_branch (branchId, branchName, branchAddress) VALUES (?,?,?);", new Object[] {lib.getBranchId(), lib.getBranchName(), lib.getBranchAddress()});
	}
	public void updateLibrary(Library lib) throws ClassNotFoundException, SQLException{
		save("update tbl_library_branch set branchName = ?, branchAddress = ? where branchId = ?", new Object[] {lib.getBranchName(), lib.getBranchAddress(), lib.getBranchId()});
	}
	public void deleteLibrary(Library lib) throws ClassNotFoundException, SQLException{
		save("delete from tbl_library_branch (branchId, branchName, branchAddress) VALUES (?,?,?)", new Object[] {lib.getBranchId(), lib.getBranchName(), lib.getBranchAddress()});
	}
	public List<Library> readAllLibrary() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_library_branch", new Object [] {});
	}
	
	public List<Library> readLibrary(Library lib) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_library_branch WHERE branchId = ?", new Object[] {lib.getBranchId()});
	}
	public void readIntLibrary(Library lib) throws ClassNotFoundException, SQLException {
		read("SELECT * FROM tbl_library_branch WHERE branchId = ?", new Object[] {lib.getBranchId()});
	}
	
	

	@Override
	public List<Library> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
		List<Library> l =  new ArrayList<>();
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
				sb.append("Branch "+rs.getInt("branchId")+": ");
				sb.append(rs.getString("branchName")+" ");
				sb.append(rs.getString("branchAddress")+" \n");
			Library a = new Library();
			a.setBranchId(rs.getInt("branchId"));
			a.setBranchName(rs.getString("branchName"));
			l.add(a);
			System.out.println(sb.toString());
		}
		
		return l;
	}
	@Override
	public List<Library> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	}


