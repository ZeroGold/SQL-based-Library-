package daoStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class SomeDAO<T> {
	protected Connection conn = null;
	public SomeDAO(Connection conn) {
		this.conn = conn;
		
	}
		
	
	public void save(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
	int count = 1;
	for(Object o: vals) {
		pstmt.setObject(count, o);
		count++;
	}
	pstmt.executeUpdate();
	}
	
	
	
	public List<T> read(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
	int count = 1;
	for(Object o: vals) {
		pstmt.setObject(count, o);
		count++;
	}
	ResultSet rs = pstmt.executeQuery();
	return extractData(rs);
	}
	
	
	abstract public List<T> extractData(ResultSet rs) throws ClassNotFoundException, SQLException;

	public List<T> read2(String sql, Object[] vals) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement(sql);
	int count = 1;
	for(Object o: vals) {
		pstmt.setObject(count, o);
		count++;
	}
	ResultSet rs = pstmt.executeQuery();
	return isNull(rs);
	}
	
	abstract public List<T> isNull(ResultSet rs) throws ClassNotFoundException, SQLException;


	public int isNull(ResultSet rs, int reader) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	public int isNull(ResultSet rs, int reader, Connection conn) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
}



