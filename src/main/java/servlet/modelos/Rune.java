package servlet.modelos;

public class Rune{
	private int id;	
	private String tier;
	private String name;
	private String description;

	public Rune(int id, String tier, String name, String description) {
		this.id = id;
		this.tier = tier;
		this.name = name;
		this.description = description;
	}
	public Rune() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}	

