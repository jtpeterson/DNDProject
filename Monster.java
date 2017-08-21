import java.util.*;
/* TODO list
* toString is missing: attack, full attack, space, reach, special attacks, special qualitites, skills
* Implement attack, full attack, space, reach
* Determine base skill ranks of a creature
* Determine new skill ranks of a creature if main 6 stats are adjusted
* Getters and Setters for every type of stat (ugh) This will be necessary for templates to work without overwriting the OG monster
* Note: Setters may be unnecessary, but should be created just in case they are needed down the line

*/

public class Monster {
	private MonsterSize size;
	private String type;
	private int hp;
	private int ac;
	private int speed;
	private int str = 10;
	private int dex = 10;
	private int con = 10;
	private int intelligence = 10;
	private int wis = 10;
	private int cha = 10;
	private int initiative;
	private int fortitude;
	private int reflex;
	private int will;
	private String name;
	private int baseAttack;
	private int grapple;
	private String environment;
	private String organization;
	private int cr;
	private String alignment;
	private String spellLikeAbilities;
	private String treasure;
	private String advancement;
	private int adjustment;
	public String description;
	public String tactics;
	Hashtable<String, Integer> abilities = new Hashtable<String, Integer>();
	Hashtable<String, String> specialAbilities = new Hashtable<String, String>();
	//specialAbilities.keys() for list of abilities,
	//specialAbilities.valueOf(key) for description of abilities
	ArrayList<String> feats = new ArrayList();
	public Monster() {
		//do nothing, this is so everything compiles when MonsterMain is compiled.
	}
	public Monster(String name, int hp, int ac, MonsterSize size) {
		this.name = name.toLowerCase();
		this.hp = hp;
		this.ac = ac;
		this.size = size;
	}
	public Monster(MonsterSize size, int hp, int ac, int str, int dex, int con, int intelligence, int wis, int cha, int initiative, int fortitude,
		int reflex, int will, String name, int baseAttack, int grapple, String environment, String organization, int cr, String alignment,
		String spellLikeAbilities, String treasure, String advancement, int adjustment, String description, String tactics, 
		Hashtable<String, String> specialAbilities, ArrayList<String> feats, String type) {
		this.size = size;
		this.hp = hp;
		this.ac = ac;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.intelligence = intelligence;
		this.wis = wis;
		this.cha = cha;
		this.initiative = initiative;
		this.fortitude = fortitude;
		this.reflex = reflex;
		this.will = will;
		this.name = name;
		this.baseAttack = baseAttack;
		this.grapple = grapple;
		this.environment = environment;
		this.organization = organization;
		this.cr = cr;
		this.alignment = alignment;
		this.spellLikeAbilities = spellLikeAbilities;
		this.treasure = treasure;
		this.advancement = advancement;
		this.adjustment = adjustment;
		this.description = description;
		this.tactics = tactics;
		this.specialAbilities = specialAbilities;
		this.feats = feats;
		this.type = type;
	}
	public String toString() {
		//System.out.printf("Name: \n" + name);
		//System.out.println("hp: " + hp);
		//System.out.println("ac: " + ac);
		String builder = "Name: " + name.toUpperCase();
		builder = builder + "\nSize/Type: " + size + " " + type + "\nHP: " + hp;
		builder = builder + "\nInitiative: " + initiative + "\nSpeed: " + speed + "\nAC: " + ac;
		builder = builder + "\nBase Attack/Grapple: " + baseAttack + "/" + grapple;
		builder = builder + "\nSaves: Fort " + fortitude + " Ref " + reflex + " Will " + will;
		builder = builder + "\nAbilities: Str " + str + ", Dex " + dex + ", Con " + con + ", Int " + intelligence + ", Wis " + wis + ", Cha " + cha;
		builder = builder + "\nFeats: " + feats + "\nEnvironment: " + environment;
		builder = builder + "\nOrganization: " + organization + "\nChallenge Rating: " + cr;
		builder = builder + "\nTreasure: " + treasure + "\nAlignment: " + alignment;
		builder = builder + "\nAdvancement: " + advancement + "\nLevel Adjustment: " + adjustment;
		builder = builder + "\n" + description + "\nCOMBAT\n" + tactics;
		//System.out.println(builder);
		return builder;
	}

	public String getType() {
		return type;
	}

	public void setType() {
		this.type = type;
	}

	public MonsterSize getSize() {
		return size;
	}

	public void setSize(MonsterSize size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAC() {
		return ac;
	}

	public void setAC(int ac) {
		this.ac = ac;
	}

	public int getHP() {
		return hp;
	}

	public void setHP(int hp) {
		this.hp = hp;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public int getInt() {
		return intelligence;
	}

	public void setInt(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWis() {
		return wis;
	}

	public void setWis(int wis) {
		this.wis = wis;
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getFortitude() {
		return fortitude;
	}

	public void setFortitude(int fortitude) {
		this.fortitude = fortitude;
	}

	public int getReflex() {
		return reflex;
	}

	public void setReflex(int reflex) {
		this.reflex = reflex;
	}

	public int getWill() {
		return will;
	}

	public void setWill(int will) {
		this.will = will;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public int getGrapple() {
		return grapple;
	}

	public void setGrapple(int grapple) {
		this.grapple = grapple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public int getCR() {
		return cr;
	}

	public void setCR(int cr) {
		this.cr = cr;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public String getSpellLikeAbilities() {
		return spellLikeAbilities;
	}

	public void setSpellLikeAbilities(String spellLikeAbilities) {
		this.spellLikeAbilities = spellLikeAbilities;
	}

	public Hashtable<String, String> getSpecialAbilities() {
		return specialAbilities;
	}

	public void setSpecialAbilities(Hashtable<String, String> specialAbilities) {
		this.specialAbilities = specialAbilities;
	}

	public ArrayList<String> getFeats() {
		return feats;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getTreasure() {
		return treasure;
	}

	public void setTreasure(String treasure) {
		this.treasure = treasure;
	}

	public String getAdvancement() {
		return advancement;
	}

	public void setAdvancement(String advancement) {
		this.advancement = advancement;
	}

	public int getLevelAdjustment() {
		return adjustment;
	}

	public void setLevelAdjustment(int adjustment) {
		this.adjustment = adjustment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTactics() {
		return tactics;
	}

	public void setTactics(String tactics) {
		this.tactics = tactics;
	}


}