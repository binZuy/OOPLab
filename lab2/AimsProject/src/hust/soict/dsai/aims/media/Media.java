package hust.soict.dsai.aims.media;

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
	
}
