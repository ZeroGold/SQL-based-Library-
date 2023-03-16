package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.Author;

public class AuthorDAO extends SomeDAO<Author> {
	
	
	public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("insert into tbl_author (authorId, authorName) VALUES (?,?)", new Object[] {author.getAuthorId(), author.getAuthorName()});
		
	}
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException{
		save("update tbl_author (authorId, authorName), (?,?)", new Object[] {author.getAuthorId(), author.getAuthorName()});
	}
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException{
		save("delete from tbl_author (authorId, authorName), (?,?)", new Object[] {author.getAuthorId(), author.getAuthorName()});
	}
	public List<Author> readAllAuthors() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM author", new Object [0]);
	}
	
	public List<Author> readAuthorName(Author author) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM author WHERE authorId = ?", new Object[] {author.getAuthorId()});
	}

	
	public AuthorDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Author> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
		List<Author> author =  new ArrayList<>();
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" "+rs.getInt("authorId"));
			sb.append(" "+ rs.getString("authorName"));
			Author a = new Author();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			author.add(a);
			System.out.println(sb.toString());
		}
		
		return author;
	}
	@Override
	public List<Author> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	}


