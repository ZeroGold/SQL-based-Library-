package lib.pack;

import java.time.ZonedDateTime;

public class Loans {
	Borrower u = new Borrower();
	Book b = new Book();
	Library l = new Library();
	
	private int bookId = b.getBookId();
	private int branchId = l.getBranchId();
	private int cardNo = u.getCardNo();
	
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	private ZonedDateTime dateOut;
	private ZonedDateTime dateDue;
	private ZonedDateTime dateIn;
	public ZonedDateTime getDateOut() {
		return dateOut;
	}
	public void setDateOut(ZonedDateTime dateOut) {
		this.dateOut = dateOut;
	}
	public ZonedDateTime getDateDue() {
		return dateDue;
	}
	public void setDateDue(ZonedDateTime dateDue) {
		this.dateDue = dateDue;
	}
	public ZonedDateTime getDateIn() {
		return dateIn;
	}
	public void setDateIn(ZonedDateTime dateIn) {
		this.dateIn = dateIn;
	}
}
