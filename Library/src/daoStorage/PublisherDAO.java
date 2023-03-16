package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.Publisher;

public class PublisherDAO extends SomeDAO<Publisher> {

	public PublisherDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	public void addLibrary(Publisher pbl) throws ClassNotFoundException, SQLException {
		save("insert into tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) VALUES (?,?,?,?);", new Object[] {pbl.getPublisherId(), pbl.getPublisherName(), pbl.getPublisherAddress(),pbl.getPublisherPhone()});
		
	}
	public void updateLibrary(Publisher pbl) throws ClassNotFoundException, SQLException{
		save("update tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) VALUES (?,?,?,?)", new Object[] {pbl.getPublisherId(), pbl.getPublisherName(), pbl.getPublisherAddress(),pbl.getPublisherPhone()});
	}
	public void deleteLibrary(Publisher pbl) throws ClassNotFoundException, SQLException{
		save("delete from tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) VALUES (?,?,?,?)", new Object[] {pbl.getPublisherId(), pbl.getPublisherName(), pbl.getPublisherAddress(),pbl.getPublisherPhone()});
	}
	public List<Publisher> readAllLoans() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_publisher", new Object [] {});
	}
	
	public List<Publisher> readLoans(Publisher pbl) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_publisher WHERE publisherId = ?", new Object[] {pbl.getPublisherId()});
	}

	
	

	@Override
	public List<Publisher> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
		List<Publisher> l =  new ArrayList<>();
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
				sb.append(rs.getInt("publisherId"));
				sb.append(rs.getString("publisherName"));
			Publisher a = new Publisher();
			a.setPublisherId(rs.getInt("publisherId"));
			a.setPublisherName(rs.getString("publisherName"));
			l.add(a);
			System.out.println(sb.toString());
		}
		
		return l;
	}
	@Override
	public List<Publisher> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
