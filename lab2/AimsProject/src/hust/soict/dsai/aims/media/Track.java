package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	// constructor
	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	// play() method
	public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " seconds");
    }
}
