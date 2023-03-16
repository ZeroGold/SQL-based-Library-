package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.BookGenre;

public class BookGenreDAO extends SomeDAO<BookGenre> {
	
	public BookGenreDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void addBookGenre(BookGenre genre) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book_genres (genreId, bookId), (?,?)", new Object[] {genre.getGenre_Id(), genre.getBookId()});
		
	}
	public void updateBookGenre(BookGenre genre) throws ClassNotFoundException, SQLException{
		save("update tbl_book_genres (genreId, bookId), (?,?)", new Object[] {genre.getGenre_Id(), genre.getBookId()});
	}
	public void deleteBookGenre(BookGenre genre) throws ClassNotFoundException, SQLException{
		save("delete from tbl_book_genres (genreId, bookId), (?,?)", new Object[] {genre.getGenre_Id(), genre.getBookId()});
	}
	public List<BookGenre> readAllBookGenre() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_book_genres", new Object [] {});
	}
	
	public List<BookGenre> readBookId(BookGenre genre) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_book_genres WHERE bookId = ?", new Object[] {genre.getBookId()});
	}

	
	

	@Override
	public List<BookGenre> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
		List<BookGenre> genre =  new ArrayList<>();
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" "+rs.getInt(""));
			sb.append(" "+ rs.getString("authorName"));
			BookGenre a = new BookGenre();
			a.setGenre_Id(rs.getInt("genreId"));
			a.setBookId(rs.getInt("bookId"));
			genre.add(a);
			System.out.println(sb.toString());
		}
		
		return genre;
	}

	@Override
	public List<BookGenre> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	}


