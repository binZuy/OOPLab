package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import hust.soict.dsai.aims.exception.PlayerException;

public abstract class Media {
	// them fields
	private int id;
	private String title;
	private String category;
	private float cost;
	
	
	public Media(int id, String title, String category, float cost) {
		// TODO Auto-generated constructor stub
		this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
	}
	public Media(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	// Comparator for sorting by title then cost
    public static final Comparator<Media> COMPARE_BY_TITLE_COST 
    = new MediaComparatorByTitleCost();

    // Comparator for sorting by cost then title
    public static final Comparator<Media> COMPARE_BY_COST_TITLE 
    = new MediaComparatorByCostTitle();
	
	// them accessor methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	// Override equals method
	public boolean equals(Object obj){
		if(obj instanceof Media && obj!=null) {
			Media m = (Media) obj;
			return this.getTitle().equals(m.getTitle());
		}
		else return false;
	}
	
	// override toString method
	public String toString() {
		return String.format("Media %d. %s - %s : %.2f $",
				getId(),getTitle(), getCategory(),getCost());
	}
	public static void main(String[] args) {
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers 1", 
        		"Action", "Joss Whedon", 87, 20.55f);	// Them moi 1 dvd
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avengers 3", 
        		"Action", "Joss Whedon", 87, 22f);	// Them moi 1 dvd
        // test media toString method
        Book book1 = new Book(1, "Test Java", "Research", 20.55f);
        book1.addAuthor("BinZuy");
        book1.addAuthor("Minh Duy");
        CompactDisc cd1 = new CompactDisc(1, "Learning English", "Studying", 19.54f, 50, "Binzuy", "Minh Duy");
        CompactDisc cd2 = new CompactDisc(2, "Learning English 2", "Studying", 25f, 50, "Binzuy", "Minh Duy");
        ArrayList<Media> mediae = new ArrayList<Media>();
        mediae.add(dvd4);
        mediae.add(dvd6);
        mediae.add(book1);
        mediae.add(cd1);
        mediae.add(cd2);
        System.out.println("List media: ");
        for (Media med : mediae) {
        	System.out.println(med.toString());
        }
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        for (Media media : mediae) {
            System.out.println(media.toString());
        }
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        for (Media media : mediae) {
            System.out.println(media.toString());
        }
	}
	
	public abstract void play() throws PlayerException;
}


