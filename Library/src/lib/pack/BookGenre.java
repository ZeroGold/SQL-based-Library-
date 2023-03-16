package lib.pack;

public class BookGenre {
Book b = new Book();
Genre g = new Genre();

private int genre_Id = g.getGenreId();
public int getGenre_Id() {
	return genre_Id;
}
public void setGenre_Id(int genre_Id) {
	this.genre_Id = genre_Id;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
private int bookId = b.getBookId();

}
