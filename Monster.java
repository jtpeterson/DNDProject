import java.util.*;
/* TODO list
* Implement every type of stat
* Determine base skill ranks of a creature
* Determine new skill ranks of a creature if main 6 stats are adjusted
* Getters and Setters for every type of stat (ugh) This will be necessary for templates to work without overwriting the OG monster
* Note: Setters may be unnecessary, but should be created just in case they are needed down the line

*/

public class Monster {
	private MonsterSize size;
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
	private int cr;
	private String alignment;
	private String spellLikeAbilities;
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
	public String toString() {
		//System.out.printf("Name: \n" + name);
		//System.out.println("hp: " + hp);
		//System.out.println("ac: " + ac);
		String builder = "Size: " + size + "\nName: " + name.toUpperCase() + "\nHP: " + hp + "\nAC: " + ac;
		//System.out.println(builder);
		return builder;
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

	public Hashtable<String, Integer> getAbilities() {
		return abilities;
	}

	public void setAbilities(Hashtable<String, Integer> abilities) {
		this.abilities = abilities;
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


}