package hust.soict.dsai.aims.media;

//import java.util.List;
import java.util.ArrayList;

// Them 
public class Book extends Media {
		private ArrayList<String> authors = new ArrayList<String>();
	// Tao constructor
	public Book(int id, String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		super(id,title,category,cost);
		this.authors = new ArrayList<>();
	}
	
	// Tao getter and setter	
	public ArrayList<String> getAuthors(){
		return authors;
	}
	
	// add author and remove author
	public void addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println(authorName + " is added as an author.");
		}
		else 
			System.out.println(authorName + " is already an author of this book");
	}

	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println(authorName + " removed as an author.");
		}
		else 
			System.out.println(authorName + " is not an author of this book.");
	}
	
	//override toString method
	public String toString() {
		StringBuilder authorsString = new StringBuilder();
		if(!authors.isEmpty()) {
		for (String author : authors) {
			authorsString.append(author).append(", ");
		}
		authorsString.setLength(authorsString.length() - 2);
		}
		return String.format("Book " + getId() + ". "+ getTitle() +  " written by "+  authorsString.toString()+ ": " + getCost()+ " $");
	}
	
	public static void main (String[] args) {
		// Them sach 
		Book book = new Book(1, "Test Book", "Action", 20.5f);
		
		// Them tac gia
		book.addAuthor("Minh Duy");
		book.addAuthor("Tac Gia");
		book.addAuthor("Binzuy");// test TH ko co
		// Xem author
		System.out.println("Authors: " + book.getAuthors());
		
		// Xoa tac gia
		book.removeAuthor("Tac Gia");
		book.removeAuthor("Vu Lan");
		
		// Xem author sau khi xoa
		System.out.println("Authors: "+ book.getAuthors());
	}
}
