package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Disc extends Media{
	private int length;
	private String director;
	
	public Disc(int id, String title, String category, float cost, int length, String director) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost);
		this.length = length;
		this.director = director;
	}
	public Disc(int id, String title, String category, float cost, String director) {
		super(id, title, category, cost);
		this.director = director;
	}
	public Disc(int id, String title, String category, float cost) {
		super(id, title, category,cost);
	}
	public Disc(int id, String title) {
		super(id,title);
	}
	
	
	// getter methods
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		
	}
	
}
