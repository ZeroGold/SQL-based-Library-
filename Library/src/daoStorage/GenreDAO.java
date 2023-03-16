package daoStorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.pack.Genre;

public class GenreDAO extends SomeDAO<Genre>{
	
	public GenreDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void addGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("insert into tbl_genre (genreId, genreName), (?,?)", new Object[] {genre.getGenreId(), genre.getGenre_name()});
		
	}
	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException{
		save("update tbl_genre (genreId, genreName), (?,?)", new Object[] {genre.getGenreId(), genre.getGenre_name()});
	}
	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException{
		save("delete from tbl_genre (genreId, genreName), (?,?)", new Object[] {genre.getGenreId(), genre.getGenre_name()});
	}
	public List<Genre> readAllGenre() throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_genre", new Object [] {});
	}
	
	public List<Genre> readGenre(Genre genre) throws ClassNotFoundException, SQLException {
		return read("SELECT * FROM tbl_genre WHERE genre_name = ?", new Object[] {genre.getGenre_name()});
	}

	
	

	@Override
	public List<Genre> extractData(ResultSet rs) throws ClassNotFoundException, SQLException{
		List<Genre> Genre =  new ArrayList<>();
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
			sb.append(" "+rs.getInt("authorId"));
			sb.append(" "+ rs.getString("authorName"));
			Genre a = new Genre();
			a.setGenreId(rs.getInt("genreId"));
			a.setGenre_name(rs.getString("genre_name"));
			Genre.add(a);
			System.out.println(sb.toString());
		}
		
		return Genre;
	}

	@Override
	public List<Genre> isNull(ResultSet rs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	}
	



