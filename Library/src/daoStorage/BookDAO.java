package daoStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lib.pack.Book;
import lib.pack.Copies;

public class BookDAO extends SomeDAO<Book> {
	public BookDAO(Connection conn) {
		super(conn);
	}
public void addBook(Book book) throws SQLException, ClassNotFoundException {
	
	save("insert into tbl_book (bookId,title) VALUES (?,?);", new Object[] {book.getBookId(),book.getTitle()});
}
public void updateBook(Book book) throws ClassNotFoundException, SQLException {
	save("update tbl_book (bookId,title) VALUES (?,?);", new Object[] {book.getBookId(),book.getTitle()});	
}
public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
	save("delete from tbl_book where bookId = ? and title = ? ;", new Object[] {book.getBookId(),book.getTitle()});
	
}
public List<Book> readAllBook(Book book) throws ClassNotFoundException, SQLException {
	
	 return read("select * from tbl_book", new Object[] {});
	
	}
public List<Book> readBook(Book book) throws ClassNotFoundException, SQLException {
	return read("SELECT * FROM tbl_book WHERE bookId = ?", new Object[] {book.getBookId()});
}
	
public List<Book> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
	List<Book> books =  new ArrayList<>();
	while(rs.next()) {
		StringBuilder sb = new StringBuilder();
		sb.append(" "+rs.getInt("bookId"));
		sb.append(" "+ rs.getString("title"));
		Book b = new Book();
		b.setBookId(rs.getInt("bookId"));
		b.setTitle(rs.getString("title"));
		books.add(b);
		System.out.println(sb.toString());
	}
	
	return books;
}
@Override
public List<Book> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return null;
}

}

