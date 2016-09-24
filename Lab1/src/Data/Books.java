package Data;

import java.util.ArrayList;

public class Books {
	private ArrayList<Book> books = null;
	
	public Books(){
		if (this.books == null){
			this.books = new ArrayList<Book>();
		}
	}
	
	public void addBook(Book book){
		this.books.add(book);
	}
	
	public ArrayList<Book> getBooks(){
		return this.books;
	}
}
