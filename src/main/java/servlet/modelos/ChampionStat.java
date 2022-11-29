package servlet.modelos;

public class ChampionStat {

	private int champion;
	private String name;
	private double value;
	private double modifier_per_level;

	public ChampionStat(int champion, String name, double value, double modifier_per_level) {
		this.champion = champion;
		this.name = name;
		this.value = value;
		this.modifier_per_level = modifier_per_level;
	}

	public ChampionStat() {
		// TODO Auto-generated constructor stub
	}

	public int getChampion() {
		return champion;
	}

	public void setChampion(int champion) {
		this.champion = champion;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getModifier_per_level() {
		return modifier_per_level;
	}

	public void setModifier_per_level(double modifier_per_level) {
		this.modifier_per_level = modifier_per_level;
	}
	
}
