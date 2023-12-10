package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{
	//private String director;
	//private int length;
	// Tao instance variable
	private static int nbDigitalVideoDiscs = 0;
	
	// Tao Constructor
	public DigitalVideoDisc(String title) {
		super((nbDigitalVideoDiscs+1), title);
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super((nbDigitalVideoDiscs+1), title, category, cost);
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super((nbDigitalVideoDiscs+1), title, category, cost, director);
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super((nbDigitalVideoDiscs+1), title, category, cost, length, director);
		nbDigitalVideoDiscs++;
	}

	//Tao chuc nang print cart 
	public String toString() {
			return String.format("DVD %s - %s - %s - %d minutes: %.2f $"
					,getTitle(), getCategory(),getDirector(),getLength(),getCost());
	}
	
	public boolean isMatch(String titleToMatch) {
		return getTitle().toLowerCase().contains(titleToMatch.toLowerCase());
	}
}
	