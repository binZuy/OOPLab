package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks;
	
	// constructor
	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
		// TODO Auto-generated constructor stub
		super(id, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = new ArrayList<>();
	}

	// getter 
	public String getArtist() {
		return artist;
	}
	
	
	// them track
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track is added successfully.");
		}
		else 
			System.out.println("Track already exists in the CD.");
	}
	
	// xoa track
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track is removed successfully.");
		}
		else 
			System.out.println("Track does not exist in the CD.");
	}
	
	public int getLength() {
		int totalLength = 0; 
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	// play() method
	 public void play() {
	        System.out.println("Playing CD: " + getTitle());
	        System.out.println("CD artist: " + artist);
	        System.out.println("CD length: " + getLength() + " minutes");

	        // Loop through each track and call play() method
	        for (Track track : tracks) {
	            track.play();
	        }
	 }
	 
	 // override toString
	 public String toString() {
			return String.format("CD %d. %s - %s - %s - %d minutes: %.2f $",
					getId(),getTitle(), getCategory(),getArtist(), getLength(),getCost());
	 }
	 
	 // lay tracks
	 public ArrayList<Track> getTracks(){
		 return tracks;
	 }
}
