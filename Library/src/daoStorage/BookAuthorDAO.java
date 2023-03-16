package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.BookAuthors;

public class BookAuthorDAO extends SomeDAO<BookAuthors> {
public BookAuthorDAO(Connection conn) {
				super(conn);
			}
		public void addBook(BookAuthors ba) throws SQLException, ClassNotFoundException {
			
			save("insert into tbl_book_authors (bookId,authorId) VALUES (?,?);", new Object[] {ba.getBookId(),ba.getAuthorId()});
		}
		public void updateBook(BookAuthors ba) throws ClassNotFoundException, SQLException {
			save("update tbl_book_authors (bookId,authorId) VALUES (?,?);", new Object[] {ba.getBookId(),ba.getAuthorId()});	
		}
		public void deleteBook(BookAuthors ba) throws ClassNotFoundException, SQLException {
			save("delete from tbl_book_authors where bookId = ? and  = ? authorId;", new Object[] {ba.getBookId(),ba.getAuthorId()});
			
		}
		public List<BookAuthors> readAllBook(BookAuthors ba) throws ClassNotFoundException, SQLException {
			
			 return read("select * from tbl_book_authors", new Object[] {});
			
			}
			
		public List<BookAuthors> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
			List<BookAuthors> books =  new ArrayList<>();
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append(" "+rs.getInt("bookId"));
				sb.append(" "+ rs.getString("authorId"));
				BookAuthors b = new BookAuthors();
				b.setBookId(rs.getInt("bookId"));
				b.setAuthorId(rs.getInt("authorId"));
				books.add(b);
				System.out.println(sb.toString());
			}
			
			return books;
		}
		@Override
		public List<BookAuthors> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		}


