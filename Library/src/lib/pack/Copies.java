package lib.pack;

public class Copies {
Library l = new Library();
Book b = new Book();

private String books = b.getTitle();
private int noOfCopies;

public int getNoOfCopies() {
	return noOfCopies;
}

public void setNoOfCopies(int noOfCopies) {
	this.noOfCopies = noOfCopies;
}


public String getBooks() {
	return books;
}

public void setBooks(String books) {
	this.books = books;
}

}
