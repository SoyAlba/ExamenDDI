package servlet.modelos;

public class ChampionTip {
	
	private int id;
	private String champion;
	private String tip;
	
	public ChampionTip(int id, String champion, String tip) {
		this.id = id;
		this.champion = champion;
		this.tip = tip;
	}
	public ChampionTip() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getTip() {
		return tip;
	}
	public String getChampion() {
		return champion;
	}
	public void setId(int i) {
		this.id = i;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public void setChampion(String champion) {
		this.champion = champion;
	}
}