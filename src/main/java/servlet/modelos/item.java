package servlet.modelos;

public class item {

	private int id;
	private String name;
	private String effect;

	public item(int id, String name, String effect) {
		this.id = id;
		this.name = name;
		this.effect = effect;
	}

	public item() {
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
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}

}	

