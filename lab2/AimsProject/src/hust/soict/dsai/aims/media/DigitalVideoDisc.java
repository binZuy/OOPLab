package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
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
			return String.format("DVD %d. %s - %s - %s - %d minutes: %.2f $",
					getId(),getTitle(), getCategory(),getDirector(),getLength(),getCost());
	}
	
	public boolean isMatch(String titleToMatch) {
		return getTitle().toLowerCase().contains(titleToMatch.toLowerCase());
	}
	
	// play() method 
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: "+ this.getLength());
		}
		else {
			throw new PlayerException("ERROR: DVD Length is non-positive!");
		}
	}
}
	