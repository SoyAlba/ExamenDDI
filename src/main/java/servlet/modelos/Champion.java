package servlet.modelos;

public class Champion {

	private int id;
	private String name;
	private String title;
	private String lore;
	private String tags;

	public Champion(int id, String name, String title, String lore, String tags) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.lore = lore;
		this.tags = tags;
	}
	public Champion() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLore() {
		return lore;
	}
	public void setLore(String lore) {
		this.lore = lore;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
}
