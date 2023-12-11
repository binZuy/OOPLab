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
	
	// Override equals 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;  // Not an instance of Track class
        }
        Track otherTrack = (Track) obj;
        return title != null ? title.equals(otherTrack.title) : otherTrack.title == null &&
               length == otherTrack.length;
    }

	// play() method
	public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " seconds");
    }
}
