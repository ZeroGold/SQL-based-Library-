package lib.pack;

public class BookAuthors{
	Book b = new Book();
	Author a = new Author();
	private int bookId = b.getBookId();
	private int authorId = a.getAuthorId();
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	

}
