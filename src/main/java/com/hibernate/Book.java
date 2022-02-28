package com.hibernate;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(
{
	@NamedQuery
	(
			name="AllBookFetch",
			query="from Book"			
	),
	
	
	@NamedQuery
	(
			name="SingleBookFetch",
			query="from Book where bookId:bookId"			
	)
	
})

public class Book {
	
	long bookId;
	String bookName;
	String bookAuthorName;
	long isbnNo;
	double bookPrice;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(long bookId, String bookName, String bookAuthorName, long isbnNo, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthorName = bookAuthorName;
		this.isbnNo = isbnNo;
		this.bookPrice = bookPrice;
	}
	
	


	public long getBookId() {
		return bookId;
	}


	public void setBookId(long bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthorName() {
		return bookAuthorName;
	}


	public void setBookAuthorName(String bookAuthorName) {
		this.bookAuthorName = bookAuthorName;
	}


	public long getIsbnNo() {
		return isbnNo;
	}


	public void setIsbnNo(long isbnNo) {
		this.isbnNo = isbnNo;
	}


	public double getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthorName=" + bookAuthorName + ", isbnNo="
				+ isbnNo + ", bookPrice=" + bookPrice + "]";
	}
	
	
	

}
