package servlet.modelos;

public class ChampionAbiliti{
    private int id;
    private String champion;
    private String name;
    private String description;
    private String effect;
    private int cost;
    private int range;

    public ChampionAbiliti(int id, String champion, String name, String description, String effect, int cost, int range) {
        this.id = id;
        this.champion = champion;
        this.name = name;
        this.description = description;
        this.effect = effect;
        this.cost = cost;
        this.range = range;
    }

    public ChampionAbiliti() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    

	
}
